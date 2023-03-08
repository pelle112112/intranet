package com.example.intranet;

import com.example.intranet.entities.User;
import com.example.intranet.persistence.UserMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    public void init(){
        UserMapper.populateUserMap();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");


        if(UserMapper.isLoginValid(login, password)){
            request.setAttribute("message", "Login " + login + " is valid");
            User user = UserMapper.getUserByLogin(login);
            //gem user i session-state
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

        }
        else{
            request.setAttribute("message", "Login " + login + " or password is not valid");
        }


        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
