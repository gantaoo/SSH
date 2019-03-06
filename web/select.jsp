<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title>list</title>
  </head>
  <body>
  <s:iterator value="list" status="li">
     id: <s:property value="sid"/></br>
     user:<s:property value="username"/></br>
     pwd: <s:property value="password"/></br>
    <br/>
  </s:iterator>
  </body>
</html>
