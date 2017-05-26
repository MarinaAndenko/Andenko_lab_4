<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" %>

<t:genericpage>
    <jsp:attribute name="header">
        Worker Created/Updated
    </jsp:attribute>
    <jsp:body> 
        <dl class="dl-horizontal">
            <c:forEach var="field" items="${worker['class'].declaredFields}">
                <dt>${field.name}<dt>
                <c:catch><dd>${worker[field.name]}</dd></c:catch>
            </c:forEach>
			<c:remove var="worker" scope="session" />
        </dl>
    </jsp:body>
</t:genericpage>