package ru.avalon.java.blog.servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import ru.avalon.java.blog.entities.*;
import ru.avalon.java.blog.exceptions.*;
import ru.avalon.java.blog.service.*;
import ru.avalon.java.blog.services.*;

import static ru.avalon.java.blog.helpers.RedirectHelper.*;
import static ru.avalon.java.blog.helpers.Validation.*;

@WebServlet("/publication/create")
public class PublicationCreateServlet extends HttpServlet {
    
    private static final String JSP = "/WEB-INF/pages/publications/create.jsp";

    @Inject
    AuthService authService;
    
    @EJB
    PublicationService publicationService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.getRequestDispatcher(JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        
        try{
            require(title, "Title is required!");
            require(content, "Content is required!");
            User user = authService.getUser();
            requireNonNull(user, "You should be authorized to create publication");
            Publication publication = new Publication(title, content, user);
            publicationService.create(publication);
            localRedirect(request, response, "/");
        } catch (ValidationException e) {
            request.setAttribute("exception", e);
            doGet(request, response);
        }
    }
}
