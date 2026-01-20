/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.section1.calculate.inputs;

/**
 *
 * @author jamesmurphy
 */
public class S1Form1Input { // This class takes the inputs from Form1

    public static final int TARIFF_DAY_NIGHT = 1;
    public static final int TARIFF_FLAT = 2;

    private String period;
    private double kwhForPeriod;
    private int tariffType;

    private double dayRate;
    private double nightRate;
    private double flatRate;

    private boolean includeVat;
    private boolean includeStandingCharge;
    private boolean includePsoLevy;

    public S1Form1Input(String period,double kwhForPeriod, int tariffType, double dayRate , double nightRate, double flatRate,
            boolean includeVat, boolean includeStandingCharge, boolean includePsoLevy) {
        this.period = period;
        this.kwhForPeriod = kwhForPeriod;
        this.tariffType = tariffType;
        this.dayRate = dayRate;
        this.nightRate = nightRate;
        this.flatRate = flatRate;
        this.includeVat = includeVat;
        this.includeStandingCharge = includeStandingCharge;
        this.includePsoLevy = includePsoLevy;
   
    }

    public String getPeriod() {
        return period;
    }

    public double getKwhForPeriod() {
        return kwhForPeriod;
    }

    public int getTariffType() {
        return tariffType;
    }

    public double getDayRate() {
        return dayRate;
    }

    public double getNightRate() {
        return nightRate;
    }

    public double getFlatRate() {
        return flatRate;
    }

    public boolean isIncludeVat() {
        return includeVat;
    }

    public boolean isIncludeStandingCharge() {
        return includeStandingCharge;
    }

    public boolean isIncludePsoLevy() {
        return includePsoLevy;
    }
    
    
    


}
