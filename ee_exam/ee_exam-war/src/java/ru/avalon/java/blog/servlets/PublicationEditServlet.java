package ru.avalon.java.blog.servlets;

import java.io.IOException;
import javax.ejb.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import ru.avalon.java.blog.entities.*;
import ru.avalon.java.blog.service.*;
import ru.avalon.java.blog.exceptions.*;

import static ru.avalon.java.blog.helpers.RedirectHelper.*;
import static ru.avalon.java.blog.helpers.Validation.*;

@WebServlet("/publication/edit")
public class PublicationEditServlet extends HttpServlet {

    private static final String JSP = "/WEB-INF/pages/publications/edit.jsp";

    @EJB
    PublicationService publicationService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        if (id != null) {
            try {
                long lid = Long.parseLong(id);
                Publication publication = publicationService.find(lid);
                requireNonNull(publication, "");
                request.setAttribute("publication", publication);
                request.getRequestDispatcher(JSP).forward(request, response);
            } catch (NumberFormatException | ValidationException e) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            localRedirect(request, response, "/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        try {
            require(title, "Title is reqired!");
            require(content, "Content is required!");
            long lid = Long.parseLong(id);
            Publication publication = publicationService.find(lid);
            requireNonNull(publication, "");
            publication.setTitle(title);
            publication.setContent(content);
            publicationService.update(publication);
            localRedirect(request, response, "/");
        } catch (NumberFormatException | ValidationException e) {
            request.setAttribute("exception", e);
            doGet(request, response);
        }
    }
}
