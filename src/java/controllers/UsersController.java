package controllers;

import dao.UsersDAOImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * author: Jamal
 * 
 */
@Controller
public class UsersController {

    //Indica la clase entidad de la cual se va a realizar el acceso a la DB
    @Autowired
    private UsersDAOImpl usersDao;

    /* Inicia sesión mediante el usuario y la contraseña proporcionadas
     * si el usuario no existe redirige a la página principal con error  
     */
    @RequestMapping("/login")
    public ModelAndView login(HttpSession session, HttpServletRequest request) {

        ModelAndView model = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Users user = usersDao.getUserByUsernamePassword(username, password);

            if (user != null) {
                session.setAttribute("user", user);
                model = new ModelAndView("home");
                model.addObject("user", user);
            } else {
                model = new ModelAndView("index");
                model.addObject("error", error());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    /* Inserta un nuevo usuario en la baase de datos mediante los datos proporcionadas
     * si el usuario ya existe redirige a la página principal con error de que existe 
     */
    @RequestMapping("/register")
    public ModelAndView register(HttpSession session, HttpServletRequest request) {
        session.invalidate();
        ModelAndView model = null;
        boolean existUser;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        boolean created = false;
        try {
            existUser = usersDao.existUser(username);

            if (existUser) {
                usersDao.newUser(username, password, fullname);
                created = true;
                model = new ModelAndView("index");
                model.addObject("created", created);
            } else {
                model = new ModelAndView("index");
                model.addObject("errorExist", errorExist());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    // Cierra la sesión inicializando la variable session y redirige a la página principal
    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        ModelAndView model = new ModelAndView("index");
        return model;
    }

    private String error() {
        return "Usuario o contraseña no válidos!!";
    }

    private String errorExist() {
        return "El usuario ya existe!! Inicia sesión";
    }

}
