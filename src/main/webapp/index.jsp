<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Tag Example</title>
</head>
<body>
<c:url value="allbooks" var="url"/>
<c:redirect url="${url}"/>
</body>
</html>
