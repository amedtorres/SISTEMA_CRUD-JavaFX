package org.example.gestiondevehiculos;

import java.time.LocalDate;

public class Reserva {
    private String nombreCliente;
    private String vehiculo;
    private LocalDate fechaReserva;
    private int horasUso;
    private String tipoCarga;
    private double precioTotal;

    public Reserva(String nombreCliente, String vehiculo, LocalDate fechaReserva, int horasUso, String tipoCarga, double precioTotal) {
        this.nombreCliente = nombreCliente;
        this.vehiculo = vehiculo;
        this.fechaReserva = fechaReserva;
        this.horasUso = horasUso;
        this.tipoCarga = tipoCarga;
        this.precioTotal = precioTotal;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public int getHorasUso() {
        return horasUso;
    }

    public String getTipoCarga() {
        return tipoCarga;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    @Override
    public String toString() {
        return "\n" +
                "Nombre del Cliente: " + nombreCliente + "\n "+ "Vehiculo: " + vehiculo + "\n" + "Fecha de Reserva: " + fechaReserva + "\n"
                + "Horas de Uso: " + horasUso + "\n" + "Tipo de Carga: " + tipoCarga + "\n" + "Precio Total: " + precioTotal + "\n";
    }
}
