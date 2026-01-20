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
public class Section1Calculate {
    //declare and assign values to constants
    // electricty rates inc vat
    private static final double STANDING_URBAN_YEAR_INC_VAT = 250.77;
    private static final double PSO_YEAR_INC_VAT = 19.10; 
    private static final double URBAN_SMART_METER_INC_VAT = 1258.00; 
    // electricty rates ex vat
    private static final double STANDING_URBAN_YEAR_EX_VAT = 230.06; 
    private static final double PSO_YEAR_EX_VAT = 17.52; 
    private static final double URBAN_SMART_METER_EX_VAT = 1154.00; 
    
    public static S1Result calculate(S1Form1Input f1, S1Form2Input f2) {
        
        double kwhPeriod = f1.getKwhForPeriod();
        boolean isMonthly = f1.getPeriod().equals("Monthly");
        
        double annualKwh;
        if (isMonthly){
            annualKwh = kwhPeriod * 12.0;
        }else {
            annualKwh = kwhPeriod;
        }
        
        double unitCostPeriod;
        if (f1.getTariffType() == S1Form1Input.TARIFF_DAY_NIGHT){
            double nightFrac = f2.getNightPercent()/100.00;
            double dayFrac = 1.0 - nightFrac;
            double dayKwh = kwhPeriod * dayFrac;
            double nightKwh = kwhPeriod * nightFrac;
            unitCostPeriod = (dayKwh * f1.getDayRate()) + (nightKwh * f1.getNightRate());
        }else{
            unitCostPeriod = kwhPeriod * f1.getFlatRate();
        }
        
        double unitCostAnnual;
        if(isMonthly){
            unitCostAnnual = unitCostPeriod * 12.0; 
        }else {
            unitCostAnnual = unitCostPeriod;
        }
        
        double standingAnnual;
        double psoAnnual;
        
        if (f1.isIncludeVat()){
            standingAnnual = STANDING_URBAN_YEAR_INC_VAT;
            psoAnnual = PSO_YEAR_INC_VAT;
        }else {
            standingAnnual = STANDING_URBAN_YEAR_EX_VAT;
            psoAnnual = PSO_YEAR_EX_VAT;
        }
        
        if (!f1.isIncludeStandingCharge()){
            standingAnnual = 0.0;
        }
        
        if (!f1.isIncludePsoLevy()){
            psoAnnual = 0.0;
        }
        
        double annualCost = unitCostAnnual + standingAnnual + psoAnnual;
        double periodCost;
        if (isMonthly){
            periodCost = unitCostPeriod + (standingAnnual / 12.0) + (psoAnnual / 12.0);
        }else {
            periodCost = unitCostPeriod + standingAnnual + psoAnnual;
        }
        
        double typicalBill;
        if(f1.isIncludeVat()){
            typicalBill = URBAN_SMART_METER_INC_VAT;
        }else{
            typicalBill = URBAN_SMART_METER_EX_VAT;
        }
        
        String comparison;
        if(annualCost > typicalBill){
            comparison = "Above typical household usage";
        }else if (annualCost < typicalBill) {
            comparison = "Below typical household usage";
        }else{
            comparison = "This is typical household usage";
        }
        
        
        String advice;
        advice = "The estimated annual cost is based on your kWh and rates.\nNight usage: " + f2.getNightPercent();
        
        return new S1Result(kwhPeriod, periodCost, annualKwh, annualCost, comparison, advice);
    }
    
}
