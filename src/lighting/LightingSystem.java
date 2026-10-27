/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lighting;

/**
 *
 * @author DELL 3580
 */
public class LightingSystem extends common.SmartSystemModule {

    private boolean motionDetected;
    private boolean lightStatus; // true = ON, false = OFF
    private String timeOfDay;    // "Day" أو "Night"
    private int noMotionDuration; 

    public LightingSystem(boolean motionDetected, boolean lightStatus, String timeOfDay, int noMotionDuration) {
        this.motionDetected = motionDetected;
        this.lightStatus = lightStatus;
        this.timeOfDay = timeOfDay;
        this.noMotionDuration = noMotionDuration;
    }

    @Override
    public void evaluate() {
        if (motionDetected && !lightStatus && timeOfDay.equalsIgnoreCase("Night")) {

            act = "Turn ON soft lights.";
            exp = "Motion is detected, the time of day is " + timeOfDay + " (Night), and the lights are off, so soft lights are turned on to avoid stumbling.";

        } else if (motionDetected && !lightStatus && timeOfDay.equalsIgnoreCase("Day")) {

            act = "Keep lights OFF.";
            exp = "Motion is detected, the time of day is " + timeOfDay + " (Day), and natural lighting is sufficient.";

        } else if (motionDetected && lightStatus) {

            act = "Keep lights ON + Reset motion timer.";
            exp = "Motion is detected and the lights are already on, which is normal, so the motion timer is reset.";

        } else if (!motionDetected && lightStatus && noMotionDuration >= 15) {

            act = "Turn OFF lights automatically.";
            exp = "No motion has been detected for " + noMotionDuration + " minutes (>= 15 mins) while the lights were on, so they are turned off to save energy.";

        } else if (!motionDetected && lightStatus && noMotionDuration < 15) {

            act = "Keep lights ON temporarily.";
            exp = "No motion is detected, but the duration (" + noMotionDuration + " mins) is less than the 15-minute threshold, so lights stay on temporarily.";

        } else {

            act = "Keep lights OFF.";
            exp = "No motion is detected and the lights are already off, saving energy.";
        }
    }

  

}
