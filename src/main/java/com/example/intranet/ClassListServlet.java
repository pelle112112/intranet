package com.example.intranet;

import com.example.intranet.entities.Student;
import com.example.intranet.entities.User;
import com.example.intranet.persistence.StudentMapper;
import com.example.intranet.persistence.UserMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ClassListServlet", value = "/classlist")
public class ClassListServlet extends HttpServlet {

    public void init(){
        StudentMapper.populateStudents();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Vær sikker på brugeren er logget på, ellers forward til index.jsp
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null){
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else {

            // Ellers indlæs en arrayliste med klassens studerende
            List<Student> studentList = StudentMapper.getAllStudents();
            request.setAttribute("studentlist", studentList);

            // Forward til /WEB-INF/classlist.JSP
            request.getRequestDispatcher("WEB-INF/classlist.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
