<%-- 
    Document   : error
    Created on : 29.06.2019, 15:14:51
    Author     : JAVA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="exception"%>

<c:if test="${not empty exception}">
    <div class="box error gap-bottom gap-top">
        ${exception.message}
    </div>
</c:if>