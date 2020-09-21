package com.mk.myblog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mk.myblog.domain.RoleDomain;
import com.mk.myblog.domain.UserDomain;
import com.mk.myblog.domain.UserRoleDomain;
import com.mk.myblog.dto.UserRole;
import com.mk.myblog.repository.RoleRepository;
import com.mk.myblog.repository.UserRepository;
import com.mk.myblog.repository.UserRoleRepository;

@Service
public class UserRoleService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Transactional(readOnly = false, rollbackFor = RuntimeException.class)
	public UserRole saveUserRole(final UserRole userRole) {
		final Optional<UserDomain> userOptional = userRepo.findById(userRole.getId());
		final Optional<RoleDomain> roleOptional = roleRepo.findById(userRole.getId());
		if (userOptional.isPresent() && roleOptional.isPresent()) {
			UserRoleDomain userRoleDomain = new UserRoleDomain(userOptional.get(), roleOptional.get());
			userRoleRepository.save(userRoleDomain);
			return userRole;
		} else {
			throw new RuntimeException("Invalid input");
		}
	}

	@Transactional(readOnly = false, rollbackFor = RuntimeException.class)
	public void removeUserRole(Integer userRoleId) {
		final Optional<UserRoleDomain> userRoleOptional = userRoleRepository.findById(userRoleId);
		if (userRoleOptional.isPresent()) {
			userRoleRepository.delete(userRoleOptional.get());
		} else {
			throw new RuntimeException("Invalid input");
		}
	}

}
