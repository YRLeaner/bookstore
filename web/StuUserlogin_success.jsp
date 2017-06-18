<%--
  Created by IntelliJ IDEA.
  User: tyr
  Date: 2017/5/30
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page import="java.util.List" %>
<%@ page import="entity.Books" %><%--
  Created by IntelliJ IDEA.
  User: tyr
  Date: 2017/5/29
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>网上书店</title>
    <script language="javascript" src="JS/AjaxRequest.js"></script>
    <!--javascript语言写的代码块-->
    <script  type="text/javascript">
        function login(){
            if(document.loginform.id.value==""){
                window.alert("账号不能为空！");
                return ;
            }
            if(document.loginform.password.value==""){
                window.alert("密码不能为空！");
                return ;
            }
            loginform.submit();
        }
        function register(){
            document.loginform.method="post";
            document.loginform.target="rightframe";
            document.loginform.action="register.jsp";
            document.loginform.submit();
        }

    </script>  
         <script type="text/javascript">
    /***********错误处理方法*********/
    function onerror(){
        alert("您的操作有误！");
    }
    /***********实例化ajax对象的方法*********/
    function getInfo(){
        var loader=new net.AjaxRequest("getInfo.jsp?nocache="+new Date().getTime(),deal_getInfo,onerror,"GET");

    }
    /***********回调函数*********/
    function deal_getInfo(){
        document.getElementById("showInfo").innerHTML=this.req.responseText;
    }

    window.onload=function(){
        getInfo();  //调用getInfo()方法获取公告信息  
        window.setInterval("getInfo()", 600000);    //每隔10分钟调用一次getInfo()方法  
    }
</script>
    <style type="text/css">
        a:link{color:red;text-decoration:none}/*未访问，红色，无下划线*/
        a:active{color:blue;}/*激活，红色*/
        a:visited{color:yellow;text-decoration:none}/*已访问，紫色，无下划线*/
        a:hover{color:blue;text-decoration:underline}/*鼠标移动上面，蓝色，下划线*/
    </style>
</head>
<body bgcolor="#98FB98">

        <h2 align="center" style=" font-family:隶书">欢迎<%=session.getAttribute("loginsStuUserName")%>登陆网上书店系统</h2><br>           
         
        
      <table align="center" style="border:1px solid">  
           <tr bgcolor="#FF0000">  
                  <td colspan="2">  
                       公告信息：
                        
                      </td>  
               </tr>   
             <tr>  
                 <td colspan="2" width="215" height="100">         
                     <marquee direction="up" scrollamount="3" onmouseout="this.start()" onmouseover="this.stop()">  
                         <div id="showInfo">

                </div>  
                         </marquee>  
                     </td>  
                 </tr>  
             <tr bgcolor="#FF0000">  
                 <td colspan="2">  
                      友情链接：  
                      </td>  
               </tr>   
           <tr>  
                  <td colspan="2">  
                         <a href="http://www.xidian.edu.cn/" target="_blank"><font face="隶书" color="#FF4500" size="4">西安电子科技大学</font></a><br>  
                            <a href="" target="_blank"><font face="隶书" color="#FF4500" size="4">陕西师范大学</font></a><br>  
                            <a href="" target="_blank"><font face="隶书" color="#FF4500" size="4">西安外国语大学</font></a><br>  
                                                             
                      </td>  
               </tr>   
           </table>  
</body>
</html>

</body>
</html>
