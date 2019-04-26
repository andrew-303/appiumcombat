package com.biyl.appiumcombat.testcases.home;

import java.util.Map;

import org.testng.annotations.Test;

import com.biyl.appiumcombat.base.BasePrepare;
import com.biyl.appiumcombat.pages.HomePage;
import com.biyl.appiumcombat.pages.InitPage;
import com.biyl.appiumcombat.pageshelper.HomePageHelper;
import com.biyl.appiumcombat.pageshelper.InitPageHelper;

public class HomePage_001_UiCheck_Test extends BasePrepare{

	@Test(dataProvider="testData")
	public void uiCheck(Map<String,String> data){
		//取消升级提示
		HomePageHelper.clickOnHomePage(appiumUtil, HomePage.HP_BUTTON_UPDATEDEL);
		
		//等待首页元素加载，这个条件可以不要，因为是原生APP的，代码都是在本地的，基本上打开了APP就显示了原生元素
		HomePageHelper.waitHomeUI(appiumUtil, elementTimeOut);
		//检查文本，从data/home.xls中获取预期文字内容
		HomePageHelper.checkHomeUIText(appiumUtil, data.get("HOTAPPLICATION"));
	}
}
