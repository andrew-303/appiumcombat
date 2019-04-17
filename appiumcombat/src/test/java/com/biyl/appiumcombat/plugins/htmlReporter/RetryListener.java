package com.biyl.appiumcombat.plugins.htmlReporter;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

/**
 * 负责失败的用例重新执行的监听器
 * @author HZFI_DC
 *
 */
public class RetryListener implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		IRetryAnalyzer retryAnalyzer = annotation.getRetryAnalyzer();
		if(retryAnalyzer == null){
			annotation.setRetryAnalyzer(TestngRetry.class);
		}
	}

}
