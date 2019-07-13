package ru.avalon.java.blog.helpers;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.ws.rs.core.*;

public final class RedirectHelper {

    private RedirectHelper() {
    }

    public static void redirect(HttpServletRequest request, HttpServletResponse response, String location) throws ServletException, IOException {
        
        response.setStatus(HttpServletResponse.SC_FOUND);
        response.setHeader(HttpHeaders.LOCATION, location);
    }

    public static void localRedirect(HttpServletRequest request, HttpServletResponse response, String location) throws ServletException, IOException {
        
        location = request.getContextPath() + location;
        redirect(request, response, location);
    }

    public static void redirectBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String referer = request.getHeader("Referer");
        String currentLocation = request.getRequestURL().toString();
        
        if (referer == null || referer.equals(currentLocation)) {
            localRedirect(request, response, "/");
        } else {
            redirect(request, response, referer);
        }
    }
}
