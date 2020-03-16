package com.bai.ding.common.constant;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * @author BaiDing
 * @date 2020/3/10 15:43
 *
 * 读取公共的配置文件 键值对
 */
public final class CommonConstant {

    private static final Logger log = LoggerFactory.getLogger(CommonConstant.class);
    private static String CONSTANT_PROPERTIES = "constant.properties";
    private static Map<String, String> CONSTANTS = Maps.newConcurrentMap();

    public CommonConstant() {
    }

    private static String getConstantProperties() {
        return CONSTANT_PROPERTIES;
    }

    public static void loadConstant() {
        Properties properties = new Properties();

        try {
            String constantFileName = getConstantProperties();
            loadConstant(properties, constantFileName);
            String profile = properties.getProperty("constant.profile.active");
            if (profile != null && !"".equals(profile)) {
                int dotIdx = constantFileName.lastIndexOf(".");
                if (dotIdx > 0) {
                    constantFileName = constantFileName.substring(0, dotIdx) + "-" + profile + constantFileName.substring(dotIdx);
                } else {
                    constantFileName = constantFileName + "-" + profile;
                }

                loadConstant(properties, constantFileName);
            }

            properties.putAll(System.getProperties());
            setProperties(properties);
        } catch (Exception var4) {
            log.error("CommonConstant.loadConstant.exception: ",var4);
        }
    }

    private static void loadConstant(Properties properties, String propsFile) {
        try {
            log.debug("CommonConstant.loadConstant:constantFileName:{}", propsFile);
            Enumeration enumeration = CommonConstant.class.getClassLoader().getResources(propsFile);

            while(enumeration.hasMoreElements()) {
                URL url = (URL)enumeration.nextElement();
                log.debug("CommonConstant.loadConstant:path:{}", url);
                properties.putAll(loadProperties(url.openStream()));
            }

        } catch (Exception var4) {
            log.error("CommonConstant.loadConstant.exception: ",var4);
        }
    }

    private static Properties loadProperties(InputStream in) throws IOException {
        Properties props = new Properties();
        props.load(in);
        return props;
    }

    public static void setProperties(Properties props) {

        for (Map.Entry<Object, Object> objectEntry : props.entrySet()) {
            CONSTANTS.put((String) objectEntry.getKey(), (String) objectEntry.getValue());
            log.debug("CommonConstant.setProperty:" + objectEntry);
        }

    }

    static {
        loadConstant();
    }

    public static String getStringConstant(String key, String defaultVal) {
        String val = CONSTANTS.get(key);
        return StringUtils.isEmpty(val) ? defaultVal : val;
    }
}
