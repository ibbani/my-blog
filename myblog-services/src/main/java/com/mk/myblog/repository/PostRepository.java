package com.mk.myblog.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mk.myblog.domain.PostDomain;

@Repository
public interface PostRepository extends PagingAndSortingRepository<PostDomain, Integer> {

	List<PostDomain> findByTitleLikeOrTagsLikeOrDescriptionLike(String title, String tags, String description,
			Pageable pageable);

}
