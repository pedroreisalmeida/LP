/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.lp.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import ual.lp.display.DisplayInf;

/**
 *
 * @author Divanio Silva
 */
public interface ServerToDisplayInf extends Remote {
    
    public void connect (DisplayInf displayInf) throws RemoteException;
        
}