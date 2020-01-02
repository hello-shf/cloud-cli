package com.shf.jdbc.user.service;

import com.shf.entity.user.TPermission;

import java.util.List;

public interface PermissionService {
    List<TPermission> findByName(String username);
}
