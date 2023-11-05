package com.bot.translator;

import java.util.TreeMap;

public class Dictionary {
    public TreeMap<WordKey, Word> allWord;

    public Dictionary() {
        allWord = new TreeMap<>();
        Word word1 = new Word("стол", "sanakirja"); // Создаю слова
        Word word2 = new Word("стул", "tuoli");
        Word word3 = new Word("ложка", "lusikka");
        Word word4 = new Word("вилка", "haarukka");

        allWord.put(new WordKey(word1.getRu()), word1); // Добавляю слова в TreeMap и сортирую их по алфавиту
        allWord.put(new WordKey(word2.getRu()), word2);
        allWord.put(new WordKey(word3.getRu()), word3);
        allWord.put(new WordKey(word4.getRu()), word4);

    }
}
