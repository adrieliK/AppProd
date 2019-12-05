package com.example.aluno.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.orm.SugarDb;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

public class MainActivity2 extends AppCompatActivity {
    private EditText editNome;
    private EditText editQuantidade;
    private EditText editDTVal;
    private EditText editPreco;
    private Button btnCadastrar;
    private ImageButton btnFoto;
    private Button buttonListar;
    private TextView textNome;
    private TextView textQuantidade;
    private TextView textData;
    private TextView textPreco;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        editNome = (EditText) findViewById(R.id.editNome);
        editQuantidade = (EditText) findViewById(R.id.editQuantidade);
        editDTVal = (EditText) findViewById(R.id.editDTVal);
        editPreco = (EditText) findViewById(R.id.editPreco);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnFoto = (ImageButton) findViewById(R.id.btnFoto);
        buttonListar = (Button) findViewById(R.id.buttonListar);

        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, Foto.class));
            }
        });

        buttonListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, Lista.class));
            }
        });



        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = editNome.getText().toString();
                String quantidade = editQuantidade.getText().toString();
                int x = Integer.parseInt(quantidade);
                String data = editDTVal.getText().toString();
                String preco = editPreco.getText().toString();
                double y = Double.parseDouble(preco);

                Produto p = new Produto();
                p.setNome(nome);
                p.setQuantidade(x);
                p.setData(data);
                p.setPreco(y);

                p.save();
                makeText(MainActivity2.this, "Houve um problema, tente novamente!", LENGTH_SHORT).show();

            }
        });


    }



}