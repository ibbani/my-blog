package com.mk.myblog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mk.myblog.domain.PostDomain;
import com.mk.myblog.dto.Category;
import com.mk.myblog.dto.Post;
import com.mk.myblog.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepo;

	@Autowired
	private Mapper mapper;

	@Transactional(readOnly = true)
	public List<Post> fetchAll(String searchText, final Pageable pageable) {
		if (searchText.isEmpty()) {
			searchText = "%";
		}

		Sort sort = pageable.getSort();
		if (sort.isEmpty()) {
			sort = Sort.by("CREATED_DATE").descending();
		}

		final List<Post> posts = new ArrayList<>();
		postRepo.findByTitleLikeOrTagsLikeOrDescriptionLike(searchText, searchText, searchText, pageable).stream()
				.forEach(p -> {
					Category category = mapper.map(p.getCategory(), Category.class);
					posts.add(new Post(null, p.getTags(), p.getDescription(), category, 0));
				});

		return posts;
	}

	@Transactional(readOnly = false, rollbackFor = RuntimeException.class)
	public Post savePost(final Post post) {
		final PostDomain postDomain = mapper.map(post, PostDomain.class);
		postRepo.save(postDomain);
		post.setId(postDomain.getId());
		return post;
	}

	@Transactional(readOnly = false, rollbackFor = RuntimeException.class)
	public void updateLikes(Integer postId, String likes) {
		final Optional<PostDomain> postOptional = postRepo.findById(postId);
		if (postOptional.isPresent()) {
			final PostDomain postDomain = postOptional.get();
			Integer likesCount = postDomain.getLikes();
			postDomain.setLikes(likes.equalsIgnoreCase("Y") ? likesCount++ : likesCount--);
			postRepo.save(postDomain);
		} else {
			throw new RuntimeException("Invalid input");
		}
	}

}
