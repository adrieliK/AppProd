package com.example.aluno.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.orm.SugarContext;
import com.orm.query.Select;

import java.util.ArrayList;

import static android.R.layout.simple_list_item_1;
import static android.R.layout.simple_list_item_checked;

public class List extends AppCompatActivity {

    ArrayAdapter<String> _adapter;
    ArrayList<String> produtos;
    ListView _listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView lista= (ListView) findViewById(R.id.lista);

        ArrayList<String> produtos = preencherDados();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, simple_list_item_checked, produtos);
        lista.setAdapter(arrayAdapter);


        }

    private ArrayList<String> preencherDados() {
        ArrayList<String> dados= new ArrayList<String>();

        dados.add("Arroz");
        dados.add("Feijão");
        dados.add("Batata");
        dados.add("Macarrão");
        return dados;
    }
}




 /*produtos = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            produtos.add("Item : " + i);
        }

        int layoutId = android.R.layout.simple_list_item_1;
        _adapter = new ArrayAdapter<String>(this, layoutId, produtos);
        _listView = (ListView) findViewById(R.id.lista);
        _listView.setAdapter(_adapter);
    }


        private void RegistrarEventoTxtAdicionaTexto(){
            final TextView txtAdicionaTexto =(TextView)findViewById(R.id.editNome);

            txtAdicionaTexto.setOnKeyListener(new View.OnKeyListener() {

                @Override

                public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                    if (keyEvent.getAction() == KeyEvent.ACTION_DOWN)
                        if (keyCode == KeyEvent.KEYCODE_ENTER) {
                        String novoItem;
                        novoItem = txtAdicionaTexto.getText().toString();
                        produtos.add(0, novoItem);
                        txtAdicionaTexto.setText("");
                        _adapter.notifyDataSetChanged();
                        return true;
                    }
                        return false;
                }
            });*/

        /*ListView list= findViewById(R.id.lista);

        SugarContext.init(lista.this);
        produto = Select.from(Produto.class).list();
        SugarContext.terminate();

        String lista[] = new String[produto.size()];

        for (int cont = 0; cont < roupas.size();cont++){
            lista[cont] = produto.get(cont).getEtTamRoupa() + " - " + produto.get(cont).getEtTipoRoupa();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(lista.this,android.R.layout.simple_list_item_1, lista);
        list.setAdapter(adapter);*/