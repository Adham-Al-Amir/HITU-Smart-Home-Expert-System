/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

/**
 *
 * @author DELL 3580
 */
public class SecuritySystem extends common.SmartSystemModule {

    private String houseMode; // "Home", "Sleep", "Away"
    private boolean motionDetected;

    public SecuritySystem(String houseMode, boolean motionDetected) {
        this.houseMode = houseMode;
        this.motionDetected = motionDetected;
    }

    @Override
    public void evaluate() {
        if (houseMode.equalsIgnoreCase("Sleep") && motionDetected) {
          
            act = "Trigger Alarm: Sound siren + Send immediate notification to phone!";
            exp = "Unauthorized motion was detected while the house mode was set to Sleep.";

        } else if (houseMode.equalsIgnoreCase("Away") && motionDetected) {
           
            act = "Trigger Alarm: Sound siren + Send immediate notification to phone!";
            exp = "Unauthorized motion was detected while the house mode was set to Away.";

        } else if (houseMode.equalsIgnoreCase("Sleep") && !motionDetected) {
          
            act = "System secure (No suspicious motion).";
            exp = "The house is secure in Sleep mode; no motion is detected.";

        } else if (houseMode.equalsIgnoreCase("Away") && !motionDetected) {
          
            act = "System secure (No suspicious motion).";
            exp = "The house is secure in Away mode; no motion is detected.";

        } else if (houseMode.equalsIgnoreCase("Home") && motionDetected) {
             
            act = "Normal operation (No Alarm).";
            exp = "Motion is expected and normal because the house mode is set to Home.";

        } else if (houseMode.equalsIgnoreCase("Home") && !motionDetected) {
            
            act = "System secure (No suspicious motion).";
            exp = "The house is quiet, and the mode is set to Home.";

        } else {
           
            act = "System secure (Default state).";
            exp = "The house security system is active under default settings.";
        }
    }


}
