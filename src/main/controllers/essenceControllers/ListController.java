package main.controllers.essenceControllers;

import main.controllers.listeners.MySessionListener;
import main.model.pojo.Student;
import main.services.StudentServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Shoma on 19.04.2017.
 */

public class ListController extends HttpServlet {

    @Autowired
   private StudentServiceInterface studentService;
    private static Logger LOGGER = Logger.getLogger(MySessionListener.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    LOGGER.debug("ListController работает -> doGet");
        req.setAttribute("value", "Hello, Student!");
        List<Student> list = studentService.getAllStudents();
        req.setAttribute("list", list);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listStudents.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("ListController работает -> doPost");
        String idEdit =   req.getParameter("idEdit");
   LOGGER.debug("Edit вернул значение "+ idEdit);
        resp.sendRedirect("/students/listStudents");
        LOGGER.debug("Должн произойти перенаправление на страницу listStudents");
    }
}
