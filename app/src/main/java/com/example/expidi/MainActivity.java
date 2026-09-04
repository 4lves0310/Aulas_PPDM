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

        b.setOnClickListener(view -> {

            String minStr=edmin.getText().toString();
            String maxStr=edmax.getText().toString();
            if(minStr.isEmpty()){
                edmin.setError("Informe o valor mínimo");
                return;
            }
            if(maxStr.isEmpty()){
                edmax.setError("Informe o valor maximo");
                return;
            }

            int min = Integer.parseInt(edmin.getText().toString());
            int max = Integer.parseInt(edmax.getText().toString());

            Random random = new Random();
            int r= (random.nextInt(max-min)) + min;

            tv.setText(Integer.toString(r));

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("valor",r);
            startActivity(intent);
        });
    }
}