/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.lp.caller.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import ual.lp.server.rmi.ServerInf;

/**
 *
 * @author Divanio Silva
 */
public class ClientRMI {
    public static final String HOST = "172.16.214.237";
    public static final int PORT = 1099;
    
    public static void main(String[] args) {
     
        try {
            Registry registry = LocateRegistry.getRegistry(HOST, PORT);
            ServerInf objRemoto = (ServerInf) registry.lookup("response");
            System.out.println(objRemoto.printMessage());
        } catch (Exception e) {
//            System.out.println("Deu merda no client.");
            System.out.println(e.getMessage());
        }
    }
}