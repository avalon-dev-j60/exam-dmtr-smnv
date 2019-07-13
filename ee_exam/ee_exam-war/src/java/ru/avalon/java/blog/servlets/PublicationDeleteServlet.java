package ru.avalon.java.blog.servlets;

import java.io.*;
import javax.ejb.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import ru.avalon.java.blog.entities.*;
import ru.avalon.java.blog.service.*;
import ru.avalon.java.blog.exceptions.*;

import static ru.avalon.java.blog.helpers.RedirectHelper.*;
import static ru.avalon.java.blog.helpers.Validation.*;

@WebServlet("/publications/delete")
public class PublicationDeleteServlet extends HttpServlet {

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
                publicationService.delete(publication);
                localRedirect(request, response, "/");
            } catch (NumberFormatException | ValidationException e) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            localRedirect(request, response, "/");
        }
    }
}
