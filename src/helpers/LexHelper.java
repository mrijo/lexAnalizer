/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miguel
 */
package helpers;

import java.util.ArrayList;
import model.LexExpression;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LexHelper {

    public ArrayList<LexExpression> getInflatedLexExp(String rawText) {
        BufferedReader reader = new BufferedReader(new StringReader(rawText));
        ArrayList<LexExpression> lexExpressions = new ArrayList<>();
        LexExpression lexExpression;
        String line;

        try {
           while((line = reader.readLine())!= null) {
                lexExpression = new LexExpression();
                lexExpression.setRawExpression(line);
                lexExpressions.add(lexExpression);    
            }

        } catch (IOException ex) {
            Logger.getLogger(LexHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lexExpressions;
    }

}
