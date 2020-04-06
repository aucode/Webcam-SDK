package top.aucode;

import top.aucode.sdk.Test;
import top.aucode.sdk.device.Device;
import top.aucode.sdk.entity.DeviceInfo;

/**
 * @Project network-sdk-development
 * @Description: Playvideo
 * @Author AU
 * @Explain 主类
 * @Date 2020-04-04 10:29
 */
public class Playvideo {
    public static void main(String[] args) {
        Device device = new Device();
        device.DvInit();
        DeviceInfo deviceInfo = new DeviceInfo();
        //设置设备信息
        device.DveLoginV40(deviceInfo);
        System.out.println("Main");
    }
}
