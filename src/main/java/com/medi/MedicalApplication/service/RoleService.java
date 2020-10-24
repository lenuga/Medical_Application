package com.medi.MedicalApplication.service;

import com.medi.MedicalApplication.model.Role;
import com.medi.MedicalApplication.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role saveRole(Role role) { return roleRepository.save(role); }
    public List<Role> saveRoles(List<Role> roles){return roleRepository.saveAll(roles);}

    public List<Role> getRoles(){ return roleRepository.findAll(); }

    public  Role getRoleByRoleId(String roleId){ return roleRepository.findByRoleId(roleId); }

    public Role getRoleByRoleName(String roleName){ return roleRepository.findByRoleName(roleName); }

    public String deleteRole(String roleId) {
        roleRepository.deleteByRoleId(roleId);
        return "Role removed!! "+ roleId;
    }
    public Role updateRole(Role role)
    {
//        Role exisitingRole = repository.findByRoleId(role.getRoleId());
//        exisitingRole.setFirstName(role.getFirstName());
//        exisitingRole.setAddress(role.getAddress());
//        exisitingRole.setCourseId(role.getCourseId());
        Role exisitingRole = new Role();
        return roleRepository.save(exisitingRole);

    }

}
