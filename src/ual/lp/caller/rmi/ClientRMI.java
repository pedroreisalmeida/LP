/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.lp.caller.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import ual.lp.caller.gui.CallerGUI;
import ual.lp.caller.utils.Config;
import ual.lp.server.rmi.ServerInf;

/**
 *
 * @author Divanio Silva
 */
public class ClientRMI {
    //172.16.214.237
    //172.16.120.77
    private String host = null;
    public static final int PORT = 1099;
   private String myIP = null;
    private CallerGUI callerGUI;

    public ClientRMI(CallerGUI callerGUI) throws RemoteException, NotBoundException{
        this.callerGUI = callerGUI;
        this.host = callerGUI.getServerIP();
        this.myIP = callerGUI.getMyIP();
        System.setProperty("java.rmi.server.hostname", myIP);//informar isso no relatório
            
            Registry registry = LocateRegistry.getRegistry(host, PORT);
            ServerInf remoteObj = (ServerInf) registry.lookup("response");
            this.callerGUI.setRemoteObject(remoteObj);
            this.callerGUI.setCallerInf(new CallerImpl(this.callerGUI));
                     
    }
    

//    public ClientRMI() {
//        try {
//            System.setProperty("java.rmi.server.hostname", "localhost");//informar isso no relatório
//            Registry registry = LocateRegistry.getRegistry(HOST, PORT);
//            ServerInf objRemoto = (ServerInf) registry.lookup("response");
//            System.out.println(objRemoto.printMessage());
//            CallerImpl callback = new CallerImpl(this.callerGUI);
////            objRemoto.connect(callback);
//            objRemoto.TockTock(new Config().getEmployee());
//             
//            System.out.println((objRemoto.getNextTicket(new Config().getEmployee())).getNumberticket());
//            
//
//        } catch (Exception e) {
////            System.out.println("Deu merda no client.");
//            System.out.println(e.getMessage());
//        }
//    }
    
    
}
