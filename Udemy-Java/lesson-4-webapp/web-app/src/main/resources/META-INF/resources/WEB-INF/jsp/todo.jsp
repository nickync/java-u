<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel='stylesheet'/>

        <title>todo</title>
    </head>
    <body>
    <div class="container">
        <h1>Add todos details</h1>
        <form:form method="post" modelAttribute="todo">
            Description:<form:input type="text" path="description"/>
            <form:errors path="description" cssClass="text-danger"/>
            <input type="submit" class="btn btn-primary"/>
        </form:form>
    </div>
    <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.1/jquery.min.js"></script>
    </body>
</html>