package com.dragon.codingol.common.freemarker;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import freemarker.template.Configuration;

public class LocalConfiguration {

	public final static String BASEPATH = "/freemarker";
	private final static LocalConfiguration localConfiguration = new LocalConfiguration();

	private LocalConfiguration() {
	}

	public static LocalConfiguration getInstance() {
		return localConfiguration;
	}

	public Configuration getConfiguration() throws IOException {
		Configuration localConfiguration =  new Configuration();
		
		String str = getTemplatePath();
		 
		File localFile = new File(str);
		 
		localConfiguration.setDirectoryForTemplateLoading(localFile);
		localConfiguration.setLocale(Locale.CHINA);
		localConfiguration.setDefaultEncoding("UTF-8");
		return localConfiguration;
	}
	
	public String getTemplatePath(){
		return   new File(getClass().getResource(BASEPATH).getFile()).getPath();
	}
}
