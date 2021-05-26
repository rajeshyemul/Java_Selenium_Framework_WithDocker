package com.rajesh.constants;

import com.rajesh.enums.ConfigProperties;
import com.rajesh.utils.PropertyUtils;

public final class FrameworkConstants {
	
	private FrameworkConstants() {
		
	}
	
	private static final String CHROMEDRIVERPATH = System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver";
	private static final String GHECODRIVERPATH = System.getProperty("user.dir") + "/src/test/resources/executables/ghecodriver";
	private static final String IEDRIVERPATH = System.getProperty("user.dir") + "/src/test/resources/executables/iedriver";
	private static final String CONFIGFILEPATH = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";
	private static final int EXPLICITWAITTIME = 10;
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
	private static String extentReportFilePath = "";
	private static final String EXCELFILEPATH = System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx";
	

	public static String getExtentreportpath() {
		if (PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH  + System.currentTimeMillis() + "/" +"index.html" ;
		}
		else {
			return EXTENTREPORTFOLDERPATH + "/"  + "index.html" ;
		}
	}

	public static String getExcelfilepath() {
		return EXCELFILEPATH;
	}

	public static String getExtentReportFilePath() {
		if (extentReportFilePath.isEmpty()) {
				extentReportFilePath = getExtentreportpath();
		}
		return extentReportFilePath;
	}

	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}

	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}
	
	public static int getExplicitWaitTime() {
		return EXPLICITWAITTIME;
	}
	
	public static String getGhecoDriverPath() {
		return GHECODRIVERPATH;
	}

	public static String getIeDriverPath() {
		return IEDRIVERPATH;
	}
}
