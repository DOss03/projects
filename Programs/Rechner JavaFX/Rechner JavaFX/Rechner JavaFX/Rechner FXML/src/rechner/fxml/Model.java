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
public class Model {
    
    public float calculate(long number1, long number2, String operator){
        switch(operator){
            //plus rechnen
            case "+":
                return number1 + number2;
            //minus rechnen
            case "-":
                return number1 - number2;
            //mal rechnen
            case "*":
            //druch rechnen
                return number1 * number2;
            case "/":
                if(number2 == 0){
                    return 0;
                }
                return number1 / number2;
            default: 
                return 0;
        }
    }
}
