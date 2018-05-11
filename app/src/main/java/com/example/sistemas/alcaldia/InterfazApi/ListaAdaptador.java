package com.example.sistemas.alcaldia.InterfazApi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sistemas.alcaldia.R;

import java.util.ArrayList;


public class ListaAdaptador extends RecyclerView.Adapter<ListaAdaptador.ViewHolder>
{
    private ArrayList<Inventario> dataset;
    private Context context;

    public ListaAdaptador(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inventario, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Inventario p = dataset.get(position);

        holder.cantidad.setText(p.getCantidad());
        holder.bien.setText(p.getNombreYEspecificaciNDelBien());
        holder.placa.setText(p.getPlacaInventario());
        holder.valor.setText(p.getValorUnitario());

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarLista(ArrayList<Inventario> listaInventario) {
        dataset.addAll(listaInventario);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        private TextView cantidad;
        private TextView bien;
        private TextView placa;
        private TextView valor;


        public ViewHolder(View itemView)
        {
            super(itemView);
            cantidad = (TextView) itemView.findViewById(R.id.cantidad);
            bien = (TextView) itemView.findViewById(R.id.bien);
            placa = (TextView) itemView.findViewById(R.id.placa);
            valor = (TextView) itemView.findViewById(R.id.valor);
        }
    }

}
