package com.medi.MedicalApplication.repository;

import com.medi.MedicalApplication.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByRoleId(String roleId);

    Role findByRoleName(String roleName);

    void deleteByRoleId(String roleId);
}
