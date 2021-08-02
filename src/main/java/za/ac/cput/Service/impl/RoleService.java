package za.ac.cput.Service.impl;

import za.ac.cput.entity.Role;
import za.ac.cput.repository.RoleRepository;

import java.util.Set;

/*  RoleService.java
    Role Service implementation
    Author: Adriaan Burger(219014868)
    Date: 27 July 2021
 */
public class RoleService implements IRoleService{
    private static RoleService service = null;
    private RoleRepository repository = null;

    private RoleService(){ this.repository = RoleRepository.getRepository();}

    public static RoleService getService(){
        if(service == null){
            service = new RoleService();
        }
        return service;
    }

    @Override
    public Role create(Role role) { return this.repository.create(role);  }

    @Override
    public Role read(String roleId) { return this.repository.read(roleId); }

    @Override
    public Role update(Role role) {  return this.repository.update(role);  }

    @Override
    public boolean delete(String roleId) {  return this.repository.delete(roleId); }

    @Override
    public Set<Role> getAll() {   return this.repository.getAll();  }
}
