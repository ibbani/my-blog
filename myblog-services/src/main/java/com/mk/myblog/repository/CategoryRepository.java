package com.mk.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mk.myblog.domain.CategoryDomain;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDomain, Integer> {

}
