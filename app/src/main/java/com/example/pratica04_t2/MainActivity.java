package com.example.pratica04_t2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calc(View view){
        Intent it = getIntent();
        double peso = it.getDoubleExtra("peso",0);
        String sexo = it.getStringExtra("sexo");
        int copos = it.getIntExtra("copos",0);
        String jejum = it.getStringExtra("jejum");
        double result;
        double coef;
        if(jejum.equals("n")){
            coef = 1.1;
        }
        else if(sexo.equals("m")){
            coef = 0.7;
        }
        else{
            coef = 0.6;
        }
        result = (4.8)*copos/(peso*coef);
        it.putExtra("taxa",result);
        if(result <= 0.2){
            it.putExtra("alcool", "Pessoa nao alcoolizada");
        }
        else{
            it.putExtra("alcool","Pessoa Alcoolizada");
        }
        setResult(1,it);
        finish();
    }
}