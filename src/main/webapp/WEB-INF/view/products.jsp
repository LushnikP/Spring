<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css" />
</head>

<body>
<h1>Welcome page</h1>

<body>
<h1>Welcome page</h1>
<c:set var="list"  value="${products.productsAsList}" />
<ul>
    <c:forEach var="item" items="${list}" >
                <li>${item.title}</li>
                <li>${item.cost}</li>
    </c:forEach>
</ul>
</body>
</html>
