package com.example.sistemas.alcaldia.InterfazApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Inventario {



    @SerializedName("cantidad")
    @Expose
    private String cantidad;
    @SerializedName("nombre_y_especificaci_n_del_bien")
    @Expose
    private String nombreYEspecificaciNDelBien;
    @SerializedName("placa_inventario")
    @Expose
    private String placaInventario;
    @SerializedName("valor_unitario")
    @Expose
    private String valorUnitario;
    @SerializedName("observaciones")
    @Expose
    private String observaciones;

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreYEspecificaciNDelBien() {
        return nombreYEspecificaciNDelBien;
    }

    public void setNombreYEspecificaciNDelBien(String nombreYEspecificaciNDelBien) {
        this.nombreYEspecificaciNDelBien = nombreYEspecificaciNDelBien;
    }

    public String getPlacaInventario() {
        return placaInventario;
    }

    public void setPlacaInventario(String placaInventario) {
        this.placaInventario = placaInventario;
    }

    public String getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
