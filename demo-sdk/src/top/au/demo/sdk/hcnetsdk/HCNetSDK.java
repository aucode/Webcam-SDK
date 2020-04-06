package top.au.demo.sdk.hcnetsdk;

import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;
import top.au.demo.sdk.comm.Constant;

/**
 * @Project demo-sdk
 * @Description: HCNetSDK
 * @Author AU
 * @Explain HCNetSDK 接口类
 * @Date 2020-04-03 20:17
 */
public interface HCNetSDK extends StdCallLibrary {
    HCNetSDK INSTANCE = (HCNetSDK) Native.loadLibrary(Constant.LIBPATH +"HCNetSDK",
            HCNetSDK.class);
}
