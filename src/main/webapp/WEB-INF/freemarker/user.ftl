<html lang="en-US">

<head>
    <meta charset="UTF-8">
    <title>USER informateion</title>
</head>
<body>
<p>Welcome Mr/Ms. ${currentuser}</p>
<h1>USER Information</h1>
<table border="1">

    <th>username</th>
    <th>userid</th>

    <tr>
        <td>${name1}</td>
        <td>${id1}</td>
    </tr>
    <tr>
        <td>${name2}</td>
        <td>${id2}</td>
    </tr>
    <#list userlist as user>
    <tr>
        <td>${user.name}</td>
        <td>${user.userId}</td>
    </tr>
    </#list>
</table>
<table>
    <th>Number</th>
    <th>Title</th>
    <th>Content</th>

</table>
</body>
</html>