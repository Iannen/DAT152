<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<link rel="icon" href="data:,">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="Author" content="Bjarte Kileng" />
<link href="${path}/../main.css" rel="stylesheet" type="text/css" />
<script src="${path}/js/routingload.js" type="module"></script>

<title>Multiple URLs to same page</title>
</head>

<body>
    <p>Multiple URLs load the same page. JavaScript uses the URL to
        decide on content in view but navigation will cause reload of
        the page.</p>

    <page-component></page-component>

    <p>
        <a href="${path}/index.html">Back to index page</a>
    </p>
</body>

</html>