/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package climate;

/**
 *
 * @author DELL 3580
 */
public class ClimateSystem extends common.SmartSystemModule {

    private double temperature;
    private boolean userPresent;
    private boolean windowStatus; // true = Open, false = Closed



    public ClimateSystem(double temperature, boolean userPresent, boolean windowStatus) {
        this.temperature = temperature;
        this.userPresent = userPresent;
        this.windowStatus = windowStatus;
    }


    @Override
    public void evaluate() {

        if (temperature > 30 && userPresent && !windowStatus) {
            act = "Turn on the air conditioner (22°C) + Close the curtains.";
            exp = "The temperature is " + temperature + "°C, people are present, and the windows are closed.";
        } else if (temperature > 30 && userPresent && windowStatus) {
            act = "Close the windows first -> Turn on the air conditioner (22°C) -> Close the curtains.";
            exp = "The temperature is " + temperature + "°C, and the windows were open. Closing them first prevents cooling energy waste.";
        } else if (temperature > 30 && !userPresent) {
            act = "Close the curtains + (Close the windows if open) + Keep the air conditioner OFF.";
            exp = "The temperature is " + temperature + "°C, and the house is empty, so energy is saved.";
        } else if (temperature >= 18 && temperature <= 30 && userPresent) {
            act = "Turn on the ceiling fan only (No air conditioning or heating).";
            exp = "The temperature is " + temperature + "°C, which is comfortable, so normal ventilation is sufficient.";
        } else if (temperature >= 18 && temperature <= 30 && !userPresent) {
            act = "Turn off all climate control devices.";
            exp = "The temperature is normal, and the house is empty.";
        } else if (temperature < 18 && userPresent && !windowStatus) {
            act = "Turn on the heater.";
            exp = "The temperature is " + temperature + "°C, which is below 18°C, and the windows are closed.";
        } else if (temperature < 18 && userPresent && windowStatus) {
            act = "Close the windows first -> Turn on the heater.";
            exp = "The temperature is " + temperature + "°C, and the windows are open. Closing them first prevents cold air from entering.";
        } else if (temperature < 18 && !userPresent) {
            act = "Keep the heater OFF.";
            exp = "The weather is cold, but the house is empty, so energy is saved.";
        }

    }

    
  

    

 
}
