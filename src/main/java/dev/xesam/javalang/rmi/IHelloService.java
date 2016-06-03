package dev.xesam.javalang.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by xe xesamguo@gmail.com on 2/23/16.
 */
public interface IHelloService extends Remote {
    public String sayHello() throws RemoteException;
}
