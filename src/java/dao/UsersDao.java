/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Users;
import org.springframework.stereotype.Component;

/**
 *
 * @author jamal
 */
@Component
public interface UsersDao{    
    
    Users getUserByUsernamePassword(String username, String password);
    
    void newUser(String username, String passwor, String fullName);
    
    boolean existUser(String username);
    
    Users getUserById(int userId);
    
}
