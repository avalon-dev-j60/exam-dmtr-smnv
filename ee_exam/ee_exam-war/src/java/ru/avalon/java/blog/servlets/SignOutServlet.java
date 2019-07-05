package ru.avalon.java.blog.servlets;

import java.io.*;
import javax.inject.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import ru.avalon.java.blog.helpers.RedirectHelper;
import ru.avalon.java.blog.services.AuthService;

@WebServlet ("/sign-out")
public class SignOutServlet extends HttpServlet {
    
    @Inject AuthService authService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        authService.signOut();
        RedirectHelper.redirectBack(request, response);
    }
}
