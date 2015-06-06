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

        LexHelper lexHelper = new LexHelper();
        this.lexExpresions = lexHelper.getInflatedLexExp(input);
        for (LexExpression lexExpresion : lexExpresions) {

            try {
                AnalizadorJFlex analizador = new AnalizadorJFlex(new StringReader(lexExpresion.getRawExpression()));
                for (int i = 0; i < lexExpresion.getRawExpression().length(); i++) {
                    AnalizadorJFlex analizer = new AnalizadorJFlex(new StringReader(String.valueOf(lexExpresion.getRawExpression().charAt(i))));
                    System.out.println(analizer.yylex());
                    lexExpresion.getTokens().add(analizer.yylex());
                }
                System.out.println("Expresion Regular=" + analizador.yylex());
            } catch (IOException ex) {
                Logger.getLogger(LexProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }

    }

}
