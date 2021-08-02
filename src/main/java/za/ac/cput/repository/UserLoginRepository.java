package za.ac.cput.repository;

import za.ac.cput.entity.UserLogin;

import java.util.HashSet;
import java.util.*;

public class UserLoginRepository implements IUserLoginRepository{
    private static UserLoginRepository repository = null;
    private Set<UserLogin> userloginDB = null;

    private UserLoginRepository(){
        userloginDB = new HashSet<UserLogin>();
    }

    public static UserLoginRepository getRepository(){
        if (repository == null) {
            repository = new UserLoginRepository();
        }
        return repository;
    }

    @Override
    public UserLogin Create(UserLogin userLogin) {
        boolean success = userloginDB.add(userLogin);
        if(!success)
            return null;
        return userLogin;
    }

    @Override
    public UserLogin Read(String userId) {
        for(UserLogin u: userloginDB)
        {
            if(u.getUserId().equals(userId)){
                return u;
            }
        }
        return null;
    }

    @Override
    public UserLogin Update(UserLogin userLogin) {
        UserLogin oldUser = Read(userLogin.getUserId());
        if(oldUser != null) {
            userloginDB.remove(oldUser);
            userloginDB.add(userLogin);
            return userLogin;
        }
        return userLogin;
    }

    @Override
    public boolean Delete(String userId) {
        UserLogin UsertoDelete = Read(userId);
        if(UsertoDelete == null)
        return false;
        userloginDB.remove(UsertoDelete);
        return true;
    }

    @Override
    public Set<UserLogin> getAll() {
        return userloginDB;
    }
}
