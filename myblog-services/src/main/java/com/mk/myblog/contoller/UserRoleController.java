package com.mk.myblog.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.myblog.dto.UserRole;
import com.mk.myblog.service.UserRoleService;

@RestController
@RequestMapping(value = "/user-role")
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;

	@PostMapping
	public UserRole saveUserRole(@RequestBody final UserRole userRole) {
		return userRoleService.saveUserRole(userRole);
	}

	@DeleteMapping(value = "/{id}")
	public void removeUserRole(@PathVariable("id") final Integer userRoleId) {
		userRoleService.removeUserRole(userRoleId);
	}

}
