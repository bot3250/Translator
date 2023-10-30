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
    private TextView textOutput; // поле вывода
    private String text; //буферная строка
    private Map<String, String> ruFi;// словарь
    private Button buttonTranslate; // кнопка перевести
    private ImageButton buttonChange; // кнопка перевести
    private String languageInput = "ru";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ruFi = new HashMap<>();
        dataInitial();
        initInterface();
    }

    private void initInterface(){
        textInput = findViewById(R.id.editTextInput);
        textOutput = findViewById(R.id.TextOutput);
        buttonTranslate = findViewById(R.id.buttonTranslate);
        buttonChange = findViewById(R.id.imageButtonChange);

        buttonTranslate.setOnClickListener(listenerTranslate);
        buttonChange.setOnClickListener(listenerChange);
    }

    private void dataInitial(){
        //добавление слов в словарь
        ruFi.put("Привет", "Hei");
        ruFi.put("Пока", "Hei hei");
        ruFi.put("Я", "minä");
        ruFi.put("Ты", "sinä");
        ruFi.put("Мы", "Me");
        ruFi.put("Как дела", "mitä kuuluu");
        ruFi.put("она", "hän");
        ruFi.put("он", "hei");
    }

    private View.OnClickListener listenerTranslate = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            text = textInput.getText().toString();
            if(ruFi.get(text)!=null){
                textOutput.setText(ruFi.get(text));
            }else {
                textOutput.setText("Такого слова нет в базе");
            }
        }
    };

    private View.OnClickListener listenerChange = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
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
}