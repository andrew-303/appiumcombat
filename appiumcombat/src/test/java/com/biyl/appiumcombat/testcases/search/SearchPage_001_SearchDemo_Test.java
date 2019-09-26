package com.biyl.appiumcombat.testcases.search;

import java.util.Map;

import org.testng.annotations.Test;

import com.biyl.appiumcombat.base.BasePrepare;
import com.biyl.appiumcombat.pages.HomePage;
import com.biyl.appiumcombat.pages.InitPage;
import com.biyl.appiumcombat.pages.SearchHomePage;
import com.biyl.appiumcombat.pages.SearchWebviewPage;
import com.biyl.appiumcombat.pageshelper.HomePageHelper;
import com.biyl.appiumcombat.pageshelper.InitPageHelper;
import com.biyl.appiumcombat.pageshelper.SearchHomePageHelper;
import com.biyl.appiumcombat.pageshelper.SearchWebviewPageHelper;

/**
 * 搜索页面的测试用例类
 * @author HZFI_DC
 *
 */
public class SearchPage_001_SearchDemo_Test extends BasePrepare{
	@Test(dataProvider="testData")
	public void searchDemo(Map<String,String> data){
		//取消升级提示
		HomePageHelper.clickOnHomePage(appiumUtil, HomePage.HP_BUTTON_UPDATEDEL);
		//点击搜索按钮
		HomePageHelper.waitHomeUI(appiumUtil, 3);
		HomePageHelper.clickOnHomePage(appiumUtil, HomePage.HP_BUTTON_SEARCH);
		//在搜索界面输入框输入qqq
		SearchHomePageHelper.typeInfo(appiumUtil, SearchHomePage.SNP_INPUT_SEARCH,data.get("KEYWORD"));
		//验证搜索的结果是否包含qqq
		SearchHomePageHelper.checkSearchUIText(appiumUtil, data.get("RESULT"));
		//点击取消按钮
		SearchHomePageHelper.clickOnSearchNativePage(appiumUtil, SearchHomePage.SNP_BUTTON_CANCELSEARCH);
		
	}
}
