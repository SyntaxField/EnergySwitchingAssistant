/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.section1.calculate.logic;

import ui.section1.calculate.inputs.S1Form1Input;
import ui.section1.calculate.inputs.S1Form2Input;
import ui.section1.calculate.inputs.S1Result;
/**
 *
 * @author jamesmurphy
 */
public class Section1Logic {
    
    public static S1Result runCalculation(String period,double kwhPeriodValue,int tariffType,double dayRateValue,double nightRateValue,double flatRateValue,boolean includeVat,boolean includeStanding,boolean includePso,String energySetup,int peopleCount,int nightPercentValue,boolean primaryHeatingElectric){
    
    S1Form1Input f1 = new S1Form1Input(period,kwhPeriodValue,tariffType,dayRateValue,nightRateValue,flatRateValue,includeVat,includeStanding,includePso);
    
    S1Form2Input f2 = new S1Form2Input(energySetup,peopleCount,nightPercentValue,primaryHeatingElectric);
    
    //return result
    return Section1Calculate.calculate(f1,f2); 
    
}
            
    
}
