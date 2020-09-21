package com.mk.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mk.myblog.domain.PostCommentDomain;

@Repository
public interface PostCommentRepository extends JpaRepository<PostCommentDomain, Integer> {

}
