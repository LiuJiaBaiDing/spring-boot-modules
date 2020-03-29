package com.bai.ding.common.util;

import com.bai.ding.common.exception.FdfsException;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageClient1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author BaiDing
 * @date 2020/3/27 21:51
 */
public class FastdfsClientUtil {

    private static Logger logger = LoggerFactory.getLogger(FastdfsClientUtil.class);
    private static final FastdfsClientFactory CLIENT_FACTORY=FastdfsClientFactory.getInstance();

    private static StorageClient1 storageClient(){
        try {
            return CLIENT_FACTORY.create();
        } catch (Exception e) {
            throw new FdfsException(e);
        }
    }
    /**
     * 上传文件
     * @param fileContent
     * @param extName
     * @return
     * @throws Exception
     */
    public static String uploadFile(byte[] fileContent, String extName) {

        try {
            return storageClient().upload_file1(fileContent, extName, null);
        } catch (Exception e) {
            throw new FdfsException(e);
        }

    }

    /**
     * 下载文件
     * @param groupName
     * @param fileId
     * @return
     */
    public byte[] downloadFile(String groupName, String fileId) {
        try {
            byte[] bytes = storageClient().download_file(groupName, fileId);
            return bytes;
        } catch (Exception e) {
            throw new FdfsException(e);
        }
    }

    /**
     * 删除文件
     * @param groupName
     * @param remoteFilename
     * @return
     */
    public int deleteFile(String groupName, String remoteFilename) {
        try {
            int i = storageClient().delete_file(groupName, remoteFilename);
            logger.info("delete file successfully!!!" + i);
            return 1;
        } catch (Exception e) {
            throw new FdfsException(e);
        }
    }
}
