package com.mk.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mk.myblog.domain.UserRoleDomain;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleDomain, Integer> {

}
