<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<t:genericpage>
    <jsp:attribute name="header">
        Error
    </jsp:attribute>
    <jsp:body>
        <h3>${error}</h3>
    </jsp:body>
</t:genericpage>
