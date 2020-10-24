package com.medi.MedicalApplication.controller;

import com.medi.MedicalApplication.model.Role;
import com.medi.MedicalApplication.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService service;

    @PostMapping("/addrole")
    public Role addRole(@RequestBody Role role) { return service.saveRole(role); }
    @PostMapping("/addRoles")
    public List<Role> addRoles(@RequestBody List<Role> roles) {
        return service.saveRoles(roles);
    }
    @GetMapping("/roles")
    public List<Role> findAllRoles(){
        return service.getRoles();
    }
    @GetMapping("/roleById/{id}")
    public Role findByRoleId(@PathVariable(value="id") String roleId) {return service.getRoleByRoleId(roleId);}
    @GetMapping("/role/{name}")
    public Role findByRoleName(@PathVariable(value = "name") String roleName) {return service.getRoleByRoleName(roleName); }
    @PutMapping("/update")
    public Role updateRole(@RequestBody Role role){
        return service.updateRole(role);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteRole(@PathVariable String id) {
        return service.deleteRole(id);
    }
}
