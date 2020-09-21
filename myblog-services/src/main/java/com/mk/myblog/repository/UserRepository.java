package com.mk.myblog.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mk.myblog.domain.UserDomain;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserDomain, Integer> {

}
