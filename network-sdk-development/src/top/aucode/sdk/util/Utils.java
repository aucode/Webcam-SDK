package top.aucode.sdk.util;

import com.sun.jna.NativeLong;
import com.sun.jna.ptr.ByteByReference;

import java.io.*;

/**
 * @Project network-sdk-development
 * @Description: Utils
 * @Author AU
 * @Explain
 * @Date 2020-04-04 10:38
 */
public class Utils {
    
    /*
    * @Author: AUCode
    * @Description:
    * @Date: 11:13 2020/4/4
    * @Param: [library 库文件名]
    * @Return: java.lang.String
    */
    public static String getLoadLibraryUrl(String library) {
        String loadLibrary = System.getProperty("user.dir") + "\\lib\\"; //获取库文件路径;
        return loadLibrary + library;
    }
    /*
    * @Author: AUCode
    * @Description:  实时预览 回调
    * @Date: 17:45 2020/4/4
    * @Param: [lRealHandle, dwDataType, pBuffer, dwBufSize]
    * @Return: void
    */
    public static void realTimePlayBack(NativeLong lRealHandle, int dwDataType, ByteByReference pBuffer, int dwBufSize) {
        System.out.println("缓存区文件:" + lRealHandle);
        System.out.println("缓存区文件size :" + lRealHandle.SIZE);
        System.out.println("数据类型 : " + dwDataType);
        //===================下载开始============================
        System.out.println("===================下载开始============================ ");
        if (dwDataType == 2) {
            File file = new File(System.getProperty("user.dir") + "\\video\\test.mp4");
            //文件不存在则创建新的文件
            if (!file.exists()) {
                try {
                    file.createNewFile();
                    System.out.println("成功创建文件。");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("创建文件失败。" );
                }
            }
            // 写文件
            try {
                byte[] retBuf = pBuffer.getPointer().getByteArray(0, dwBufSize);
                InputStream in = new ByteArrayInputStream(retBuf);
                FileOutputStream fos = new FileOutputStream(file, true);
                byte[] b = new byte[1024];
                int nRead = 0;
                while ((nRead = in.read(b)) != -1) {
                    fos.write(b, 0, nRead);
                }
                fos.flush();
                fos.close();
                in.close();
                System.out.println("成功写入文件。");
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("写入文件失败。");
            }
        }
        //===================下载结束============================
        System.out.println("===================播放开始============================ ");
        //===================播放开始============================
//        PlayM4_GetPort; // 获取端口
//        PlayM4_OpenStream; //打开
//        PlayM4_InputData;
//        PlayM4_CloseStream; //关闭
//        PlayM4_SetStreamOpenMode;
//        PlayM4_Play;
//        PlayM4_Stop;
//        PlayM4_SetSecretKey;
        //===================播放结束============================




    }
}
