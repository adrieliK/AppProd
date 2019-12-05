package com.example.aluno.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import com.orm.query.Select;

import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_list_item_1;
import static android.R.layout.simple_list_item_checked;

public class Lista extends AppCompatActivity {

    ArrayList<String> produtos;
    ListView _listView;
    Button listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listar = (Button) findViewById(R.id.listar);

        final List<Produto> produtos = Select.from(Produto.class).list();
        final ListView lista= (ListView) findViewById(R.id.lista);
        ArrayAdapter<Produto> arrayAdapter = new ArrayAdapter<Produto>(this, simple_list_item_checked, (List<Produto>) produtos);
        lista.setAdapter(arrayAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                intent = new Intent(Lista.this, Produto.class);
                Bundle b = new Bundle();
                b.putString("Produto", produtos.get(position).getNome());
                b.putInt("Quantidade",produtos.get(position).getQuantidade());
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(Lista.this, Produto.class);
                    Bundle b = new Bundle();
                    b.putString("Produto", produtos.get(position).getNome());
                    b.putLong("Quantidade",produtos.get(position).getQuantidade());
                    intent.putExtras(b);
                    startActivity(intent);
                }else if(position==1) {
                }
            }
        });

    }
}








