package com.example.aluno.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private EditText editNome;
    private EditText editQuantidade;
    private EditText editDTVal;
    private EditText editPreco;
    private Button btnCadastrar;
    private ImageButton btnFoto;
    private TextView mensagem;
    private Button listar;
    private final int tirarFoto = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        editNome = (EditText) findViewById(R.id.editNome);
        editQuantidade = (EditText) findViewById(R.id.editQuantidade);
        editDTVal = (EditText) findViewById(R.id.editDTVal);
        editPreco = (EditText) findViewById(R.id.editPreco);
        btnCadastrar= (Button) findViewById(R.id.btnCadastrar);
        btnFoto= (ImageButton) findViewById(R.id.btnFoto);
        mensagem = (TextView) findViewById(R.id.mensagem);
        listar = (Button) findViewById(R.id.buttonListar);



        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(MainActivity2.this, Foto.class) );
            }
        });

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(MainActivity2.this, ListView.class) );
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {

                    class Produto {

                        private String nome;
                        private Double quantidade;
                        private String data;
                        private Double preco;

                        public Produto() {

                        }

                        public String getNome() {
                            return nome;
                        }

                        public void setNome(String nome) {
                            this.nome = nome;
                        }

                        public Double getQuantidade() {
                            return quantidade;
                        }

                        public void setQuantidade(Double quantidade) {
                            this.quantidade = quantidade;
                        }

                        public String getData() {
                            return data;
                        }

                        public void setData(String data) {
                            this.data = data;
                        }


                        public Double getPreco() {
                            return preco;
                        }

                        public void setPreco(Double preco) {
                            this.preco = preco;

                        }
                    }

                    String nome = editNome.getText().toString();
                    String quantidade = editQuantidade.getText().toString();
                    double x = Double.parseDouble(quantidade);
                    String data = editDTVal.getText().toString();
                    String preco = editPreco.getText().toString();
                    double y = Double.parseDouble(preco);

                    //quantidade = Double.parseDouble(quantidade);
                    //preco = Double.parseDouble(preco);

                    Produto p = new Produto();
                    p.setNome(nome);
                    p.setQuantidade(x);
                    p.setData(data);
                    p.setPreco(y);
                    //p.save();

                   /* if (total >= 60) {
                        mensagem.setText("com.example.aluno.myapplication2.Produto cadastrado");
                    } else {
                        mensagem.setText("O produto não foi cadastrado, tente novamente");
                    }
                    */

                } catch (Exception E){

                    Toast.makeText(MainActivity2.this, "Houve um problema. Tente novamente!", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
