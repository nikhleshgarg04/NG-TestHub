package com.lr.nextgen.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.lr.nextgen.endppoint.APIEndPoints;
import com.lr.nextgen.endppoint.JsonPaths;
import com.lr.nextgen.utils.LoggerUtils;
import com.lr.nextgen.utils.PropertyManager;
import com.lr.nextgen.utils.UtilsClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class BaseClass {
	
	public static Map<String, String> jsonPaths = new HashMap<String, String>();
    public static Map<String, String> endpointsMap = new HashMap<String, String>();
    
    public static String projectPath;
    protected static Logger APP_LOG = null;
    protected static String Exec_Env;
    protected static String BaseURL;
    
    protected static RequestSpecification request;
    
   protected static Response response ;
    
    public static String reportStartTime;
    
    static UtilsClass utils = new UtilsClass();
    
    
    static {
        init();
        reportStartTime = LoggerUtils.now("dd.MMMMM.yyyy_hh.mm.ss");
    }

    
    private static synchronized void init() 
    {
    	 projectPath = PropertyManager.getInstance()
                 .getValueForKey("ProjectPath").trim();
    	 Exec_Env = PropertyManager.getInstance().getValueForKey("Execution_environment").trim();
    	 BaseURL = PropertyManager.getInstance().getValueForKey("BaseURI").trim();
    	 
    	 if (null != APP_LOG) {
         } else {
             APP_LOG = LoggerUtils.initializeLogger(projectPath);
             PropertyConfigurator.configure(System.getProperty("user.dir")
                     + "/src/test/resources/PropertyFile/log4j.properties");
         }
    	 
    	jsonPaths = utils.InputMemberInMap(JsonPaths.class);
    	endpointsMap = utils.InputMemberInMap(APIEndPoints.class);
    	
    }

}
