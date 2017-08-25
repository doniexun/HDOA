package com.hdjf.oa.utils;


import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

/**
 * Created by harrishuang on 2017/8/24.
 */
public class HDLog {

    private static final Logger logger = Logger.getLogger(HDLog.class);

    public static void info(Object object) {
        logger.info(JSON.toJSONString(object));
    }

    public static void infoWithData(Object object) {
        logger.info(JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss"));
    }
}
