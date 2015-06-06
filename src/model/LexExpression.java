/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author miguel
 */
public class LexExpression {

    private ArrayList<Tokens> tokens;
    private String rawExpression;
    private boolean valid;

    public LexExpression() {
        this.rawExpression = "";
        this.tokens = new ArrayList<>();
    }

    public ArrayList<Tokens> getTokens() {
        return tokens;
    }

    public void setTokens(ArrayList<Tokens> tokens) {
        this.tokens = tokens;
    }

    public String getRawExpression() {
        return rawExpression;
    }

    public void setRawExpression(String rawExpression) {
        this.rawExpression = rawExpression;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
    
}
