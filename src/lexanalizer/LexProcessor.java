/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexanalizer;

import helpers.LexHelper;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.LexExpression;
import model.Tokens;

/**
 *
 * @author miguel
 */
public class LexProcessor {

    private static LexProcessor newInstance;
    private ArrayList<LexExpression> lexExpresions;

    private LexProcessor() {
        //hiding constructor
        this.lexExpresions = new ArrayList<>();
    }

    ;

    public static LexProcessor getNewInstance() {
        if (newInstance == null) {
            return new LexProcessor();
        }
        return newInstance;
    }

    public void process(String input) {
        int parentesis = 0;
        LexHelper lexHelper = new LexHelper();
        this.lexExpresions = lexHelper.getInflatedLexExp(input);
        for (LexExpression lexExpresion : lexExpresions) {

            try {
                AnalizadorJFlex analizador = new AnalizadorJFlex(new StringReader(lexExpresion.getRawExpression()));
                for (int i = 0; i < lexExpresion.getRawExpression().length(); i++) {
                    AnalizadorJFlex analizer = new AnalizadorJFlex(new StringReader(String.valueOf(lexExpresion.getRawExpression().charAt(i))));
                    Tokens token = analizer.yylex();
                    if (token != null) {
                        if (token == Tokens.PARENTESISDERECHO) {
                            parentesis--;
                        } else if (token == Tokens.PARENTESISIZQUIERDO) {
                            parentesis++;
                        }
                        lexExpresion.setValid((parentesis > -1));
                        lexExpresion.getTokens().add(token);
                    }
                     lexExpresion.setValid((parentesis !=0)? false: lexExpresion.isValid() );
                }
                lexExpresion.setValid((analizador.yylex() == Tokens.ERROR) ? false : lexExpresion.isValid());
            } catch (IOException ex) {
                Logger.getLogger(LexProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<LexExpression> getLexExpresions() {
        return lexExpresions;
    }

    public void setLexExpresions(ArrayList<LexExpression> lexExpresions) {
        this.lexExpresions = lexExpresions;
    }

}
