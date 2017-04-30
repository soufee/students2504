package main.controllers;

import main.controllers.listeners.MySessionListener;
import main.model.pojo.User;
import main.services.UserService;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Shoma on 27.04.2017.
 */
@Controller
@SessionAttributes("login")
public class HelloController {
    static final Logger LOGGER = LogManager.getLogger(MySessionListener.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHello() {
        LOGGER.debug("LOGINNNN");
        return "login";
    }




    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value = "login", required = true) String login,
                              @RequestParam(value = "password", required = true) String password) {
        ModelAndView mav = new ModelAndView();
        User user = null;
        if ((user = userService.auth(login, password)) != null) {
            LOGGER.debug("USER!=NULL");
            //req.getSession().setAttribute("login", login);
            mav.addObject("login", login);
            mav.setViewName("redirect:/listStudents");
            LOGGER.debug("login: " + login);
            //resp.sendRedirect(req.getContextPath() + "/listStudents");
        } else {mav.setViewName("redirect:/");
        LOGGER.debug("USER==NULL");
        }

        return mav;
    }

}