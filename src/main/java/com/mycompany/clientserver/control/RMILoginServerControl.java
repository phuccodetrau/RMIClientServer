/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clientserver.control;

import com.mycompany.clientserver.RMI.RMILoginInterface;
import com.mycompany.clientserver.model.User;
import com.mycompany.clientserver.view.RMILoginServerView;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HOANGPHUC
 */
public class RMILoginServerControl extends UnicastRemoteObject implements RMILoginInterface {

    public int serverPort;
    private Registry registry;
    public String rmiService;
    private RMILoginServerView view;
    ArrayList<User> csdl = new ArrayList<>();

    private void CreateCSDL() {
        csdl.add(new User("hung", "20012003"));
        csdl.add(new User("dat", "13052003"));
        csdl.add(new User("phuc", "07032003"));
    }

    public RMILoginServerControl(RMILoginServerView view) throws RemoteException {
        super();
        this.view = view;
        CreateCSDL();
        serverPort = 1234;
        rmiService = "LoginUser";
    }

    public boolean checkUser(User user) {
        for (int i = 0; i < csdl.size(); i++) {
            if(user.equals(csdl.get(i))){
                return true;
            }
        }
        return false;
    }

    @Override
    public String checkLogin(User user) {
        if(checkUser(user)){
            return "Login successfull";
        }
        return "Login fail";
    }
    public void getDNConnection(String rmiService, int serverPort){
        try {
            registry = LocateRegistry.createRegistry(serverPort);
            registry.bind(rmiService, new RMILoginServerControl(view));
            System.out.println("Running and ready....");
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (AlreadyBoundException e) {
            throw new RuntimeException(e);
        }
    }
}
