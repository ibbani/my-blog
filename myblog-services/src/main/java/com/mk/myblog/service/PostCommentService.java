package com.mk.myblog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mk.myblog.domain.PostCommentDomain;
import com.mk.myblog.domain.PostDomain;
import com.mk.myblog.dto.PostComment;
import com.mk.myblog.repository.PostCommentRepository;
import com.mk.myblog.repository.PostRepository;

@Service
public class PostCommentService {

	@Autowired
	private PostRepository postRepo;

	@Autowired
	private PostCommentRepository postCommentRepo;

	@Transactional(readOnly = false, rollbackFor = RuntimeException.class)
	public PostComment saveComment(PostComment postComment) {
		final Optional<PostDomain> postDomainOptional = postRepo.findById(postComment.getPostId());
		if (postDomainOptional.isPresent()) {
			final PostCommentDomain postCommentDomain = new PostCommentDomain(postDomainOptional.get(),
					postComment.getTitle(), postComment.getTags(), postComment.getDescription(), 0);
			postCommentRepo.save(postCommentDomain);
			postComment.setId(postCommentDomain.getId());
			return postComment;
		} else {
			throw new RuntimeException("Invalid input");
		}
	}

	@Transactional(readOnly = false, rollbackFor = RuntimeException.class)
	public void updateLikes(Integer commentId, String likes) {
		final Optional<PostCommentDomain> postCommentOptional = postCommentRepo.findById(commentId);
		if (postCommentOptional.isPresent()) {
			final PostCommentDomain postCommentDomain = postCommentOptional.get();
			Integer likesCount = postCommentDomain.getLikes();
			postCommentDomain.setLikes(likes.equalsIgnoreCase("Y") ? likesCount++ : likesCount--);
			postCommentRepo.save(postCommentDomain);
		} else {
			throw new RuntimeException("Invalid input");
		}
	}

}
