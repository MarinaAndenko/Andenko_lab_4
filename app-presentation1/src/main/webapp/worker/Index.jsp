<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@page contentType="text/html"%>

<t:genericpage>
	<jsp:attribute name="header">
        Worker List
    </jsp:attribute>
	<jsp:body>        
        <c:choose>
            <c:when test="${not empty workers}">
                <table class="table">
                    <tr>
                        <c:forEach var="field" items="${workers[0]['class'].declaredFields}">
                            <c:catch>
								<th>${field.name}</th>
							</c:catch>
                            </c:forEach>
                            <th></th>
                    </tr>
                    <c:forEach var="worker" items="${workers}">
                        <tr>
                            <c:forEach var="field" items="${worker['class'].declaredFields}">
                                <c:catch>
									<td>${worker[field.name]}</td>
								</c:catch>
                            </c:forEach>
                            <td>
                           	 <a href="${pageContext.request.contextPath}/worker/edit?id=${worker.id}">Edit</a> |
                          	  <a href="${pageContext.request.contextPath}/worker/delete?id=${worker.id}">Delete</a>
							</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <p>No data</p>
            </c:otherwise>
        </c:choose>
    </jsp:body>
</t:genericpage>
