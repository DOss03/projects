/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rechner.fxml;

/**
 *
 * @author A.Nguyen.inf19
 * @author D.Osswald.inf19
 */
public class ZusatzMethoden {
    
    public double calculateImperial(long number1, String operator){
        switch(operator){
            //Meter in Inches berechnen
            case "Inches":
                return number1 * 39.3701;
            //Meter in Miles berechnen
            case "Miles":
                return number1 * 0.000621371;
            //Meter in Feet berechnen
            case "Feet":
                return number1 * 3.28084;
            default: 
                return 0;
        }
}
}