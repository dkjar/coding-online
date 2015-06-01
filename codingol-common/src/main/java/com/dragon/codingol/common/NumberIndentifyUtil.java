package com.dragon.codingol.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dragon.codingol.common.util.ContextHolderUtils;

public class NumberIndentifyUtil {
	public static void getIdentify(HttpServletResponse response) throws IOException {
		response.setContentType("image/JPEG"); 
		response.setHeader("Pragma","No-cache");
	    response.setHeader("Cache-Control","no-cache");
	    response.setDateHeader("Expires", 0);
	   
	    Random r = new Random();
	    int width=80, height=32;
	    BufferedImage pic = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	    Graphics gc = pic.getGraphics();
 
	    gc.fillRect(0, 0, width, height);
	    gc.setFont(new Font("Times New Roman",Font.PLAIN,26));
	    for (int i=0;i<150;i++){
	    	gc.setColor(getRandColor(100,250));
	        int x1 = r.nextInt(width);
	        int y1 = r.nextInt(height);
	        int x2 = r.nextInt(15);
	        int y2 = r.nextInt(15);
	        gc.drawLine(x1,y1,x1+x2,y1+y2);
	    }

	    for (int i=0;i<150;i++) 
		{
			gc.setColor(getRandColor(100,220));
			int x = r.nextInt(width); 
			int y = r.nextInt(height); 
			gc.drawOval(x,y,0,0); 
		} 
	    String RS="";
	    String rn="";
	    for(int i=0;i<5;i++){
	        rn=String.valueOf((char)(r.nextInt(26)+65));
	        RS+=rn;
	        gc.setColor(new Color(20+r.nextInt(110),20+r.nextInt(110),20+r.nextInt(110)));
	        gc.drawString(rn,13*i+r.nextInt(3),r.nextInt(5)+23);
	    }
	    gc.dispose();
	    HttpSession session = ContextHolderUtils.getSession();
	    while(session.getAttributeNames().hasMoreElements()){
	    	session.removeAttribute(session.getAttributeNames().nextElement().toString());
	    }
	    session.setAttribute("random" + RS.toLowerCase(),RS.toLowerCase());
	    ImageIO.write(pic, "JPEG", response.getOutputStream());
	    
		response.flushBuffer(); 
	}

	public static Color getRandColor(int fc, int bc) {
		Random r = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int red = fc + r.nextInt(bc - fc);
		int green = fc + r.nextInt(bc - fc);
		int blue = fc + r.nextInt(bc - fc);
		return new Color(red, green, blue);
	}
}
