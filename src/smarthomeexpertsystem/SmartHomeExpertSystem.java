/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthomeexpertsystem;

import uisytem.SplashScreen;
import uisytem.login_page;


/**
 *
 * @author DELL 3580
 */
public class SmartHomeExpertSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SplashScreen splash = new SplashScreen();
        login_page login = new login_page();
        splash.show();
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(35);
                splash.label.setText(Integer.toString(i) + "%");
                splash.jProgressBar1.setValue(i);
                if (i == 100) {
                    splash.dispose();
                    login.show();
                }
            }
        } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
        }
    }
    
}
