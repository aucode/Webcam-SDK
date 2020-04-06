package top.aucode.sdk;

import com.sun.jna.NativeLong;
import com.sun.jna.ptr.IntByReference;

import java.util.Timer;

/**
 * @Project network-sdk-development
 * @Description: Test
 * @Author AUCode
 * @Explain
 * @Date 2020-04-04 16:45
 */
public class Test {
//    static HCNetSDK hCNetSDK = HCNetSDK.INSTANCE;
//    static HCNetSDK.NET_DVR_DEVICEINFO_V30 m_strDeviceInfo;// 设备信息
//    static HCNetSDK.NET_DVR_IPPARACFG m_strIpparaCfg;// IP参数
//    static HCNetSDK.NET_DVR_CLIENTINFO m_strClientInfo;// 用户参数
//    static NativeLong lUserID;// 用户句柄
//    static NativeLong m_lLoadHandle;// 下载句柄
//    static String sDeviceIP;// IP
//    static Timer Downloadtimer;
//
//    public void A_d() {
//        // =====================1. 初始化开始====================================
//        boolean initfalse = hCNetSDK.NET_DVR_Init();// 初始化
//        if (initfalse != true) {
//            System.out.println("初始化失败！");
//        } else {
//            System.out.println("初始化成功！");
//        }
//        // =====================初始化结束=====================================
//
//        // =====================2. 注册服务开始====================================
//        sDeviceIP = "10.13.35.229";// IP
//        int iPort = 8000;// 端口号
//        String textFieldUserName = "admin";// 用户名
//        String passwordFieldPwd = "abcd1234";// 密码
//
//        m_strDeviceInfo = new HCNetSDK.NET_DVR_DEVICEINFO_V30();
//        lUserID = hCNetSDK.NET_DVR_Login_V30(sDeviceIP, (short) iPort, textFieldUserName, passwordFieldPwd,
//                m_strDeviceInfo);
//        long userID = lUserID.longValue();
//        System.out.println(userID);
//        if (userID >= 0) {
//            System.out.println("登陆注册成功");
//        } else if (userID == -1) {
//            System.out.println("登陆注册失败");
//        }
//
//        // =====================注册服务结束====================================
//
//
//        // =====================按照开始时间和结束时间下载视频 开始====================================
//        m_lLoadHandle = new NativeLong(-1);
//        if (m_lLoadHandle.intValue() == -1) {
//            HCNetSDK.NET_DVR_TIME struStartTime;
//            HCNetSDK.NET_DVR_TIME struStopTime;
//
//            struStartTime = new HCNetSDK.NET_DVR_TIME();
//            struStopTime = new HCNetSDK.NET_DVR_TIME();
//            struStartTime.dwYear = Integer.parseInt("2019");// 开始时间
//            struStartTime.dwMonth = Integer.parseInt("3");
//            struStartTime.dwDay = Integer.parseInt("26");
//            struStartTime.dwHour = Integer.parseInt("18");
//            struStartTime.dwMinute = Integer.parseInt("0");
//            struStartTime.dwSecond = Integer.parseInt("0");
//
//            struStopTime.dwYear = Integer.parseInt("2019");// 结束时间
//            struStopTime.dwMonth = Integer.parseInt("3");
//            struStopTime.dwDay = Integer.parseInt("26");
//            struStopTime.dwHour = Integer.parseInt("18");
//            struStopTime.dwMinute = Integer.parseInt("5");
//            struStopTime.dwSecond = Integer.parseInt("0");
//            int m_iChanShowNum = 1;// 通道（摄像头IP地址）
//
//            String sFileName = "E:\\test\\" + sDeviceIP + m_iChanShowNum + struStartTime.toStringTitle() + struStopTime.toStringTitle() + ".mp4";
//            System.out.println(sFileName);
//
//            // 视频下载调用
//            m_lLoadHandle = hCNetSDK.NET_DVR_GetFileByTime(lUserID, new NativeLong(m_iChanShowNum), struStartTime,
//                    struStopTime, sFileName);
//            if (m_lLoadHandle.intValue() >= 0) {
//                hCNetSDK.NET_DVR_PlayBackControl(m_lLoadHandle, HCNetSDK.NET_DVR_PLAYSTART, 0, null);
//                Downloadtimer = new Timer();// 新建定时器
//                Downloadtimer.schedule(new DownloadTask(), 0, 5000);// 0秒后开始响应函数
//                // System.out.println("视频下载成功！");
//            } else {
//                System.out.println("下载失败");// 按时间
//                System.out.println("laste error " + hCNetSDK.NET_DVR_GetLastError());
//                return;
//            }
//        }
//    }
//
//    /*************************************************
//     * 类: DownloadTask 类描述: 下载定时器响应函数
//     *************************************************/
//    class DownloadTask extends java.util.TimerTask {
//        // 定时器函数
//        @Override
//        public void run() {
//            IntByReference nPos = new IntByReference(0);
//            hCNetSDK.NET_DVR_PlayBackControl(m_lLoadHandle, HCNetSDK.NET_DVR_PLAYGETPOS, 0, nPos);
//            if (nPos.getValue() > 100) {
//                hCNetSDK.NET_DVR_StopGetFile(m_lLoadHandle);
//                m_lLoadHandle.setValue(-1);
//                Downloadtimer.cancel();
//                System.out.println("由于网络原因或DVR忙,下载异常终止!");
//            }
//            if (nPos.getValue() == 100) {
//                hCNetSDK.NET_DVR_StopGetFile(m_lLoadHandle);
//                m_lLoadHandle.setValue(-1);
//                Downloadtimer.cancel();
//                System.out.println("按时间下载结束!");
//            }
//        }
//    }
}
