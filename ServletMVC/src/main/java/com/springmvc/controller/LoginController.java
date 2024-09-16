package com.springmvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.springmvc.dao.LoginDao;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        Integer loginAttempts = (Integer) session.getAttribute("loginAttempts");

        if (loginAttempts == null) {
            loginAttempts = 0;
        }

        LoginDao loginDao = new LoginDao();

        if (loginDao.validate(userName, password)) {
            session.setAttribute("username", userName);
            session.removeAttribute("loginAttempts");
            request.getRequestDispatcher("/Welcome.jsp").forward(request, response);
        } else {
            loginAttempts++;
            session.setAttribute("loginAttempts", loginAttempts);

            if (loginAttempts >= 3) {
                request.setAttribute("errMessage", "First register then login.");
                RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
                rd.include(request, response);
            } else {
                request.setAttribute("errMessage", "Invalid Username or Password");
                request.getRequestDispatcher("/Login.jsp").forward(request, response);
            }
        }
    }
}