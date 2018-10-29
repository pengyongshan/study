package com.tree.www.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by pysh on 2018/9/28.
 */
public interface HelloService extends Remote {
    String sayHello(String name) throws RemoteException;
}
