/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;
import com.mycompany.components.Form1;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.mycompany.model.AplicarNimbus;
/**
 *
 * @author geova
 */
public class Main_InterfacePetShop {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
       AplicarNimbus.pegaNimbus();
       System.out.println("Hello World!");
      
       Form1 login = new Form1();
     
       login.setVisible(true);
    
        

}

}
