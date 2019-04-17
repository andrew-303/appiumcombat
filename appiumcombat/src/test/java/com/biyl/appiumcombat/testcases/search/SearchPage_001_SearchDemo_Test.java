package com.biyl.appiumcombat.testcases.search;

import java.util.Map;

import org.testng.annotations.Test;

import com.biyl.appiumcombat.base.BasePrepare;
import com.biyl.appiumcombat.pages.HomePage;
import com.biyl.appiumcombat.pages.InitPage;
import com.biyl.appiumcombat.pages.SearchNativePage;
import com.biyl.appiumcombat.pages.SearchWebviewPage;
import com.biyl.appiumcombat.pageshelper.HomePageHelper;
import com.biyl.appiumcombat.pageshelper.InitPageHelper;
import com.biyl.appiumcombat.pageshelper.SearchNativePageHelper;
import com.biyl.appiumcombat.pageshelper.SearchWebviewPageHelper;

/**
 * 搜索页面的测试用例类
 * @author HZFI_DC
 *
 */
public class SearchPage_001_SearchDemo_Test extends BasePrepare{
	@Test(dataProvider="testData")
	public void searchDemo(Map<String,String> data){
		//去除欢迎界面和定位弹窗
		//InitPageHelper.handleInit(appiumUtil, InitPage.byElement);
		//点击搜索按钮
		HomePageHelper.waitHomeUI(appiumUtil, 3);
		HomePageHelper.clickOnHomePage(appiumUtil, HomePage.HP_BUTTON_SEARCH);
		//在搜索界面输入框输入Java
		//SearchNativePageHelper.typeInfo(appiumUtil, SearchNativePage.SNP_INPUT_SEARCH,data.get("KEYWORD"));
		//点击搜索网页，进行搜索
		//SearchNativePageHelper.clickOnSearchNativePage(appiumUtil, SearchNativePage.SNP_LINK_WEBSEARCH);
		//进入webview内容
		//SearchWebviewPageHelper.enterWebview(appiumUtil, SearchWebviewPage.WEBVIEW_NAME);
		//等待webview内容显示出来
		//SearchWebviewPageHelper.waitForSearchResultDisplay(appiumUtil, elementTimeOut);
		//验证搜索的结果是否包含Java
		//SearchWebviewPageHelper.checkResultFitKeyword(appiumUtil, data.get("KEYWORD"), SearchWebviewPage.SWP_LINK_RESULT);
	}
}
