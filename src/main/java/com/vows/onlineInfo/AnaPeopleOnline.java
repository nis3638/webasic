package com.vows.onlineInfo;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.vows.onlineInfo.utils.SessionUtils;
import com.vows.sysman.user.User;

@WebListener("统计在线人数")
public class AnaPeopleOnline implements HttpSessionListener{
	private int userNum;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		userNum++;
		System.out.println("userNum:"+userNum);
		se.getSession().getServletContext().setAttribute("userTotal", userNum);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		userNum--;
		//在线用户 session消失  ，在线用户减1
		ArrayList<User> ul = (ArrayList<User>)se.getSession().getServletContext().getAttribute("userList");
		if(ul!=null){
			SessionUtils.checkoutUserInSess(se.getSession().getId(), ul);
		}
	}

	
}
