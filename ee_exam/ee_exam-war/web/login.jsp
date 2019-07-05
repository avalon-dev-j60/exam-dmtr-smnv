<%-- 
    Document   : login
    Created on : 22.06.2019, 13:15:07
    Author     : JAVA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/" %>
<%@taglib prefix="auth" tagdir="/WEB-INF/tags/auth/" %>

<core:layout title="Sign in">
    <div class="one fourth centered">
        <h2>
            login
        </h2>
        <auth:login/>
    </div>
</core:layout>