package ru.avalon.java.blog.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet ("/projects")
public class ProjectsServlet extends HttpServlet {
    private final String[] projects = {"Documentation", "Some other project", "Main project"};
    
    private static final String JSP = "/WEB-INF/pages/projects.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("projects", projects);
        request.getRequestDispatcher(JSP).forward(request, response);
    }
}
