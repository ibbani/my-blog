package com.mk.myblog.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mk.myblog.dto.Post;
import com.mk.myblog.service.PostService;

@RestController
@RequestMapping(value = "/post")
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping(value = "?search={searchText}")
	public List<Post> fetchAll(@RequestParam(value = "search", required = false) final String searchText,
			final Pageable pageable) {
		return postService.fetchAll(searchText, pageable);
	}

	@PostMapping
	public Post savePost(@RequestBody Post post) {
		return postService.savePost(post);
	}

	@PutMapping(value = "/{id}/likes/{likes}")
	public void updateLikes(@PathVariable("id") final Integer commentId, @PathVariable("likes") final String likes) {
		postService.updateLikes(commentId, likes);
	}

}
