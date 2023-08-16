/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author geova
 */
public class AplicarNimbus {
    private AplicarNimbus() {
}
public static void pegaNimbus() {
	try {
	    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	        if ("Nimbus".equals(info.getName())) {
	            UIManager.setLookAndFeel(info.getClassName());
	            break;
	        }
	    }
	} catch (UnsupportedLookAndFeelException e) {

	    System.out.println("Erro: " + e.getMessage());
	    e.printStackTrace();

	} catch (ClassNotFoundException e) {

		System.out.println("Erro: " + e.getMessage());
	    e.printStackTrace();

	} catch (InstantiationException e) {

		System.out.println("Erro: " + e.getMessage());
	    e.printStackTrace();

	} catch (IllegalAccessException e) {

		System.out.println("Erro: " + e.getMessage());
	    e.printStackTrace();
	}
}
    
}
