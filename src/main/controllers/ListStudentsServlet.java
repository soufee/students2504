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
 * Created by Shoma on 20.04.2017.
 */
@Component
@RequestMapping(value = "/NewStudents")
public class ListStudentsServlet extends HttpServlet {
    private static Logger LOGGER = Logger.getLogger(MySessionListener.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("Это метод doGet сервлета ListStudentsServlet");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listStudent.jsp");
        LOGGER.debug(" req.getRequestDispatcher ");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("Это метод doPost сервлета ListStudentsServlet");
        StudentServiceImpl service = new StudentServiceImpl();
try {
    LOGGER.debug("Сейчас будем добавлять нового студента");
    String name = req.getParameter("nameAdd");

    String age = req.getParameter("ageAdd");
    String id = req.getParameter("group_idAdd");
    LOGGER.debug("Должен был получить параметры name, age, id" + name + " "+ age + " "+id);
    System.out.println("Получил параметры");
    Student student = new Student(name, Integer.parseInt(age), Integer.parseInt(id));
    LOGGER.debug("Создал студента " + student);


    LOGGER.debug("Запускается StudentService " + service);
    service.insert(student);
    LOGGER.debug("Осуществляется вставка студента в таблицу ");
} catch (Exception e)
{
    String idForDel = req.getParameter("idDel");
    LOGGER.debug("Метод Delete получил параметр равный  " + idForDel);
    if ((idForDel!=null)&&(idForDel!=""))
    service.delete(Integer.parseInt(idForDel));

}
   resp.sendRedirect("/listStudents");
        LOGGER.debug("Должн произойти перенаправление на страницу listStudents");


    }


}
