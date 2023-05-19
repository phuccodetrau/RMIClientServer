/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clientserver;

import com.mycompany.clientserver.control.RMILoginServerControl;
import com.mycompany.clientserver.view.RMILoginServerView;

import java.rmi.RemoteException;

public class ServerRun {

    public static void main(String[] args) throws RemoteException {
        RMILoginServerView view = new RMILoginServerView();
        RMILoginServerControl controller = new RMILoginServerControl(view);
        controller.getDNConnection(controller.rmiService, controller.serverPort);
    }

}
