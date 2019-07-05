<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/"%>

<core:layout title="Articles">
    <c:choose>
        <c:when test="${not empty articles}">
            <c:forEach items="${articles}" var="item">
                <div class="row">
                    ${item}
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p>
                There are no articles
            </p>
        </c:otherwise>
    </c:choose>
</core:layout>