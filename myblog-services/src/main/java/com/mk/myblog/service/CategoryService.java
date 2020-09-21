package com.mk.myblog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mk.myblog.domain.CategoryDomain;
import com.mk.myblog.dto.Category;
import com.mk.myblog.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	@Transactional(readOnly = true)
	public List<Category> fetchAll() {
		return categoryRepo.findAll().stream().map(c -> {
			return new Category(c.getId(), c.getName());
		}).collect(Collectors.toList());
	}

	@Transactional(readOnly = false, rollbackFor = RuntimeException.class)
	public Category saveCategory(Category category) {
		final CategoryDomain categoryDomain = new CategoryDomain(category.getName());
		categoryRepo.save(categoryDomain);
		category.setId(categoryDomain.getId());
		return category;
	}

}
