/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.section1.calculate.inputs;

/**
 *
 * @author jamesmurphy
 */
public class S1Form2Input {
    //declare variables
    private String energySetup;
    private int peopleCount;
    private int nightPercent;
    private boolean primaryHeatingElectric;
    
    //constructor
    public S1Form2Input(){  
        //initialise values
        energySetup = "";
        peopleCount = 1;
        nightPercent = 0;
        primaryHeatingElectric = false;
        
    }
    
    public S1Form2Input(String energySetup, int peopleCount, int nightPercent, boolean primaryHeatingElectric) {
        this.energySetup = energySetup;
        this.peopleCount = peopleCount;
        this.nightPercent = nightPercent;
        this.primaryHeatingElectric = primaryHeatingElectric;
    }
        
    //getters
    public String getEnergySetup() {
        return energySetup;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public int getNightPercent() {
        return nightPercent;
    }


    public boolean isPrimaryHeatingElectric() {
        return primaryHeatingElectric;
    }
    
    
}
