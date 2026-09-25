package com.example.expidi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    Button btnVoltar, btnAvancar;
    Integer[] imagens = new Integer[]{
            R.drawable.cachorro,
            R.drawable.gardem,
            R.drawable.happy,
            R.drawable.patinho,
            R.drawable.porquinho,
    };
    ImageView imageView;
    int posicao = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        
        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnAvancar = findViewById(R.id.btnAvancar);
        btnVoltar = findViewById(R.id.btnVoltar);
        imageView = findViewById(R.id.imageView);



        btnAvancar.setOnClickListener( v -> {
            if(posicao > imagens.length) posicao = 0;
            imageView.setImageResource(imagens[posicao]);
            posicao++;
        });
        btnVoltar.setOnClickListener( v -> {
            imageView.setImageResource(imagens[posicao]);
            posicao--;
            if(posicao < 0) posicao = imagens.length -1;
        });
    }
}