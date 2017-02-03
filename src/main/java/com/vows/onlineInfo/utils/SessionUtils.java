package com.vows.onlineInfo.utils;

import java.util.List;

import com.vows.sysman.user.User;

/**
 * @project:webasic
 * @description:describe the propose of the file
 * @authur:nis36
 * 2017年2月3日-下午9:11:03
 * 2017  PD.Sp Center   -版权所有
 */
public class SessionUtils {
	public static boolean checkUserInSessionOrNot(String id,List<User> users){
		for(User user : users){
			if (user.getSessionId() == id) return true;
		}
		return false;
	}
	
	public static User checkoutUserInSess(String id,List<User> users){
		for(User user : users){
			if (user.getSessionId() == id) return user;
		}
		return null;
	}
}
