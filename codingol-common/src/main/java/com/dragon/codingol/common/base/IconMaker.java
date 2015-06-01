package com.dragon.codingol.common.base;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dragon.codingol.common.SystemConfig;
import com.dragon.codingol.domain.admin.SystemEntity;
import com.dragon.codingol.domain.system.IconEntity;

 
public class IconMaker {
	 
	public void addicon(SystemEntity system, IconEntity icon, IconEntity newicon){
		try {
			
			String path =  SystemConfig.getIconCssPath(system);
			
			File iconFile = new File(path+ SystemConfig.getIconCssFileName());
			if (!iconFile.exists()) {
				iconFile.createNewFile();
			}
			 
			String basePath = SystemConfig.getFileUploadTemp();
			if (!basePath.endsWith("/")) {
				basePath += "/";
			}
			File oldFile = new File(path + "icons\\" + icon.getStyle() + ".png"); 
			if(oldFile.exists()){
				oldFile.delete();
			}
			
			File newFile = new File(basePath + newicon.getIconpath()); 
			 
			BufferedImage thumbnail = Scalr.resize(ImageIO.read(newFile), 32, 32);
			String thumbnailFilename = newicon.getStyle() + ".png";
			File thumbnailFile = new File(path + "icons\\" + thumbnailFilename);
			ImageIO.write(thumbnail, "png", thumbnailFile);
			 
			String css = "." + newicon.getStyle() + "{background:url('icons/"+thumbnailFilename+"') no-repeat center center}";
			
			FileReader reader = new FileReader(iconFile);
			BufferedReader br = new BufferedReader(reader);
			StringBuffer sb = new StringBuffer();
			 
			String s ;
			String oldcss = "." + icon.getStyle() + "{background:url('icons/"+icon.getStyle()+".png') no-repeat center center}";
			while (( s=br.readLine()) != null) {
				if(!s.equals(oldcss)){
					sb.append(s);
					sb.append("\r\n");
				}
			}
			sb.append(css);
			br.close();
			reader.close();
			
			FileWriter out = new FileWriter(iconFile);
			out.write(sb.toString());
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void addicon(SystemEntity system, IconEntity icon){
		try {
			
			String path =  SystemConfig.getIconCssPath(system);
			
			File iconFile = new File(path+ SystemConfig.getIconCssFileName());
			if (!iconFile.exists()) {
				iconFile.createNewFile();
			}
			 
			String basePath = SystemConfig.getFileUploadTemp();
			if (!basePath.endsWith("/")) {
				basePath += "/";
			}
			File newFile = new File(basePath + icon.getIconpath()); 
			 
			BufferedImage thumbnail = Scalr.resize(ImageIO.read(newFile), 32, 32);
			String thumbnailFilename = icon.getStyle() + ".png";
			File thumbnailFile = new File(path + "icons\\" + thumbnailFilename);
			ImageIO.write(thumbnail, "png", thumbnailFile);
			 
			String css = "." + icon.getStyle() + "{background:url('icons/"+thumbnailFilename+"') no-repeat center center}";
			
			FileWriter out = new FileWriter(iconFile, true);
			out.write("\r\n");
			out.write(css);
			out.close();
		} catch (Exception e) {
		}
	}
}
