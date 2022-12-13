<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel='stylesheet'/>

        <title>todo</title>
    </head>
    <body>
    <div class="container">
        <h1>Add todos details</h1>
        <form method="post">
            Description:<input type="text" name="description"/>
            <input type="submit" class="btn btn-primary"/>
        </form>
    </div>
    <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.1/jquery.min.js"></script>
    </body>
</html>