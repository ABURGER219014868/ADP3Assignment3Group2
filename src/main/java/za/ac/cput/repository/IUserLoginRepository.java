package za.ac.cput.repository;

import za.ac.cput.entity.UserLogin;

import java.util.*;

public interface IUserLoginRepository extends IRepository<UserLogin, String>{
    public Set<UserLogin> getAll();
}
