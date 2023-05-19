/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clientserver;

import com.mycompany.clientserver.control.RMILoginClientControl;
import com.mycompany.clientserver.view.RMILoginClientView;

/**
 *
 * @author HOANGPHUC
 */
public class ClientRun {

    public static void main(String[] args) {
        RMILoginClientView view = new RMILoginClientView();
        RMILoginClientControl controller = new RMILoginClientControl(view);
    }

}
