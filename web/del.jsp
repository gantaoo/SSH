<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title>list</title>
  </head>
  <body>
  <form method="post" action="/deltUser">
      输入要删除id:<input type="text" name="sid"><br>
      <input type="submit" value="删除"/>
  </form>
  </body>
</html>
