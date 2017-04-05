package com.formacion.juanjosecanotena.jjct_recadero;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;


/**
 * Created by juanjosecanotena on 4/4/17.
 */

public class AdapterRecados extends RecyclerView.Adapter<ViewHolderRecado>{

    private ArrayList<Recado> datos;

    public AdapterRecados(ArrayList<Recado> recados){
        this.datos=recados;
    }

    @Override
    public ViewHolderRecado onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewHolderRecado viewHolderRecado=null;

        LayoutInflater inflater= LayoutInflater.from(parent.getContext());

        View viewItem =inflater.inflate(R.layout.fila_recado,parent,false);

        viewHolderRecado = new ViewHolderRecado(viewItem);

        return viewHolderRecado;

    }

    @Override
    public void onBindViewHolder(final ViewHolderRecado holder, final int position) {

        Recado  recado = datos.get(position);
        holder.cargarRecadoEnHolder(recado, position);

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("RECADOS","Click en posición "+ Integer.toString(position));

                Intent intent = new Intent(v.getContext() , RecadoActivity.class);
                intent.putExtra("POSICION", position);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }


}
