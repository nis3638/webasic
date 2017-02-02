package com.vows.test.websocket;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vows.utils.captcha.Captcha;


@Controller
@RequestMapping("AjaxTest")
public class HttpReqMvcTestAjax {
	@RequestMapping("systime")
	public String getSystimer(Model model){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		System.out.println(sdf.format(date));
		model.addAttribute("systime",sdf.format(date));
		return "index";		
	}
	
	@RequestMapping("captcha")
	public void getCaptcha(HttpServletRequest req,HttpServletResponse res) throws Exception{
		Captcha captcha = new Captcha(300,100,4);
		captcha.createImage();
		String code = captcha.getCode();
		
		// 设置图片格式  
		res.setContentType("image/jpeg");  

        // 禁止图像缓存  
		res.setHeader("Pragma", "no-cache");  
		res.setHeader("Cache-Control", "no-cache");  
		res.setDateHeader("Expires", 0);  //在代理服务器端防止缓冲

       // Cookie cookie = new Cookie("captcha", captcha.getCode().replaceAll(",", ""));  
       // cookie.setMaxAge(1800);  //设置cookie有效时间，单位 秒
       // req.getSession().setAttribute("code", code);
		//res.addCookie(cookie);  
       
        captcha.write(res.getOutputStream());  
		
	}
}
