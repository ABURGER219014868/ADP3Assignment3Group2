package za.ac.cput.Service.impl;

import za.ac.cput.entity.User;
import za.ac.cput.repository.UserRepository;

import java.util.Set;
/*  UserService.java
    User Service implementation
    Author: Adriaan Burger(219014868)
    Date: 27 July 2021
 */
public class UserService implements IUserService{
    private static UserService service = null;
    private UserRepository repository = null;

    private UserService(){  this.repository = UserRepository.getRepository(); }

    public static UserService getService(){
        if(service == null){
            service = new UserService();
        }
        return service;
    }

    @Override
    public User create(User user) {  return this.repository.create(user); }

    @Override
    public User read(String userId) {  return this.repository.read(userId); }

    @Override
    public User update(User user) {  return this.repository.update(user); }

    @Override
    public boolean delete(String userId) {  return this.repository.delete(userId); }

    @Override
    public Set<User> getAll() {  return this.repository.getAll(); }

}
