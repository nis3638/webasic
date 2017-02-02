package com.vows.utils.captcha;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @project:ServletCaptcha
 * @description:字体样式类
 * @authur:nis36
 * 2017年2月2日-下午3:55:39
 * 2017  PD.Sp Center   -版权所有
 */
public class ImageFont {
	private int width;
	private int height;//字体高度
	private String url;//字体文件路径
	public ImageFont(String url,int height){
		this.url = url;
		this.height = height;
		
	}
	public ImageFont() {
	
	}
	
	public java.awt.Font getFont(){
		return getFont(this.height);
	}
    public java.awt.Font getFont(int fontHeight) {  
    	try {  
    		java.awt.Font baseFont = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT,  
                 new ByteArrayInputStream(hex2byte(getFontByteStr(this.url))));  
    		return baseFont.deriveFont(java.awt.Font.PLAIN, fontHeight);  
    	} catch (Exception e) {  
    		return new java.awt.Font("Arial", java.awt.Font.PLAIN, fontHeight);  
    	}  
    }  
	
    private byte[] hex2byte(String str) {  
         if (str == null)  
             return null;  
         str = str.trim();  
         int len = str.length();  
         if (len == 0 || len % 2 == 1)  
             return null;  

         byte[] b = new byte[len / 2];  
         try {  
             for (int i = 0; i < str.length(); i += 2) {  
                 b[i / 2] = (byte) Integer.decode(  
                         "0x" + str.substring(i, i + 2)).intValue();  
             }  
             return b;  
         } catch (Exception e) {  
             return null;  
         }  
    }  

     // 字体文件的十六进制字符串  
    private String getFontByteStr(String url) {  
    	File file = new File(url);
    	String tempStr = null;
    	BufferedReader reader = null;
    	try {
			reader = new BufferedReader(new FileReader(file));
			int line = 1;
			tempStr = reader.readLine();
			
	    	reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return "";
    }  
	
	
	
}
