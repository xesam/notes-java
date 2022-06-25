package io.github.xesam.lang.rmi;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by xe xesamguo@gmail.com on 2/23/16.
 */
public class HelloServiceImpl extends UnicastRemoteObject implements IHelloService {
    protected HelloServiceImpl() throws RemoteException {
    }

    protected HelloServiceImpl(int port) throws RemoteException {
        super(port);
    }

    protected HelloServiceImpl(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    @Override
    public String sayHello() throws RemoteException {
        return "this is ServiceImpl";
    }
}
