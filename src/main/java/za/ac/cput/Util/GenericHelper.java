package za.ac.cput.Util;

import java.util.UUID;

/*  GenericHelper.java
    Helper class for generating ID's etc
    Author: Adriaan Burger(219014868)
    Date: 10 June 2021
 */
public class GenericHelper {
    public static String generateId(){
        return UUID.randomUUID().toString();
    }
}
