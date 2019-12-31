package com.shf.sso.user.service;

import com.shf.sso.user.entity.user.TPermission;

import java.util.List;

public interface PermissionService {
    List<TPermission> findByName(String username);
}
