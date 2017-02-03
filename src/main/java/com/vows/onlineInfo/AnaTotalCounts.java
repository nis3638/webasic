package com.vows.onlineInfo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import com.vows.onlineInfo.utils.SessionUtils;
import com.vows.sysman.user.User;

/**
 * @project:webasic
 * @description:在线人员计数器
 * @authur:nis36
 * 2017年2月3日-下午1:04:03
 * 2017  PD.Sp Center   -版权所有
 */
@WebListener
public class AnaTotalCounts implements ServletRequestListener {
	List<User> userList = new ArrayList<User>();
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		String ip = sre.getServletRequest().getRemoteAddr();
		ip = ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
		
		//获取session中的sessionID来判断 list中的user是否已经存在
		//如果不存在 ，list.add(user)
		HttpServletRequest hsr = (HttpServletRequest)sre.getServletRequest();
		if(!SessionUtils.checkUserInSessionOrNot(hsr.getSession().getId(), userList)){
			User user = new User();
			user.setSessionId(hsr.getSession().getId());
			user.setIp(ip);
			userList.add(user);
		}
		hsr.getServletContext().setAttribute("userList", userList);
	
		ArrayList<com.vows.sysman.user.User> users = (ArrayList<com.vows.sysman.user.User>)hsr.getServletContext().getAttribute("userList");
    	
    	/*if(users!=null){
    		for(int i=0;i<users.size();i++){
    			com.vows.sysman.user.User user = users.get(i);
    			System.out.println( user.getIp());
    		}
    	}*/
	}


}
