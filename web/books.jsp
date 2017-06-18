<%@ page import="entity.Books" %>
<%@ page import="java.util.List" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%--
  Created by IntelliJ IDEA.
  User: tyr
  Date: 2017/5/29
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书信息</title>
    <style type="text/css"> 
            a:link{color:#FF4500;text-decoration:none}/*未访问，红色，无下划线*/  
            a:active{color:blue;}/*激活，红色*/  
            a:visited{color:red;text-decoration:none}/*已访问，紫色，无下划线*/  
            a:hover{color:yellow;text-decoration:underline}/*鼠标移动上面，蓝色，下划线*/  
     </style> 
</head>
<script language="javascript">

</script>
<body bgcolor="#98FB98">
 <br><br>  
    <table align="center" width="900">  
     <tr>  
       <td align="center" colspan="6" valign="baseline">  
       <h2 style=" font-family:隶书;color:#0A0A0A;font-size:50px">敏达网上书店</h2>  
       </td>  
       </tr>  
   
     <% List<Books> list=(List<Books>)request.getAttribute("list");%>  
     <tr> 
            <%int i=0;%> 
     <%
            for(Books b:list){
          %> 
            <td width="100" height="140"><img src="images/fengmian.jpg"/></td>      
      <td width="200">   
      <font color="#0000FF" face="隶书">ISDN :<%=b.getBid()%></font><br>  
      <font color="#0000FF" face="隶书">书 名:<%=b.getBname()%></font><br>  
      <font color="#0000FF" face="隶书">日  期:<%=b.getBirthday()%></font><br>  
      <font color="#0000FF" face="隶书">出 版:<%=b.getAddress()%></font><br>  
      <font color="#0000FF" face="隶书">价 格:<%=b.getPrice()%> </font><br> 
            <font color="#0000FF" face="隶书"><a href="/XiangBook.jsp?bookid=<%=b.getBid()%>">查看详细信息</a></font><br> 


            <%i++;%>
            <%if(i%3==0){%>
            <br>
            </br>
            <%}%>                            
            <%}%> 
         </tr>    
     </table>  

</body>
</html>
