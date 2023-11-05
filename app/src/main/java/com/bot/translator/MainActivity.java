package com.bot.translator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText textInput; //поле ввода
    private TextView textOutput, textHint; // поле вывода
    private String text; //буферная строка
    private Dictionary dictionary;
    private Button buttonTranslate, buttonHelp; // кнопка перевести
    private ImageButton buttonChange; // кнопка перевести
    private String languageInput = "ru";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dictionary = new Dictionary();
        initInterface();
    }

    private void initInterface(){
        textInput = findViewById(R.id.editTextInput);
        textOutput = findViewById(R.id.TextOutput);
        textHint = findViewById(R.id.textViewHint);

        buttonTranslate = findViewById(R.id.buttonTranslate);
        buttonChange = findViewById(R.id.imageButtonChange);
        buttonHelp = findViewById(R.id.buttonHelp);

        buttonTranslate.setOnClickListener(listenerTranslate);
        buttonChange.setOnClickListener(listenerChange);
        buttonHelp.setOnClickListener(listenerHelp);
    }


    private View.OnClickListener listenerTranslate = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dictionary = new Dictionary();
            text = textInput.getText().toString();
            WordKey wordKey= new WordKey(text);
            Word translatedWord = dictionary.allWord.get(wordKey);
            if(translatedWord!=null){
                textOutput.setText(translatedWord.fin);
            }else {
                textOutput.setText("Такого слова нет в базе");
            }
        }
    };

    private View.OnClickListener listenerChange = new View.OnClickListener() {////
        @Override
        public void onClick(View view) {
            dictionary = new Dictionary();
            if(languageInput=="ru"){
                languageInput="fin";
                textOutput.setHint(R.string.translate_ru);
                textInput.setHint(R.string.input_fin);
            }else {
                languageInput="ru";
                textOutput.setHint(R.string.translate_fin);
                textInput.setHint(R.string.input_ru);
            }
        }
    };

    private View.OnClickListener listenerHelp = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dictionary = new Dictionary();
            String originalText = String.valueOf(textInput.getText());
            WordKey wordKey = new WordKey(originalText);
            wordKey.partSearch = true;
            String translated = dictionary.allWord.get(wordKey).getRu();
            //String translated = dictionary.allWord.headMap(wordKey).toString();
            textHint.setText(translated);
        }
    };
}