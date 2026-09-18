package com.example.expidi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.button);
        TextView tv = findViewById(R.id.textView);

        EditText edmin= findViewById(R.id.edmin);
        EditText edmax= findViewById(R.id.edmax);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Integer[] imagens = new Integer[]{
                R.drawable.cachorro,
                R.drawable.gardem,
                R.drawable.happy,
                R.drawable.patinho,
                R.drawable.porquinho,
        }
        Button botaoVoltar,botaoAvancar;
        botaoVoltar=findViewById(R.id.btnVoltar);
        botaoAvancar=findViewById(R.id.btnAvançar);

        botaoAvancar.setOnClickListener(View v ->{
            posicao++;
            imageView.setImageResource(imagens[posicao]);
        });
    }
}