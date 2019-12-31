package com.shf.sso.dao;

import com.shf.sso.user.entity.user.TPermission;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PermissionDao extends CrudRepository<TPermission, Long>, JpaSpecificationExecutor<TPermission> {
    List<TPermission> findByName(String username);
}
