package com.formacion.juanjosecanotena.jjct_recadero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public static ArrayList<Recado> listaRecados;
    public static RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rvRecados);

    }

    public void consultarRecados(View view){

        AsyncTaskRecados asyncTaskRecados = new AsyncTaskRecados(this);
        asyncTaskRecados.execute("");

    }

}
