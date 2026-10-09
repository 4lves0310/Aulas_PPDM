package com.example.expidi;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> nomes;
    EditText txtdigitar;
    Button btnadd;

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

        nomes = new ArrayList<String>();
        txtdigitar = findViewById(R.id.txtdigitar);
        btnadd = findViewById(R.id.btnadd);
        ListView lv = findViewById(R.id.listView);
        ArrayAdapter<String> usb = new ArrayAdapter<>(getApplicationContext(),R.layout.item_lista, R.id.textView, nomes);
        btnadd.setOnClickListener(view -> {
            String novoNome = txtdigitar.getText().toString();
            nomes.add(novoNome);
            usb.notifyDataSetChanged();
            txtdigitar.setText("");
                });

        lv.setOnItemClickListener((adapterView, view, position, l) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Tem Certeza?")
                    .setMessage("Confirma a exclusão do item?")
                    .setPositiveButton("ok", (dialogInterface, i) -> {
                        nomes.remove(position);
                        usb.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(), "Item excluído", Toast.LENGTH_LONG).show();
                    })
                    .setNegativeButton("cancelar", (dialogInterface, i) -> {
                        Toast.makeText(getApplicationContext(), "Item não excluído", Toast.LENGTH_LONG).show();
                    })
                    .show();
                }
        );
        lv.setAdapter(usb);
    }
}