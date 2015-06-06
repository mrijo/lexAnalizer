/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexanalizer;

import java.io.File;
import view.LexAnalizerView;

/**
 * ((({D}+("*"|"+"|"-"|"/"|"^"){D}+)+) | ((("*"|"+"|"-"|"/"|"^")(("(")({D}+("*"|"+"|"-"|"/"|"^"){D}+)+(")")))("*"|"+"|"-"|"/"|"^"){D}+)  | (("*"|"+"|"-"|"/"|"^")(("(")({D}+("*"|"+"|"-"|"/"|"^"){D}+)+(")"))) | (((("(")({D}+("*"|"+"|"-"|"/"|"^"){D}+)+(")")))(("*"|"+"|"-"|"/"|"^"){D}+)*))* {Tipo=yytext(); return VALIDO;}
 * @author miguel
 */
public class LexAnalizer {

    /**
     * @param args the command line argumentsasdasd
     */
    public static void main(String[] args) {
        LexAnalizerView lexAnalizaer = new LexAnalizerView();
        lexAnalizaer.setVisible(true);
        try {
            String path = "src\\lexanalizer\\lexer.flex";
            generadorLexer(path);
        } catch (Exception ex) {
            System.out.println("ERROR LEXICO");
        }

    }

    public static void generadorLexer(String path) {
        File file = new File(path);
        jflex.Main.generate(file);

		//JFlex.Main.generate(file);
    }

}
