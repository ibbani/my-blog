package com.mk.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mk.myblog.domain.RoleDomain;

@Repository
public interface RoleRepository extends JpaRepository<RoleDomain, Integer> {

}
