package com.dragon.codingol.common.util;
 

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import com.dragon.codingol.domain.system.UserEntity;
 
public class LogUtil {
  private static final String LOGCONFIG = "log4j.properties";
  private static Logger objLog;
  
  private static Logger getDbLogger() {
    if(objLog==null){ 
       objLog = LogManager.getLogger("SYSTEM");
    }
    UserEntity user = ResourceUtil.getSessionUserName();
    if(user != null){
    	 MDC.put("userId", user.getId());
    	 MDC.put("userName", user.getNumber());
    	 MDC.put("ip", ContextHolderUtils.getIp());
    	 MDC.put("broswer", ContextHolderUtils.getBrowse());
    }

    return objLog;
  }
 
  public static void info(String message) {
    log("INFO", message);
  }
 
  public static void trace(String message) {
    try {
      log("TRACE", message);
    } catch (Exception ex) {
    }
  }
 
  public static void error(String message) {
    try {
      log("ERROR", message);
    } catch (Exception ex) {

    }
  }
 
  public static void warning(String message) {
    try {
      log("WARN", message);
    } catch (Exception ex) {

    }
  }

 
  public static void fatal(String message) {
    try {
      log("FATAL", message);
    } catch (Exception ex) {

    }
  }
 
  public static void debug(String message) {
    try {
      log("DEBUG", message);
    } catch (Exception ex) {

    }
  } 

  public static void log(String level, String msg)
  {
    log(level, msg, null);
  }

  public static void log(String level, Throwable e)
  {
    log(level, null, e);
  }

  public static void log(String level, String msg, Throwable e)
  {
    try{
      getDbLogger().log(Level.toLevel(level), msg , e);
    }catch(Exception ex){
      System.out.println(ex.getLocalizedMessage());
    }
  }
}
