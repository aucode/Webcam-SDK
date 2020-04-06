package top.aucode.sdk.device;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.NativeLongByReference;
import top.aucode.sdk.HCNetSDK;
import top.aucode.sdk.entity.DeviceInfo;
import top.aucode.sdk.util.Utils;

/**
 * @Project network-sdk-development
 * @Description: Device
 * @Author AUCode
 * @Explain 设备类
 * @Date 2020-04-04 11:18
 */
public class Device {
    /**
     * 加载库文件
     */
    static HCNetSDK hCNetSDK = HCNetSDK.INSTANCE;
    /**
     * 设备信息
     **/
    HCNetSDK.NET_DVR_DEVICEINFO_V30 m_strDeviceInfo;
    /**
     * 用户句柄
     **/
    NativeLong lUserID;
    /**
     * 预览句柄
     **/
    NativeLong lPreviewHandle;
    /**
     * 错误代码
     */
    NativeLong errorCode;
    /**
     * 错误信息
     */
    NativeLongByReference errorInfo;
    /*
    * @Author: AUCode
    * @Description: 初始化
    * @Date: 12:45 2020/4/4
    * @Param: []
    * @Return: boolean
    */
    public boolean DvInit() {
        boolean isInit = hCNetSDK.NET_DVR_Init();
        if (isInit != true) {
            errorCode = new NativeLong(hCNetSDK.NET_DVR_GetLastError());
            errorInfo = new NativeLongByReference(errorCode);
            System.err.println("初始化失败，错误代码: "+errorCode+"，"+hCNetSDK.NET_DVR_GetErrorMsg(errorInfo));
            //释放 SDK 资源
            hCNetSDK.NET_DVR_Cleanup();
            return false;
        } else {
            return true;
        }
    }
    /*
    * @Author: AUCode
    * @Description: 用户注册设备
    * @Date: 13:27 2020/4/4
    * @Param: [deviceInfo 设备信息]
    * @Return: long
    */
    public NativeLong DveLoginV40(DeviceInfo deviceInfo){
        m_strDeviceInfo = new HCNetSDK.NET_DVR_DEVICEINFO_V30();
        lUserID = hCNetSDK.NET_DVR_Login_V30(deviceInfo.getDeviceIp(), deviceInfo.getDevicePort(), deviceInfo.getDeviceUsername(), deviceInfo.getDevicePassword(), m_strDeviceInfo);
        long userID = lUserID.longValue();
        if (userID == -1) {
            errorCode = new NativeLong(hCNetSDK.NET_DVR_GetLastError());
            errorInfo = new NativeLongByReference(errorCode);
            System.err.println("注册失败，错误代码: "+errorCode+"，"+hCNetSDK.NET_DVR_GetErrorMsg(errorInfo));
            //释放 SDK 资源
            hCNetSDK.NET_DVR_Cleanup();
            return lUserID;
        } else {
            System.out.println("注册成功");
            return lUserID;

        }
    }
    /*
    * @Author: AUCode
    * @Description: 用户注销
    * @Date: 13:31 2020/4/4
    * @Param: [userID 用户ID号，DveLoginV40 登录接口的返回值 ]
    * @Return: boolean
    */
    public boolean DveLogout(NativeLong userID) {
        if (userID.longValue() > -1 && hCNetSDK.NET_DVR_Logout_V30(userID)) {
            //释放 SDK 资源
            return hCNetSDK.NET_DVR_Cleanup();
        }
        return false;
    }
    /*
    * @Author: AUCode
    * @Description: 开启实时预览（支持多码流）。
    * @Date: 17:25 2020/4/4
    * @Param: [userID 户ID号，DveLoginV40 登录接口的返回值, deviceInfo 设备信息]
    * @Return: long
    */
    public NativeLong DveRealPlay(NativeLong userID,DeviceInfo deviceInfo){
        //预览参数
        HCNetSDK.NET_DVR_PREVIEWINFO m_strClientInfo = new HCNetSDK.NET_DVR_PREVIEWINFO();
        //设置通道号
        m_strClientInfo.lChannel = new NativeLong(deviceInfo.getDeviceChannel());
        lPreviewHandle = hCNetSDK.NET_DVR_RealPlay_V40(userID,m_strClientInfo,fRealDataCallBack_V30,null);
        long previewValue = lPreviewHandle.longValue();
        //预览失败时:
        if (previewValue == -1) {
            errorCode = new NativeLong(hCNetSDK.NET_DVR_GetLastError());
            errorInfo = new NativeLongByReference(errorCode);
            System.err.println("预览失败，错误代码: "+errorCode+"，"+hCNetSDK.NET_DVR_GetErrorMsg(errorInfo));
            //释放 SDK 资源
            hCNetSDK.NET_DVR_Cleanup();
            return lPreviewHandle;
        }

        return lPreviewHandle;
    }
    /*
    * @Author: AUCode
    * @Description:  停止(关闭)预览。
    * @Date: 11:52 2020/4/5
    * @Param: [lRealHandle 开启预览返回值（NET_DVR_RealPlay_V40 返回值）]
    * @Return: boolean
    */
    public boolean DveStopRealPlay(NativeLong lRealHandle){
        boolean stopPlay = hCNetSDK.NET_DVR_StopRealPlay(lRealHandle);
        if (stopPlay != true){
            errorCode = new NativeLong(hCNetSDK.NET_DVR_GetLastError());
            errorInfo = new NativeLongByReference(errorCode);
            System.err.println("停止(关闭)预览失败，错误代码: "+errorCode+"，"+hCNetSDK.NET_DVR_GetErrorMsg(errorInfo));
        }
        return stopPlay;
    }

    /**
     * 实时预览 回调。
     */
    HCNetSDK.FRealDataCallBack_V30 fRealDataCallBack_V30 = (NativeLong lRealHandle, int dwDataType, ByteByReference pBuffer, int dwBufSize, Pointer pUser) -> {
        Utils.realTimePlayBack(lRealHandle, dwDataType, pBuffer, dwBufSize);
    };
}
