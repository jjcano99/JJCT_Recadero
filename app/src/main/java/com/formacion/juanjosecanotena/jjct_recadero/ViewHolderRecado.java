package com.formacion.juanjosecanotena.jjct_recadero;

import android.icu.text.SimpleDateFormat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by juanjosecanotena on 4/4/17.
 */

public class ViewHolderRecado extends RecyclerView.ViewHolder {

    private TextView tvHolderNumero;
    private TextView tvHolderCliente;
    private TextView tvHolderFechaHora;
    private TextView tvHolderDescripcion;

    public ViewHolderRecado(View itemView) {
        super(itemView);

        tvHolderNumero=(TextView) itemView.findViewById(R.id.tvFilaNumero);
        tvHolderCliente=(TextView) itemView.findViewById(R.id.tvFilaNombreCliente);
        tvHolderFechaHora=(TextView) itemView.findViewById(R.id.tvFilaFechaHora);
        tvHolderDescripcion=(TextView) itemView.findViewById(R.id.tvFilaDescripcion);

    }

    public void cargarRecadoEnHolder(Recado recado, int position) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
        String strFecha = sdf.format(recado.getFecha_hora());

        this.tvHolderFechaHora.setText(strFecha);
        this.tvHolderNumero.setText(Integer.toString(position + 1));
        this.tvHolderCliente.setText(recado.getNombre_cliente());
        this.tvHolderDescripcion.setText(recado.getDescripcion());
    }

}
