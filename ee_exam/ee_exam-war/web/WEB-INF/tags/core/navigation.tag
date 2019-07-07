<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="core" tagdir="/WEB-INF/tags/core/"%>
<fmt:setBundle basename="resources.labels"/>

<nav>
    <ul>
        <li>
            <core:link location="/">
                <jsp:attribute name="title">
                    <fmt:message key="menu.home"/>
                </jsp:attribute>
            </core:link>
        </li>
        <li>
            <core:link location="/about">
                <jsp:attribute name="title">
                    <fmt:message key="menu.about"/>
                </jsp:attribute>
            </core:link>
        </li>
        <li class="pull-right">
            <c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <core:link location="/sign-out">
                        <jsp:attribute name="title">
                            <fmt:message key="menu.sign-out"/>
                        </jsp:attribute>
                    </core:link>
                </c:when>
                <c:otherwise>
                    <core:link location="/sign-in">
                        <jsp:attribute name="title">
                            <fmt:message key="menu.sign-in"/>
                        </jsp:attribute>
                    </core:link>
                </c:otherwise>
            </c:choose>
        </li>
    </ul>
</nav>