<%@ page import="service.BooksDao" %>
<%@ page import="serviceimp.BooksDaoImpl" %>
<%@ page import="entity.Books" %><%--
  Created by IntelliJ IDEA.
  User: tyr
  Date: 2017/6/9
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>详细书单</title>
     <style type="text/css">  
            a:link{color:blue;text-decoration:none}/*未访问，红色，无下划线*/  
            a:active{color:blue;}/*激活，红色*/  
            a:visited{color:yellow;text-decoration:none}/*已访问，紫色，无下划线*/  
            a:hover{color:blue;text-decoration:underline}/*鼠标移动上面，蓝色，下划线*/  
        </style>  
  
</head>

<body bgcolor="#98FB98">
 <% String bookid=request.getParameter("bookid");
    BooksDao bookdao=new BooksDaoImpl();
    Books b=bookdao.queryBooksByBid(bookid);
    %>  
         
        <br><br><br><br>  
             <form name="addForm" action="<%=path%>/orders/Orders_add.action" method="post">
        <table align="center"  width="800">  
             <tr>  
                     <td width="100" height="140"><img src="images/fengmian.jpg"/></td>      
                    <td width="200">   
                      <font color="#0000FF" face="隶书">ISDN :<%=b.getBid()%></font><br>  
                      <font color="#0000FF" face="隶书">书 名:<%=b.getBname()%></font><br>  
                      <font color="#0000FF" face="隶书">作 者:<%=b.getBirthday()%></font><br>  
                      <font color="#0000FF" face="隶书">出 版:<%=b.getAddress()%></font><br>  
                      <font color="#0000FF" face="隶书">价 格:<%=b.getPrice()%> </font><br> 
                 </tr>  
             <tr><td colspan="2"> <hr color="#FF0000"></td></tr>    
               
             <tr>  
                   <td colspan="2"> <h2><font color="#8B0000" face="隶书">简介：</font></h2></td>  
                 </tr>    
               
        <tr>
        <td><input type="hidden" name="sid" value="<%=session.getAttribute("loginsStuUserName")%>" /></td>
         </tr>
         <tr>
        <td><input type="hidden" name="bid" value="<%=b.getBid()%>"/></td>
         </tr>
                 
              <tr>  
                   <td colspan="2" align="center"><input class="button" type="submit" value="购买"></td>
                </tr>           
        </table>                
     </form>  
       
</body>
</html>
