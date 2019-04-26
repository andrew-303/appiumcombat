package com.biyl.appiumcombat.pages;

import org.openqa.selenium.By;

/**
 * 
 * @author HZFI_DC
 * @description APP首页元素
 * HP代表 HomePage的缩写，一般为字母大写的组合部分，这样简洁；
 * 第二部分BUTTON代表的是你这个元素是输入框还是按钮，如果是输入框我们用INPUT表示，如果是按钮我们用BUTTON表示；
 * 第三部分：SEARCH，表示这元素的简称，三者之间用下划线“_”代替
 */
public class HomePage {
		
	/**取消版本更新按钮*/
	public static final By HP_BUTTON_UPDATEDEL = By.id("com.hfi.hangzhoubanshi:id/update_delete");
	/**搜索按钮*/
	public static final By HP_BUTTON_SEARCH = By.id("com.hfi.hangzhoubanshi:id/ll_search");
	/**热门事项图标*/
	public static final By HP_ICON_BANSHIGUIDE = By.id("com.hfi.hangzhoubanshi:id/tv_home_head_name");
	
	//test
}
