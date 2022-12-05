package com.amazon.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    public static Logger logger = LogManager.getLogger();

    public static void info(String string){
        logger.info(string);
    }

    public static void warn(String string){
        logger.warn(string);
    }

    public static void error(String string){
        logger.error(string);
    }

}
