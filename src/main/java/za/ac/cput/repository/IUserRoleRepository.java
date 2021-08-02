package za.ac.cput.repository;

import za.ac.cput.entity.UserRole;

import java.util.Set;

/*  IUserRoleRepository.java
    UserRole Repository interface
    Author: Adriaan Burger(219014868)
    Date: 25 July 2021
 */
public interface IUserRoleRepository extends IRepository<UserRole, String>{
    public Set<UserRole> getAll();
}
