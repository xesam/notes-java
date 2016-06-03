package dev.xesam.javalang.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by xesamguo@gmail.com on 16-5-16.
 */
public class IpSwitcher {

    public static void main(String[] args) {
        IpSwitcher ipSwitcher = new IpSwitcher("test.chelaile.net.cn");
        System.out.println(ipSwitcher.getHost());
        ipSwitcher.overture();
        System.out.println(ipSwitcher.getHost());
    }

    private final String domain;
    private String ip;

    private String used;

    public IpSwitcher(String domain) {
        this.domain = domain;
        this.used = domain;
    }

    public void overture() {
        try {
            InetAddress inetAddress = InetAddress.getByName(domain);
            ip = inetAddress.getHostAddress();
            used = ip;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public String getHost() {
        return used;
    }

    public void changeToDomain() {
        used = domain;
    }

    public void changeToIp() {
        if (ip == null || ip.length() == 0) {
            return;
        }
        used = ip;
    }

}
