package com.example.expidi;

import android.content.ContentValues;import android.database.sqlite.SQLiteDatabase;import android.os.Bundle;import android.widget.Button;import android.widget.EditText;import android.widget.ListView;import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase database;
    EditText EdText;
    Button button;
    ListView listView;
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
        database = openOrCreateDatabase("notinhas", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS notas" + "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "titulo VARCHAR," + "conteudo VARCHAR)");
        EdText=findViewById(R.id.EdText);
        button=findViewById(R.id.button);
        listView=findViewById(R.id.listView);

        button.setOnClickListener(v -> {
            String titulo=EdText.getText().toString();
            ContentValues values=new ContentValues();
            values.put("titulo",titulo);
            int id=(int) database.insert("notas", null,values);
            if (id<0) {
                Toast.makeText(getApplicationContext(), "Nota salva com sucesso", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Erro ao Salvar", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void listarNotas(){
        database.rawQuery("SELECT * FROM notas LIMIT",null);
    }
}