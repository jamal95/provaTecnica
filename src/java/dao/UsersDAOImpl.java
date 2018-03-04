/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author jamal
 */
@Component
public class UsersDAOImpl implements UsersDao {
    // Indica el bean que contiene la configuración del sessionFactory en el archivo applicationContext
    @Autowired
    private SessionFactory sessionFactory;

    public UsersDAOImpl() {
    }

    public UsersDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Crea un nuevo usuario con los datos proporcionados
     * @param username
     * @param password
     * @param fullName
     */
    @Override
    public void newUser(String username, String password, String fullName) {
        Session session = this.sessionFactory.getCurrentSession();
        Users user = null;
        try {
            session.beginTransaction();
            user = new Users();
            user.setUsername(username);
            user.setPassword(password);
            user.setFullname(fullName);
            session.save(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }

    //Obtiene un usuario mediante su id
    @Override
    public Users getUserById(int userId) {
        Users user = null;
        Session session = this.sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            user = (Users) session.get(Users.class, userId);
            session.getTransaction().commit();
        } catch (Exception e) {
        }

        return user;
    }

    //Obtiene un usuario mediante su usuario y contraseña
    @Override
    public Users getUserByUsernamePassword(String username, String password) {
        Session session = this.sessionFactory.getCurrentSession();
        Users user = null;
        try {
            session.beginTransaction();
            user = (Users) session.createQuery("from Users where username = '" + username + "' "
                    + "                               and password = '" + password + "'").uniqueResult();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            session.close();
        }

        return user;
    }

    //Comprueba si existe un usuario
    @Override
    public boolean existUser(String username) {
        Session session = this.sessionFactory.getCurrentSession();
        Users user = null;
        boolean exit = false;

        try {
            session.beginTransaction();
            user = (Users) session.createQuery("from Users where username = '" + username + "' ").uniqueResult();

            if (user == null) {
                exit = true;
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            session.close();
        }
        return exit;
    }

}
