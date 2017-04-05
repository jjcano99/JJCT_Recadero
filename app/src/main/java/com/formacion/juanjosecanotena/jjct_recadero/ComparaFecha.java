package com.formacion.juanjosecanotena.jjct_recadero;

import java.util.Comparator;

/**
 * Created by juanjosecanotena on 5/4/17.
 */

public class ComparaFecha implements Comparator<Recado> {

    @Override
    public int compare(Recado o1, Recado o2) {

        return (o1.getFecha_hora().after(o2.getFecha_hora()))? 1 : -1 ;

    }
}
