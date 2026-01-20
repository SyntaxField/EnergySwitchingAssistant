/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.section1.calculate.inputs;

import java.io.Serializable;

/**
 *
 * @author jamesmurphy
 */
public class S1Result implements Serializable {
    //declare variables
    private final double totalKwhPeriod;
    private final double totalCostPeriod;
    private final double annualKwh;
    private final double annualCost;

    private final String typicalComparison;
    private final String adviceText;
    
    //constructor
    public S1Result(double totalKwhPeriod, double totalCostPeriod, double annualKwh, double annualCost, String typicalComparison, String adviceText){
        this.totalKwhPeriod = totalKwhPeriod;
        this.totalCostPeriod = totalCostPeriod;
        this.annualKwh = annualKwh;
        this.annualCost = annualCost;
        this.typicalComparison = typicalComparison;
        this.adviceText = adviceText;
    }

    public double getTotalKwhPeriod() {
        return totalKwhPeriod;
    }

    public double getTotalCostPeriod() {
        return totalCostPeriod;
    }

    public double getAnnualKwh() {
        return annualKwh;
    }

    public double getAnnualCost() {
        return annualCost;
    }

    public String getTypicalComparisonText() {
        return typicalComparison;
    }

    public String getTypicalComparison() {
        return typicalComparison;
    }

    public String getAdviceText() {
        return adviceText;
    }


    
}
