package za.ac.cput.repository;

import za.ac.cput.entity.User;

import java.util.HashSet;
import java.util.Set;

/*  UserRepository.java
    User Repository implementation
    Author: Adriaan Burger(219014868)
    Date: 25 July 2021
 */
public class UserRepository implements IUserRepository {
    private static UserRepository repository = null;
    private Set<User> userDB = null;

    private UserRepository(){
        userDB = new HashSet<User>();
    }

    public static UserRepository getRepository(){
        if(repository == null){
            repository = new UserRepository();
        }
        return  repository;
    }

    @Override
    public User create(User user) {
        boolean success = userDB.add(user);
        if(!success)
            return null;
        return user;
    }

    @Override
    public User read(String userID) {
        for(User u: userDB)
        {
            if(u.getUserID().equals(userID)){
                return u;
            }
        }
       return null;
    }

    @Override
    public User update(User user) {
        User oldUser = read(user.getUserID());
        if(oldUser != null) {
            userDB.remove(oldUser);
            userDB.add(user);
            return user;
        }
        return user;
    }

    @Override
    public boolean delete(String userID) {
        User userToDelete = read(userID);
        if(userToDelete == null)
            return false;
        userDB.remove(userToDelete);
        return true;
    }

    @Override
    public Set<User> getAll() {
        return userDB;
    }
}
              