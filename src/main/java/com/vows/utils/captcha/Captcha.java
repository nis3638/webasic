package com.vows.utils.captcha;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * @project:ServletCaptcha
 * @description:图片验证码生成器类
 * @authur:nis36
 * 2017年1月27日-下午8:46:10
 * 2017  PD.Sp Center   -版权所有
 */
public class Captcha {
	//图片宽
	private int widthImage;
	//图片高
	private int heightImage;
	
	private BufferedImage bufferimg;
	//验证字数
	private int codeNum = 4;
	//干扰线个数
	//字体类引入
	private ImageFont imgFont = new ImageFont();
	//验证码字符穿缓存
	private String code=null;
	// 字库
	private String[] codeArrays = {
			"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P"
	};
	public Captcha(int width,int height,int codeNum){
		this.widthImage = width;
		this.heightImage = height;
		this.codeNum = codeNum;
	};
	public Captcha(int width,int height,int codeNum,ImageFont imgFont){
		this.widthImage = width;
		this.heightImage = height;
		this.codeNum = codeNum;
		this.imgFont = imgFont;
	}
	
	
	/**
	 * randomStringArray
	 * 根据codeNum 和  字符队列生成 字符
	 * @return String[]
	 * @exception
	 * @since  1.0.0
	*/
	public String[] randomStringArray(int codeNum) throws Exception{
		if(codeNum<=0) throw new Exception("验证码的字符数量应该大于0");
		List<String> sb = new ArrayList();
		Random rd = new Random();
		for(int i=0;i<codeNum;i++){
			sb.add(codeArrays[rd.nextInt(this.codeArrays.length)]);
		}
		String[] arrStr = new String[codeNum];
		
		return sb.toArray(arrStr);
	}
	public String[] randomStringArray() throws Exception{
		return randomStringArray(this.codeNum);
	}
	
	/**
	 * getRandomColor
	 * 获取随机颜色
	 * @return Color
	 * @exception
	 * @since  1.0.0
	*/
	public Color getRandomColor(){
		Random rd = new Random();
		int r = rd.nextInt(255);  
        int g = rd.nextInt(255);  
        int b = rd.nextInt(255);  
        return new Color(r, g, b);  
	}

	/**
	 * 创建一副图片
	 * void
	 * @throws Exception 
	 * @exception
	 * @since  1.0.0
	 */
	public void createImage() throws Exception{
		bufferimg = new BufferedImage(widthImage, heightImage, BufferedImage.TYPE_INT_RGB);
		Graphics2D gp = bufferimg.createGraphics(); // 创建画笔
		gp.setColor(Color.GRAY);    // 设置背景
		gp.fillRect(0, 0, widthImage, heightImage); // 填充区域，画色块
				
		// 创建字体  
        //gp.setFont(this.imgFont.getFont());  
		gp.setFont(new java.awt.Font("Fixedsys", java.awt.Font.BOLD, heightImage/2));
		//绘制干扰线
		
		//设置字符
        String[] codeRst = randomStringArray(this.codeNum);
        StringBuffer sb = new StringBuffer();
		for(int i=0;i<this.codeNum;i++){
			gp.setColor(getRandomColor());//设置字体颜色
			//gp.setColor(Color.BLACK);
			//gp.drawString(codeRst[i], 50+i, this.heightImage/2);// 设置字体位置，应尽量在图片中间
			gp.drawString(codeRst[i], (i+1)*widthImage/(codeNum*2-1), this.heightImage/2);
		}
		code = Arrays.toString(codeRst).replaceAll(",", "").replaceAll(" ", ""); //留下纯文字
		
	}

    public void write(String path) throws IOException {  
        OutputStream sos = new FileOutputStream(path);  
        this.write(sos);  
    }  
    
    public void write(OutputStream sos) throws IOException {  
        ImageIO.write(bufferimg, "png", sos);  
        sos.close();  
    }  
    
	public float getWidthImage() {
		return widthImage;
	}


	public void setWidthImage(int widthImage) {
		this.widthImage = widthImage;
	}


	public float getHeightImage() {
		return heightImage;
	}


	public void setHeighthImage(int heightImage) {
		this.heightImage = heightImage;
	}


	public int getCodeNum() {
		return codeNum;
	}


	public void setCodeNum(int codeNum) {
		this.codeNum = codeNum;
	}


	public String[] getCodeArrays() {
		return codeArrays;
	}


	public void setCodeArrays(String[] codeArrays) {
		this.codeArrays = codeArrays;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	
}
