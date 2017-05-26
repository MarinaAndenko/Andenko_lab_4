<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" %>

<t:genericpage>
    <jsp:attribute name="header">
        Are you sure you want delete?
    </jsp:attribute>
    <jsp:body> 
        <dl class="dl-horizontal">
            <c:forEach var="field" items="${worker['class'].declaredFields}">
                <dt>${field.name}<dt>
                <c:catch><dd>${worker[field.name]}</dd></c:catch>
            </c:forEach>
        </dl>
        <form action="delete" name="form" method="POST">
        	<input name="id" type="hidden" value="${worker.id }">
        	<button class="btn btn-default" type="submit">Delete</button>
        	<a class="btn btn-default" href="${pageContext.request.contextPath}/worker">Back to List</a>
        </form>
    </jsp:body>
</t:genericpage>