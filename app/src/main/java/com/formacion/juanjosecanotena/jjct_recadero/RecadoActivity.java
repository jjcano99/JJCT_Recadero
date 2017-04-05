package com.formacion.juanjosecanotena.jjct_recadero;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by juanjosecanotena on 5/4/17.
 */

public class RecadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recado);

        Bundle extras = getIntent().getExtras();
        final Integer posicion = extras.getInt("POSICION");

        TextView tvNombre = (TextView) findViewById(R.id.tvRecadoNombreCliente);
        TextView tvDescripcion = (TextView) findViewById(R.id.tvRecadoDescripcion);
        TextView tvDireccionEntrega = (TextView) findViewById(R.id.tvRecadoDireccionEntrega);
        TextView tvDireccionRecogida = (TextView) findViewById(R.id.tvRecadoDireccionRecogida);
        TextView tvTelefono = (TextView) findViewById(R.id.tvRecadoTelefono);
        TextView tvFechaHora = (TextView) findViewById(R.id.tvRecadoFechaHora);
        TextView tvHoraMaxima = (TextView) findViewById(R.id.tvRecadoHoraMaxima);

        Button bPendiente = (Button) findViewById(R.id.bPendiente);
        Button bRealizado = (Button) findViewById(R.id.bRealizado);

        tvNombre.setText(MainActivity.listaRecados.get(posicion).getNombre_cliente());
        tvDescripcion.setText(MainActivity.listaRecados.get(posicion).getDescripcion());
        tvDireccionEntrega.setText(MainActivity.listaRecados.get(posicion).getDireccion_entrega());
        tvDireccionRecogida.setText(MainActivity.listaRecados.get(posicion).getDireccion_recogida());
        tvTelefono.setText(MainActivity.listaRecados.get(posicion).getTelefono());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
        tvFechaHora.setText(sdf.format(MainActivity.listaRecados.get(posicion).getFecha_hora()));
        tvHoraMaxima.setText(sdf.format(MainActivity.listaRecados.get(posicion).getFecha_hora_maxima()));


        bPendiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        bRealizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("RECADOS","Realizado en posición "+ Integer.toString(posicion));

                ArrayList<Recado> listaRecadosAux = new ArrayList<Recado>();

                for (int i=0; i< MainActivity.listaRecados.size();i++){

                    if(i != posicion){
                        listaRecadosAux.add(MainActivity.listaRecados.get(i));
                    }
                };

                MainActivity.listaRecados = listaRecadosAux;

                AdapterRecados  adapterRecados=new AdapterRecados(MainActivity.listaRecados);

                MainActivity.recyclerView.setAdapter(adapterRecados);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(new MainActivity(), LinearLayoutManager.VERTICAL, false);

                MainActivity.recyclerView.setLayoutManager(linearLayoutManager);

                finish();

            }
        });

    }
}
