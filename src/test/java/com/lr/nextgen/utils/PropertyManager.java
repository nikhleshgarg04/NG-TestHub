package com.lr.nextgen.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.lr.nextgen.base.BaseClass;


public class PropertyManager extends BaseClass {

	private static PropertyManager _instance = null;
    public Properties testData;
    public InputStream fileConfig = null;
	
	public PropertyManager() {

        try {
            this.testData = new Properties();
            this.fileConfig = getClass().getClassLoader().getResourceAsStream(
                    "PropertyFile/PropertyFile.properties");
            if (this.fileConfig != null) {
                this.testData.load(this.fileConfig);
                this.fileConfig.close();
            } else {
                System.out.println("Error on reading config file");
            }

        }

        catch (IOException e)

        {
        	System.out.println("Error" + e);
        }
        finally {
            if (this.fileConfig != null) {
                try {
                    this.fileConfig.close();
                } catch (IOException e) {
                    APP_LOG.error(
                            "Func:  Error occured while closing config file"
                                    + e);
                }
            }

        }
	}
	
        public static synchronized PropertyManager getInstance() {

            if (_instance == null) {
                _instance = new PropertyManager();
            }
            return _instance;
        }

        public String getValueForKey(String key) {
            return this.testData.getProperty(key);

        }
	
	}

