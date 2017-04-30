package main.controllers;

import main.controllers.listeners.MySessionListener;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import main.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Shoma on 19.04.2017.
 */
@Component
@RequestMapping(value="/")
public class LoginServlet extends HttpServlet {
@Autowired
    private  UserService userService;
private static Logger LOGGER  = Logger.getLogger(MySessionListener.class);

@Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
LOGGER.debug("doGet req.getRequestDispatcher(\"/login.jsp\").forward(req, resp); ServletContext "+this.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
LOGGER.debug("loging: Получил логин и пароль");
        if (userService.auth(login, password) != null) {
            req.getSession().setAttribute("userLogin", login);
                    resp.sendRedirect(req.getContextPath() + "/listStudents");
         LOGGER.debug("Логимся " + this.getClass().getName());
        }
    }


}