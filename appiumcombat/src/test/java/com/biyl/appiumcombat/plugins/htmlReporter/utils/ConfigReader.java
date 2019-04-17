package com.biyl.appiumcombat.plugins.htmlReporter.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Logger;
/**
 * 读取配置文件./res/properties/config.properties
 * @author HZFI_DC
 *
 */
public class ConfigReader {
	private static Logger logger = Logger.getLogger(ConfigReader.class);
	private static ConfigReader cr;
	private int retryCount = 0;
	private String sourceCodeDir = "src";
	private String sourceCodeEncoding = "UTF-8";
	private static final String RETRYCOUNT = "retrycount";
	private static final String SOURCEDIR = "sourcecodedir";
	private static final String SOURCEENCODING = "sourcecodeencoding";
	private static final String CONFIGFILE = "./res/properties/config.properties";
	
	private ConfigReader(){
		readConfig(CONFIGFILE);
	}

	public static ConfigReader getInstance(){
		if(cr == null){
			cr = new ConfigReader();
		}
		return cr;
	}
	private void readConfig(String fileName) {
		Properties properties = getConfig(fileName);
		if(properties!=null){
			String sRetryCount = null;
			//获取properties文件中所有元素
			Enumeration<?> en = properties.propertyNames();
			//遍历properties文件中所有元素
			while(en.hasMoreElements()){
				String key = (String) en.nextElement();
				if(key.toLowerCase().equals(RETRYCOUNT)){
					sRetryCount = properties.getProperty(key);
				}
				if(key.toLowerCase().equals(SOURCEDIR)){
					sourceCodeDir = properties.getProperty(key);
				}
				if(key.toLowerCase().equals(SOURCEENCODING)){
					sourceCodeEncoding = properties.getProperty(key);
				}
			}
			if(sRetryCount !=null){
				sRetryCount = sRetryCount.trim();
				try {
					retryCount = Integer.parseInt(sRetryCount);
				} catch (final NumberFormatException e) {
					throw new NumberFormatException("Parse " + RETRYCOUNT + " [" + sRetryCount +" ] from String to Exception");
				}
			}
		}
	}
	
	public int getRetryCount(){
		return this.retryCount;
	}
	
	public String getSourceCodeDir(){
		return this.sourceCodeDir;
	}
	
	public String getSourceCodeEncoding(){
		return this.sourceCodeEncoding;
	}
	
	/**
	 * 读取properties文件
	 * @param propertyFileName
	 * 
	 * @return
	 */
	private Properties getConfig(String propertyFileName){
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(propertyFileName));
		} catch (FileNotFoundException e) {
			properties = null;
			logger.warn("FileNotFoundException:" + propertyFileName);
		} catch (IOException e) {
			properties = null;
			logger.warn("IOException:" + propertyFileName);
		}
		return properties;
	}
}
