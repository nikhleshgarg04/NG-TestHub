package com.lr.nextgen.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;

public class LoggerUtils {

	private static Logger APP_LOGS = null;
	
	
	public static String now(String dateFormat) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(cal.getTime());
    }

    public static synchronized Logger initializeLogger(String basePath) {
        String logDate = now("dd.MMMMM.yyyyhh.mm.ss");
        try {
            System.setProperty("log.dir",
                    basePath + File.separator + File.separator + "testLogs"
                            + File.separator + "ApplicationLog_" + logDate
                            + ".log");
            APP_LOGS = Logger.getLogger("automation");
        } catch (Exception e) {
            APP_LOGS.debug("Exception during Logger Creation " + e);
        }
        APP_LOGS.debug(" initializeLogger " + basePath + " - " + logDate);
        APP_LOGS.debug("Logger Initiated");

        return APP_LOGS;
    }
}
