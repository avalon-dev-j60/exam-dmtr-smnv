package ru.avalon.java.blog.servlets;

import java.io.*;
import javax.inject.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import ru.avalon.java.blog.exceptions.*;
import ru.avalon.java.blog.helpers.*;
import ru.avalon.java.blog.services.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final String JSP = "/WEB-INF/pages/auth/register.jsp";

    @Inject
    AuthService authService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (authService.isSignedIn()) {
            RedirectHelper.redirectBack(request, response);
        } else {
            request.getRequestDispatcher(JSP).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmation = request.getParameter("confirmation");

        try {
            authService.register(email, password, confirmation);
            RedirectHelper.localRedirect(request, response, "/sign-in");
        } catch (ValidationException e) {
            request.setAttribute("exception", e);
            doGet(request, response);
        }
    }
}
