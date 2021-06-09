package kg.itacademy.demo.service;


import kg.itacademy.demo.entity.UserRole;
import kg.itacademy.demo.model.RoleModel;

public interface UserRoleService {
    UserRole save(UserRole userRole);
    UserRole save(RoleModel userRoleModel);
    UserRole findById(Long id);
}
