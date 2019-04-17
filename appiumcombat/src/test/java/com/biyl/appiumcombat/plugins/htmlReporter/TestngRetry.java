package com.biyl.appiumcombat.plugins.htmlReporter;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.log4testng.Logger;

import com.biyl.appiumcombat.plugins.htmlReporter.utils.ConfigReader;
import com.biyl.appiumcombat.util.LogConfiguration;
/**
 * 实现能够有机会重试失败的测试。
 * @author HZFI_DC
 *
 */
public class TestngRetry implements IRetryAnalyzer{

	static{
		LogConfiguration.initLog("TestngRetryPage_");
	}
	private static Logger logger = Logger.getLogger(TestngRetry.class);
	private int retryCount = 1;
	private static int maxRetryCount;
	
	static{
		ConfigReader config = ConfigReader.getInstance();
		maxRetryCount = config.getRetryCount();
		logger.info("RetryCount=" + maxRetryCount);
		logger.info("SourceDir=" + config.getSourceCodeDir());
		logger.info("SourceEncoding=" + config.getSourceCodeEncoding());
	}
	
	
	@Override
	public boolean retry(ITestResult result) {
		if(retryCount <= maxRetryCount){
			String message = "Retry for:[ " + result.getName() + "] on class [" + result.getTestClass().getName() + "] retry" + retryCount + " times";
			logger.info(message);
			Reporter.setCurrentTestResult(result);
			Reporter.log("RunCount=" + (retryCount + 1));
			retryCount++;
			return true;
		}
		return false;
	}
	
	public static int getMaxRetryCount(){
		return maxRetryCount;
	}
	
	public int getRetryCount(){
		return retryCount;
	}

}
