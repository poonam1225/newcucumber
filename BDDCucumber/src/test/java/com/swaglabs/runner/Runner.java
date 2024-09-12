package com.swaglabs.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/Feature",
		glue="com.swaglabs.stepdefinations",
		tags="@sanity",
		plugin= {"pretty","html:target/cucumber-report.html",
				
		}

		
		
		
		)

public class Runner extends AbstractTestNGCucumberTests{
	
	/*@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}*/

}
