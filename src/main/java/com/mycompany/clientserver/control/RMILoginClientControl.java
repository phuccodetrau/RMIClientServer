/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clientserver.control;

import com.mycompany.clientserver.RMI.RMILoginInterface;
import com.mycompany.clientserver.view.RMILoginClientView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HOANGPHUC
 */
public class RMILoginClientControl {

    private String serverHost;
    private int serverPort;
    private RMILoginClientView view;
    private String rmiService;
    private RMILoginInterface rmiServer;
    private Registry registry;

    public RMILoginClientControl(RMILoginClientView view) {
        this.view = view;
        serverHost = "localhost";
        serverPort = 1234;
        rmiService = "LoginUser";
        this.view.setVisible(true);
    }

    public class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                rmiServer = (RMILoginInterface) Naming.lookup("rmi://" + serverHost + ":" + serverPort + "/" + rmiService);
                view.showMessage(rmiServer.checkLogin(view.getUser()));
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            } catch (NotBoundException ex) {
                throw new RuntimeException(ex);
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
