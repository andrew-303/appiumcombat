package com.biyl.appiumcombat.testcases.more;

import java.util.Map;

import org.testng.annotations.Test;

import com.biyl.appiumcombat.base.BasePrepare;
import com.biyl.appiumcombat.pages.HomePage;
import com.biyl.appiumcombat.pages.InitPage;
import com.biyl.appiumcombat.pageshelper.HomePageHelper;
import com.biyl.appiumcombat.pageshelper.InitPageHelper;
import com.biyl.appiumcombat.pageshelper.MorePageHelper;

public class MorePage_001_UiCheckForMorePage_Test extends BasePrepare{

	@Test(dataProvider="testData")
	public void uiCheckForMorePage(Map<String,String> data){
		//去除欢迎界面和定位弹窗
		InitPageHelper.handleInit(appiumUtil, InitPage.byElement);
		//在首页上点击更多按钮
		//HomePageHelper.clickOnHomePage(appiumUtil, HomePage.HP_BUTTON_MORE);
		//检查更多页面的文本
		MorePageHelper.checkMorePageUIText(appiumUtil, data.get("LOGIN"),data.get("HISTORY"),data.get("SETTINGS"),data.get("FEEDBACK"));
	}
}
