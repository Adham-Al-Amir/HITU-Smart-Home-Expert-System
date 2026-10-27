/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author DELL 3580
 */
public abstract class SmartSystemModule {

    protected String act;
    protected String exp;

    public abstract void evaluate();

    public String printACT() {
        return act;
    }
    public String printEXP() {
        return exp;
    }
}
