package dev.xesam.javalang.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * <p>
 * Created by xe xesamguo@gmail.com on 2/23/16.
 */
public class HelloServer {
    public static void main(String[] args) {
        try {
            IHelloService service = new HelloServiceImpl();
            LocateRegistry.createRegistry(20000);
            Naming.bind("rmi://localhost:20000/Hello", service);
        } catch (AlreadyBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
        System.out.println("bind success");
    }
}
