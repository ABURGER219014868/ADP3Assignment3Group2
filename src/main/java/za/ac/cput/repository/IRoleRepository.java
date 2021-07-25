package za.ac.cput.repository;

import za.ac.cput.Entity.Role;

import java.util.Set;
/*  IRoleRepository.java
    Role Repository interface
    Author: Adriaan Burger(219014868)
    Date: 25 July 2021
 */
public interface IRoleRepository extends IRepository<Role, String>{
    public Set<Role> getAll();
}
