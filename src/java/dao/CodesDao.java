/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Codes;
import models.Users;

/**
 *
 * @author jamal
 */
public interface CodesDao {

    List<Codes> getCodesByIdUser(int id_user);

    boolean existCode(String code);
    
    void deleteCode(int id);
    
    void redeemCode(int id);
    
    void newCode(String code, Users user);

}
