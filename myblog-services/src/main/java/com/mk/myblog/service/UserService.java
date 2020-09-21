package com.mk.myblog.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mk.myblog.domain.UserDomain;
import com.mk.myblog.dto.Role;
import com.mk.myblog.dto.User;
import com.mk.myblog.dto.UserRole;
import com.mk.myblog.exception.AppException;
import com.mk.myblog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private Mapper mapper;

	@Transactional(readOnly = true)
	public List<User> fetchUsers() {
		List<User> users = new ArrayList<>();
		Iterable<UserDomain> usersFromRepo = userRepo.findAll();

		usersFromRepo.forEach(u -> {
			users.add(this.getUser(u));
		});

		return users;
	}

	@Transactional(readOnly = true)
	public User fetchUser(final Integer userId) {
		final Optional<UserDomain> userFromRepo = userRepo.findById(userId);
		if (userFromRepo.isPresent()) {
			return this.getUser(userFromRepo.get());
		} else {
			throw new AppException(404, "User not found", null);
		}
	}

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public User updateUser(final Integer userId, final User userDto) {
		final Optional<UserDomain> user = userRepo.findById(userId);
		if (user.isPresent()) {
			final UserDomain userFromRepo = user.get();
			userFromRepo.setMobile(userDto.getMobile());
			userRepo.save(userFromRepo);
		}
		return userDto;
	}

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public User registerUser(final User user) {
		final UserDomain userDomain = mapper.map(user, UserDomain.class);
		userRepo.save(userDomain);
		user.setUserId(userDomain.getId());
		return user;
	}

	private User getUser(UserDomain userDomain) {
		byte[] bytes = null;
		try {
			if (userDomain.getProfilePic() != null) {
				bytes = userDomain.getProfilePic().getBytes(1, (int) userDomain.getProfilePic().length());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		final User user = new User(userDomain.getId(), userDomain.getFirstName(), userDomain.getLastName(),
				userDomain.getMobile(), userDomain.getEmailId(), userDomain.getCreatedDate(), bytes);

		final List<UserRole> userRoles = new ArrayList<>();
		userDomain.getUserRoles().stream().forEach(ur -> {
			final Role role = mapper.map(ur.getRole(), Role.class);
			userRoles.add(new UserRole(ur.getId(), null, role));
		});
		user.setUserRoles(userRoles);
		return user;
	}

}
