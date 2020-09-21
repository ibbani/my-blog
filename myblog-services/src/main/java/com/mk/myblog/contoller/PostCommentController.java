package com.mk.myblog.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.myblog.dto.PostComment;
import com.mk.myblog.service.PostCommentService;

@RestController
@RequestMapping(value = "/comment")
public class PostCommentController {

	@Autowired
	private PostCommentService postCommentService;

	@PostMapping
	public PostComment saveComment(@RequestBody final PostComment postComment) {
		return postCommentService.saveComment(postComment);
	}

	@PutMapping(value = "{id}/likes/{likes}")
	public void updateLikes(@PathVariable("id") final Integer commentId, @PathVariable("likes") final String likes) {
		postCommentService.updateLikes(commentId, likes);
	}

}
