package za.ac.cput.repository;

import za.ac.cput.entity.Role;

import java.util.HashSet;
import java.util.Set;

/*  RoleRepository.java
    Role Repository implementation
    Author: Adriaan Burger(219014868)
    Date: 25 July 2021
 */
public class RoleRepository implements IRoleRepository {
    private static RoleRepository repository = null;
    private Set<Role> roleDB = null;

    private RoleRepository(){
        roleDB = new HashSet<Role>();
    }

    public static RoleRepository getRepository(){
        if(repository == null){
            repository = new RoleRepository();
        }
        return  repository;
    }

    @Override
    public Role create(Role role) {
        boolean success = roleDB.add(role);
        if(!success)
            return null;
        return role;

    }

    @Override
    public Role read(String roleID) {
        for(Role r: roleDB)
        {
            if(r.getRoleID().equals(roleID)){
                return r;
            }
        }
        return null;

    }

    @Override
    public Role update(Role role) {
        Role oldRole = read(role.getRoleID());
        if(oldRole != null) {
            roleDB.remove(oldRole);
            roleDB.add(role);
            return role;
        }
        return role;

    }

    @Override
    public boolean delete(String roleID) {
        Role roleToDelete = read(roleID);
        if(roleToDelete == null)
            return false;
        roleDB.remove(roleToDelete);
        return true;
    }

    @Override
    public Set<Role> getAll() {
        return roleDB;
    }
}
