package za.ac.cput.service.impl;

import za.ac.cput.entity.User;
import za.ac.cput.service.IService;

import java.util.Set;
/*  IUserService.java
    User Service interface
    Author: Adriaan Burger(219014868)
    Date: 27 July 2021
 */
public interface IUserService extends IService<User,String> {
    public Set<User> getAll();
}
