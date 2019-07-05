package ru.avalon.java.blog.servlets;

import java.io.*;
import java.util.*;
import javax.ejb.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.avalon.java.blog.entities.*;
import ru.avalon.java.blog.service.*;

@WebServlet ("/articles")
public class ArticleServlet extends HttpServlet {
    
//    @EJB
//    PublicationService publicationService;
//    
//    private ArrayList<Publication> articles = (ArrayList<Publication>) publicationService.listPublications();
    
    private static final String JSP = "/WEB-INF/pages/articles.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("articles", articles);
        request.getRequestDispatcher(JSP).forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
