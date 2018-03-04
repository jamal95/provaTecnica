package controllers;

import dao.CodesDAOImpl;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import models.Codes;
import models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * author: Jamal
 * 
 */
@Controller
public class CodesController {

    //Indica la clase entidad de la cual se va a realizar el acceso a la DB
    @Autowired
    private CodesDAOImpl codesDao;

    //Obtiene los codigos de un usuario dado su id
    @RequestMapping("/seeCodes")
    public ModelAndView seeCodes(HttpSession session, HttpServletRequest request) {
        ModelAndView model = null;
        Users user = (Users) session.getAttribute("user");
        int id_user = user.getId();

        try {
            List<Codes> codes = codesDao.getCodesByIdUser(id_user);
            model = new ModelAndView("codes");
            model.addObject("codes", codes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    //Genera un codigo si no existe
    @RequestMapping("/generateCode")
    public ModelAndView generateCode(HttpSession session, HttpServletRequest request) {
        ModelAndView model = null;
        String code;
        Users user = (Users) session.getAttribute("user");

        try {
            code = generateRandomCode();
            if (!codesDao.existCode(code)) {
                codesDao.newCode(code, user);
            } else {
                code = generateRandomCode();
                codesDao.newCode(code, user);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    //Elimina un codigo mediante su id
    @RequestMapping("/deleteCode/{Id}")
    public ModelAndView deleteCode(@PathVariable("Id") int id) {
        ModelAndView model = null;
        try {
            codesDao.deleteCode(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    //Canjea un código mediante su id
    @RequestMapping("/redeemCode/{Id}")
    public ModelAndView redeemCode(@PathVariable("Id") int id) {
        ModelAndView model = null;
        try {
            codesDao.redeemCode(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return model;
    }

    String generateRandomCode() {
        String code = UUID.randomUUID().toString();
        code = code.substring(0, 5);
        return code;
    }

}
