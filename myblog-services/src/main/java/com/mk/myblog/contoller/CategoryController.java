package com.mk.myblog.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.myblog.dto.Category;
import com.mk.myblog.service.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public List<Category> fetchAll() {
		return categoryService.fetchAll();
	}

	@PostMapping
	public Category saveCategory(final Category category) {
		return categoryService.saveCategory(category);
	}

}
