package com.biyl.appiumcombat.pageshelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.biyl.appiumcombat.pages.HomePage;
import com.biyl.appiumcombat.pages.SearchHomePage;
import com.biyl.appiumcombat.util.AppiumUtil;

public class SearchHomePageHelper {
	
	public static Logger logger = Logger.getLogger(InitPageHelper.class);
	
	/**在此原生搜索页面点击操作*/
	public static void clickOnSearchNativePage(AppiumUtil appiumUtil,By byElement){
		
		appiumUtil.click(byElement);
	}
	
	/**向输入框输入内容*/
	public static void typeInfo(AppiumUtil appiumUtil,By byElement,String info){
		appiumUtil.typeContent(byElement, info);
	}
	
	/**清空输入框内容*/
	public static void clearContent(AppiumUtil appiumUtil,By byElement){
		appiumUtil.clear(byElement);
	}
	
	/**验证搜索结果部分文本内容*/
	public static void checkSearchUIText(AppiumUtil appiumUtil,String expected){
		logger.info("正在验证APP首页搜索结果中文本内容是否正确");
		appiumUtil.isTextCorrect(appiumUtil.getText(SearchHomePage.SNP_TEXT_SEARCHRESULT), expected);
		logger.info("验证APP首页搜索结果中文本内容完成");
	}
	
	
	
	
	
}
