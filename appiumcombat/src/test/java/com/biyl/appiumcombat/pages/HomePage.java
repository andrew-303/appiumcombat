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
	/**搜索按钮*/
	public static final By HP_BUTTON_SEARCH = By.id("com.microsoft.bing:id/search");
	/**更多内容按钮*/
	public static final By HP_BUTTON_MORE = By.id("com.microsoft.bing:id/search_homepage_hamburger");
	/**图片按钮*/
	public static final By HP_BUTTON_IMAGE = By.id("com.microsoft.bing:id/hp_scope_images");
	/**视频按钮*/
	public static final By HP_BUTTON_VDEDIO = By.id("com.microsoft.bing:id/hp_scope_videos");
	/**学术按钮*/
	public static final By HP_BUTTON_ACADEMIC = By.id("com.microsoft.bing:id/hp_scope_academic");
	/**词典按钮*/
	public static final By HP_BUTTON_DICT = By.id("com.microsoft.bing:id/hp_scope_dict");
	/**图片故事链接*/
	public static final By HP_LINK_STORY = By.id("com.microsoft.bing:id/opal_home_picture_story_text1");
}
