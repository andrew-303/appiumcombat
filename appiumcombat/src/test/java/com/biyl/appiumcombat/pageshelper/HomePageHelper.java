package com.biyl.appiumcombat.pageshelper;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

import com.biyl.appiumcombat.pages.HomePage;
import com.biyl.appiumcombat.util.AppiumUtil;

/**
 * 首页帮助类
 * @author HZFI_DC
 *
 */
public class HomePageHelper {

	//本类日志对象
	public static Logger logger = Logger.getLogger(HomePageHelper.class);
	
	/**
	 * @param appiumUtil Appium封装对象引用
	 * @param byElement 要点击的元素By对象
	 * @description 在首页上进行点击操作
	 */
	public static void clickOnHomePage(AppiumUtil appiumUtil,By byElement){
		appiumUtil.click(byElement);
	}
	
	/**等待首页元素显示出来*/
	public static void waitHomeUI(AppiumUtil appiumUtil,int elementTimeOut){
		logger.info("正在等待APP首页元素加载");
		appiumUtil.waitForElementToLoad(elementTimeOut, HomePage.HP_BUTTON_SEARCH);
		logger.info("APP首页元素加载完成");
	}
	
	/**验证首页部分文本内容*/
	public static void checkHomeUIText(AppiumUtil appiumUtil,String expected){
		logger.info("正在验证APP首页文本内容是否正确");
		//appiumUtil.isTextCorrect(appiumUtil.getText(HomePage.HP_BUTTON_SEARCH), expected);
		appiumUtil.isTextCorrect(appiumUtil.getText(appiumUtil.findElements(HomePage.HP_ICON_BANSHIGUIDE).get(3)), expected);
		logger.info("验证APP首页文本内容完成");
	}
}
