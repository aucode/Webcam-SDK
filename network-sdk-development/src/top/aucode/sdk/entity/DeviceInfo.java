package top.aucode.sdk.entity;

/**
 * @Project network-sdk-development
 * @Description: DeviceInfo
 * @Author AUCode
 * @Explain 设备信息
 * @Date 2020-04-04 12:50
 */
public class DeviceInfo {
    //id
    private Integer monitoringId;
    //设备端口
    private short devicePort;
    //设备ip
    private String deviceIp;
    //通道号
    private Integer deviceChannel;
    //设备密码
    private String devicePassword;
    //设备登录名
    private String deviceUsername;


    public short getDevicePort() {
        return devicePort;
    }


    public void setDevicePort(short devicePort) {
        this.devicePort = devicePort;
    }

    public Integer getMonitoringId() {
        return monitoringId;
    }


    public void setMonitoringId(Integer monitoringId) {
        this.monitoringId = monitoringId;
    }


    public String getDeviceIp() {
        return deviceIp;
    }


    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }


    public Integer getDeviceChannel() {
        return deviceChannel;
    }


    public void setDeviceChannel(Integer deviceChannel) {
        this.deviceChannel = deviceChannel;
    }


    public String getDevicePassword() {
        return devicePassword;
    }


    public void setDevicePassword(String devicePassword) {
        this.devicePassword = devicePassword;
    }


    public String getDeviceUsername() {
        return deviceUsername;
    }

    public void setDeviceUsername(String deviceUsername) {
        this.deviceUsername = deviceUsername;
    }

}
