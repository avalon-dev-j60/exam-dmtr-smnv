<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="publication" type="ru.avalon.java.blog.entities.Publication" required="true"%>

<h2>${publication.title}</h2>

${publication.content}