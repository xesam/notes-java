package io.github.xesam.lang.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by xe xesamguo@gmail.com on 2/24/16.
 */
public class HelloClient {
    public static void main(String[] args) {
        try {
            IHelloService helloService = (IHelloService) Naming.lookup("rmi://localhost:20000/Hello");
            String resp = helloService.sayHello();
            System.out.println(resp);
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
