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

import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;

public class MainActivity2 extends AppCompatActivity {
    private EditText editNome;
    private EditText editQuantidade;
    private EditText editDTVal;
    private EditText editPreco;
    private Button btnCadastrar;
    private ImageButton btnFoto;
    private Button buttonListar;
    private final int tirarFoto = 3;
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
                startActivity(new Intent(MainActivity2.this, List.class));
            }
        });



        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Receber os dados dos campos de texto
                    String nome = editNome.getText().toString();
                    String quantidade = editQuantidade.getText().toString();
                    double x = Double.parseDouble(quantidade);
                    String data = editDTVal.getText().toString();
                    String preco = editPreco.getText().toString();
                    double y = Double.parseDouble(preco);

                // Cria um objeto de pessoa
                Produto p = new Produto();
                p.setNome(nome);
                p.setQuantidade(x);
                p.setData(data);
                p.setPreco(y);

                // Salva no banco de dados
                p.save();


            }
        });

        /*buttonListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Lista todas as pessoas
                List<List> listaDeProduto = Produto.listAll(List.class);

                // Cria uma String para concatenar o nome das pessoas
                String lista = "";

                // Faz um foreach nessa lista de pessoas
                for (Produto p: listaDeProdutos ) {

                    lista = lista + p.getNome() + "\n";

                }

                // Coloca a lista de pessoas no TextView
                produto.setText(lista);

            }
        });

        buttonListar.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(lista.this, Produto.class);
                    intent.putExtra("Produto", nome.get(position).getNome());
                    startActivity(intent);
                }

            }
        });*/


    }



}