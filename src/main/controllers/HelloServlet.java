package main.controllers;

import main.controllers.listeners.MySessionListener;
import main.model.pojo.Student;
import org.apache.log4j.Logger;
import main.services.StudentServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Shoma on 18.04.2017.
 */
@Component
@RequestMapping(value="/hello")

public class HelloServlet extends HttpServlet {
    private static Logger LOGGER = Logger.getLogger(MySessionListener.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //   resp.getWriter().println("who touch me la la la");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
        LOGGER.debug("Диспатчер HelloServlet сработал");
        dispatcher.forward(req, resp);
     //   resp.sendRedirect();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentServiceImpl service = new StudentServiceImpl();
       try{
           String editId = req.getParameter("idEdit");
           String iName = req.getParameter("iName");
           String iAge = req.getParameter("iAge");
           String iGroup = req.getParameter("iGroup");
        String name = req.getParameter("nameEdit");
        if ((name==null)||(name.equals(""))) name = iName;
        String age = req.getParameter("ageEdit");
           if ((age==null)||(age.equals(""))) age = iAge;
           String id = req.getParameter("group_idEdit");
           if ((id==null)||(id.equals(""))) id = iGroup;
           LOGGER.debug("Данные для обновления получены");
        Student student = new Student(name, Integer.parseInt(age), Integer.parseInt(id));
        service.updateById(student,Integer.parseInt(editId));
       LOGGER.debug("Вызван SQL метод для обновления данных записи №"+editId);
       }
        catch (Exception e)
        {
            LOGGER.debug("Возникла ошибка по время редактирования данных.");
        }
        resp.sendRedirect(req.getContextPath() + "/listStudents");
        LOGGER.debug("Должн произойти перенаправление на страницу listStudents");
    }
}
