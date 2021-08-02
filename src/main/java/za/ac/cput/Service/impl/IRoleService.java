package za.ac.cput.Service.impl;

import za.ac.cput.entity.Role;
import za.ac.cput.Service.IService;

import java.util.Set;

/*  IRoleService.java
    Role Service interface
    Author: Adriaan Burger(219014868)
    Date: 27 July 2021
 */
public interface IRoleService extends IService<Role,String> {
    public Set<Role> getAll();
}
