/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.log.Log;
import java.util.ArrayList;
import java.util.List;
import models.Codes;
import models.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jamal
 */
public class CodesDAOImpl implements CodesDao {

    // Indica el bean que contiene la configuración del sessionFactory en el archivo applicationContext
    @Autowired
    private SessionFactory sessionFactory;

    public CodesDAOImpl() {
    }

    public CodesDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Obtiene los códigos de un usuario dado su id
    @Override
    public List<Codes> getCodesByIdUser(int id_user) {

        Session session = this.sessionFactory.getCurrentSession();
        List<Codes> codes = null;
        try {
            session.beginTransaction();
            codes = session.createQuery("from Codes where id_user = " + id_user).list();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            session.close();
        }
        return codes;
    }

    //comprueba si ya existe un cófdigo generado
    @Override
    public boolean existCode(String code) {
        boolean exist = false;
        Session session = this.sessionFactory.getCurrentSession();
        Codes codes = null;

        try {
            session.beginTransaction();
            codes = (Codes) session.createQuery("from Codes where code = " + code).uniqueResult();

            if (codes == null) {
                exist = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return exist;
    }

    //Crea un nuevo código y lo asigna al usuario logueado
    @Override
    public void newCode(String code, Users user) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Codes codes = new Codes();
            codes.setCode(code);
            codes.setRedeem('N');
            codes.setUser(user);
            session.save(codes);
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    //Elimina un código
    @Override
    public void deleteCode(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Codes code = (Codes) session.get(Codes.class, id);
            session.delete(code);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public void redeemCode(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Codes code = (Codes) session.get(Codes.class, id);
            code.setRedeem('S');
            session.update(code);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

}
