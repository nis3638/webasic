<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script src="//cdn.bootcss.com/jquery/1.12.1/jquery.min.js"></script>


<body>
<h2>Hello World!</h2>

<span>system time: ${systime}
<input type="text" id="msg" value='pls input ur msg'></input>
<input type="button" id="msgbtn" value='send'></input>
 <!-- 调用servlet-->
 <% out.print("bbaaa"); %>
    <form action="checkServlet" method="post">  
       <img id="img" src="/webasic/AjaxTest/captcha"><br/>  
    </form> 
    <%
    	ArrayList<com.vows.sysman.user.User> users = (ArrayList<com.vows.sysman.user.User>)request.getServletContext().getAttribute("userList");
    	if(users!=null){
    		for(int i=0;i<users.size();i++){
    			com.vows.sysman.user.User user = users.get(i);
    			  
    			 out.println(user.getIp()+" sessionID"  +user.getSessionId() );
    		}
    	}
    %>	
    
</body>
<script>
	
	$(document).ready(function(){
		/* var msgserver = {
				serverUrl:"ws://localhost:8080/webaisc/websocket/chat",
				onmessage:function(event){
					$("#msg").val(event.data);			
				}		
		} */
		var wsserver = new WebSocket("ws://localhost:8080/webasic/websocket/chat");
		wsserver.onmessage = function(event){
			$("#msg").val(event.data);
		}
		
		$("#msgbtn").bind("click",function(){
			wsserver.send(
				$("#msg").val()
			);
		}); 
	}); 
	
	
</script>

</html>
