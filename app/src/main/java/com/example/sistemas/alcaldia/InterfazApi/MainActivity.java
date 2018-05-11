package com.example.sistemas.alcaldia.InterfazApi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.sistemas.alcaldia.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;

    private RecyclerView recyclerView;
    private ListaAdaptador listaAdapter;
    private boolean aptoParaCargar;
    public static final String TAG = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaAdapter = new ListaAdaptador(this);
        recyclerView.setAdapter(listaAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " Llegamos al final.");

                            aptoParaCargar = false;
                            obtenerDatos();
                        }
                    }
                }
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        aptoParaCargar = true;
        obtenerDatos();
    }


    private void obtenerDatos() {

        Interfaz service = retrofit.create(Interfaz.class);
        Call<ArrayList<Inventario>> RespuestaCall=service.obtenerListaInventario();

        RespuestaCall.enqueue(new Callback<ArrayList<Inventario>>() {
            public static final String TAG = "INVENTARIO";

            @Override
            public void onResponse(Call<ArrayList<Inventario>> call, Response<ArrayList<Inventario>> response) {
                aptoParaCargar = true;
                if(response.isSuccessful()) {

                    ArrayList<Inventario> lista = response.body();

                    listaAdapter.adicionarLista(lista);

                }
                else {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Inventario>> call, Throwable t) {

                Log.e(TAG," onFailure: "+t.getMessage() );
            }
        });
    }
}
