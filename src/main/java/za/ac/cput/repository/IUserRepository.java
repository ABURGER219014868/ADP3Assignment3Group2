package za.ac.cput.repository;

import za.ac.cput.entity.User;

import java.util.Set;

/*  IUserRepository.java
    User Repository interface
    Author: Adriaan Burger(219014868)
    Date: 25 July 2021
 */
public interface IUserRepository extends IRepository<User, String>
{
    public Set<User> getAll();
}
