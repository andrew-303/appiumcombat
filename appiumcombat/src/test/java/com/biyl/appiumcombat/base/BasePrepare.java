package com.biyl.appiumcombat.base;

import java.util.Iterator;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.biyl.appiumcombat.util.AppiumUtil;
import com.biyl.appiumcombat.util.ExcelDataProvider;
import com.biyl.appiumcombat.util.LogConfiguration;
import com.biyl.appiumcombat.util.PropertiesDataProvider;
import com.biyl.appiumcombat.util.SelectDriver;

import io.appium.java_client.AppiumDriver;

/**
 * 05.启动和结束测试，以及数据提供者，提供测试数据
 * @author HZFI_DC
 *
 */
public class BasePrepare {
	protected AppiumDriver<WebElement> driver ;
	protected AppiumUtil appiumUtil;
	
	protected String platformName;
	protected String appFilePath;
	protected String appPackage;
	protected int elementTimeOut;
		
	
	@BeforeClass
	public void initTest(ITestContext context){
		//是Log4j配置生效，以便输出日志
		LogConfiguration.initLog(this.getClass().getSimpleName());
		//获取platform、appFilePath、appPackage的值，这些值是从TestNG的配置文件中获取的
		platformName = context.getCurrentXmlTest().getParameter("platformName");
		appFilePath = context.getCurrentXmlTest().getParameter("appFilePath");
		appPackage = context.getCurrentXmlTest().getParameter("appPackage");
		elementTimeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("elementTimeOut"));
		appiumUtil = new AppiumUtil();
		//调用SelectDriver类的selectDriver方法,生成driver对象
		driver = new SelectDriver().selectDriver(context, appiumUtil);
		
	}
	
	@AfterClass
	public void clenTest(){
		if(driver!=null){
			//appiumUtil.closeApp(PropertiesDataProvider.getTestData(appFilePath, appPackage));	//appium模式
			System.out.println("TestCase操作结束");
		}else{
			Assert.fail("driver没有获得对象,退出操作失败");
		}
	}
	
	/**
	 * 测试数据提供者-方法
	 * 需要用到的地方，可以直接加@Test(dataProvider="testData")注解使用该测试数据,
	 * @Test(dataProvider="testData")注解的类的参数必须和@DataProvider注解的类的返回结果要一致
	 */
	@DataProvider(name = "testData")
	public Iterator<Object []> dataFortestMethod(){
		String moduleName = null;	//模块的名字
		String caseNum = null;	//用例编号
		String className = this.getClass().getName();//className=com.biyl.appiumcombat.testcases.more.MorePage_001_UiCheckForMorePage_Test
		//System.out.println("className:"+className);
		int dotIndexNum = className.indexOf(".");// 取得第一个.的index  =3
		int underlineIndexNum = className.indexOf("_");// 取得第一个_的index =45
		
		if(dotIndexNum > 0){
			System.out.println("dotIndexNum:"+dotIndexNum);
			/**这里的calssName原始值大概是这样的：com.biyl.appiumcombat.testcases.login.LoginPage_001_loginError_Test
			 * 那么下面这段代码className.substring(32, className.lastIndexOf("."))是什么意思？substring方法参数有两个
			 * 一个开始位置，一个结束位置，32表示这个字符串的第32个位置，这个位置当前字符是l,className.lastIndexOf(".")表示返回这字符串最后一个.所在
			 * 的位置，它是37，那么className.substring(33, className.lastIndexOf("."))可以转换成：className.substring(32, 37)，最终取得的值是login，
			 * 也就是moduleName的值 
			 * */
			moduleName = className.substring(32,className.lastIndexOf("."));	// 取到模块的名称=more
			//System.out.println("moduleName:"+moduleName);
		}
		
		if(underlineIndexNum>0){
			System.out.println("underlineIndexNum:"+underlineIndexNum);
			//这个分析方法和moduleName的分析方法一样
			caseNum = className.substring(underlineIndexNum + 1, underlineIndexNum +4);	//取用例编号
			System.out.println("caseNum:"+caseNum);
		}
		//将模块名称和用例的编号传给 ExcelDataProvider ，然后进行读取excel数据
		return new ExcelDataProvider(moduleName, caseNum);
	}
}
