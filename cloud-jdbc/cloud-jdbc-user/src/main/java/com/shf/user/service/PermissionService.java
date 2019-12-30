package com.shf.user.service;

import com.shf.user.entity.user.TPermission;

import java.util.List;

public interface PermissionService {
    List<TPermission> findByName(String username);
}
