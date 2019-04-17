package com.biyl.appiumcombat.util;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;


/**
 * 04.从.properties文件中读取相关测试数据
 * @author HZFI_DC
 *
 */
public class PropertiesDataProvider {
	public static String getTestData(String configFilePath,String key){
		Configuration config = null;
		try {
			config = new PropertiesConfiguration(configFilePath);			
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		return String.valueOf(config.getProperty(key));
	}
}
