package za.ac.cput.repository;

import za.ac.cput.entity.UserRole;

import java.util.HashSet;
import java.util.Set;

/*  UserRoleRepository.java
    UserRole Repository implementation
    Author: Adriaan Burger(219014868)
    Date: 25 July 2021
 */
public class UserRoleRepository implements IUserRoleRepository {
    private static UserRoleRepository repository = null;
    private Set<UserRole> userRoleDB = null;

    private UserRoleRepository(){
        userRoleDB = new HashSet<UserRole>();
    }

    public static UserRoleRepository getRepository(){
        if(repository == null){
            repository = new UserRoleRepository();
        }
        return  repository;
    }

    @Override
    public UserRole create(UserRole userRole) {
        boolean success = userRoleDB.add(userRole);
        if(!success)
            return null;
        return userRole;
    }

    @Override
    public UserRole read(String userRoleID) {
        for(UserRole ur: userRoleDB)
        {
            if(ur.getUserRoleID().equals(userRoleID)){
                return ur;
            }
        }
        return null;

    }

    @Override
    public UserRole update(UserRole userRole) {
        UserRole oldUserRole = read(userRole.getUserRoleID());
        if(oldUserRole != null) {
            userRoleDB.remove(oldUserRole);
            userRoleDB.add(userRole);
            return userRole;
        }
        return userRole;
    }

    @Override
    public boolean delete(String userRoleID) {
        UserRole userRoleToDelete = read(userRoleID);
        if(userRoleToDelete == null)
            return false;
        userRoleDB.remove(userRoleToDelete);
        return true;
    }

    @Override
    public Set<UserRole> getAll() {
        return null;
    }
}
