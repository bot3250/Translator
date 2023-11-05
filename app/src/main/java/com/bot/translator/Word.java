package com.bot.translator;

import java.util.HashMap;
import java.util.Map;

public class Word {

    String ru, fin;

    public Word(String ru, String fin){
        this.ru = ru;
        this.fin = fin;
    }

    public String getRu(){ // Слово на русском языке
        return ru;
    }

    public String getFin(){ // Слово на финском языке
        return fin;
    }

}
