package com.formacion.juanjosecanotena.jjct_recadero;

import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by juanjosecanotena on 4/4/17.
 */

public class AsyncTaskRecados extends AsyncTask<String,Integer,ArrayList<Recado>>{

    private MainActivity mainActivity;
    private static final String URL_RECADOS="http://elrecadero-ebtm.rhcloud.com/ObtenerListaRecados";
    private AdapterRecados adapterRecados;

    public AsyncTaskRecados(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected ArrayList<Recado> doInBackground(String... strings) {

        ArrayList<Recado> recados =new ArrayList<Recado>();
        URL url = null;
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;

        try{
            url=new URL(URL_RECADOS+strings[0]);
            httpURLConnection = (HttpURLConnection)url.openConnection();

            if(httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_OK){

                Gson gson = new Gson();

                inputStream = httpURLConnection.getInputStream();

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                Log.d("RECADOS",inputStreamReader.getEncoding().toString());

                recados = gson.fromJson(inputStreamReader,new TypeToken<ArrayList<Recado>>(){}.getType());

                Collections.sort(recados, new ComparaFecha());
            }

        }catch (Throwable t){


        }finally {
            httpURLConnection.disconnect();
        }

        return recados;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(ArrayList<Recado> recados) {

        MainActivity.listaRecados = recados;

        adapterRecados=new AdapterRecados(recados);

        this.mainActivity.recyclerView.setAdapter(adapterRecados);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mainActivity, LinearLayoutManager.VERTICAL, false);

        this.mainActivity.recyclerView.setLayoutManager(linearLayoutManager);

    }
}
