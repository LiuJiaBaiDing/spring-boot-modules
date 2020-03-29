package com.bai.ding.common.util;

import com.bai.ding.common.exception.FdfsException;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * @author BaiDing
 * @date 2020/3/27 21:23
 */
public class FastdfsClientFactory {

    private static Logger logger = LoggerFactory.getLogger(FastdfsClientFactory.class);
    private static final String FDFS_CLIENT_CONF= "fdfs_client.conf";

    private static final class Holder{
        public static final FastdfsClientFactory instance=new FastdfsClientFactory();
    }
    public static final FastdfsClientFactory getInstance(){
        return Holder.instance;
    }

    private FastdfsClientFactory(){
        initConfig();
    }

    private void initConfig(){
        try{
            Properties properties = new Properties();
            String profile = properties.getProperty("constant.profile.active");
            String configFileName = "";
            if (profile != null && !"".equals(profile)) {
                int dotIdx = FDFS_CLIENT_CONF.lastIndexOf(".");
                configFileName = FDFS_CLIENT_CONF.substring(0, dotIdx) + "_" + profile + FDFS_CLIENT_CONF.substring(dotIdx);
                ClientGlobal.init(configFileName);
            }
            logger.info("初始化 Fastdfs Client 配置信息：{}", ClientGlobal.configInfo());
        }catch(Exception e){
            throw new FdfsException(e);
        }
    }

    public StorageClient1 create() throws Exception {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
        return new StorageClient1(trackerServer, storageServer);
    }
}
