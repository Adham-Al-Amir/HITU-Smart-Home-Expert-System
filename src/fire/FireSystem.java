/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fire;

/**
 *
 * @author DELL 3580
 */
public class FireSystem extends common.SmartSystemModule {

    private boolean smokeSensor;
    private int smokeDuration; // by second

    public FireSystem(boolean smokeSensor, int smokeDuration) {
        this.smokeSensor = smokeSensor;
        this.smokeDuration = smokeDuration;
    }

    @Override
    public void evaluate() {
        if (smokeSensor && smokeDuration >= 5) {
            act = "1. Trigger Fire Alarm ON.\n"
                    + "2. Send emergency notification to phone and authorities.\n"
                    + "3. Turn off climate systems to prevent smoke spreading.\n"
                    + "4. Start smoke extraction and open evacuation paths automatically.\n"
                    + "5. Cut non-essential electrical circuits while keeping emergency lights on.";
            exp = "Heavy smoke was detected for " + smokeDuration + " seconds (hazard confirmed).";
        } else {
            act = "No action required (Normal status).";
            exp = "Smoke sensor is normal, no fire risks detected.";
        }
    }


}
