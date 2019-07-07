package ru.avalon.java.blog.servlets;

import java.io.*;
import java.util.*;
import javax.ejb.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import ru.avalon.java.blog.entities.*;
import ru.avalon.java.blog.service.*;

@WebServlet("/publications")
public class PublicationListServlet extends HttpServlet {

    private static final String JSP = "/WEB-INF/pages/publications/list.jsp";

    @EJB
    PublicationService publicationService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Publication> publications = publicationService.list();
        request.setAttribute("publications", publications);
        request.getRequestDispatcher(JSP).forward(request, response);
    }
}
