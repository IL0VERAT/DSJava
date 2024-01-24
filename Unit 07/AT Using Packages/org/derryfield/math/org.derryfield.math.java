package org.derryfield.math;
public class Geometry{
    
    public static double calcVolSphere(double r){
        double volResult = (4/3)* Math.PI * (r*r*r);
        return volResult;
    }
    
    public static double calcSurfSphere(double r){
        double surfResult = 4 * Math.PI * (r*r);
        return surfResult;
    }
    
}
