package org.example.gestiondevehiculos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControladorLista implements Initializable {

    @FXML
    private TextArea txtListaReservas;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnSalir;

    private List<Reserva> reservas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    // metodo para recibir la lista de reservas desde la ventana principal
    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
        mostrarReservas();
    }

    // Mostrar todas las reservas en el textArea
    private void mostrarReservas() {
        if (reservas.isEmpty()) {
            txtListaReservas.setText("No hay reservas registradas.");
            return;
        }

        String resultLista = " LISTADO DE TODAS LAS RESERVAS REGISTRADAS \n";

        // BUCLE FOR-EACH para iterar sobre cada objeto Reserva en la lista.
        for (Reserva r : reservas) {
            resultLista = resultLista + r.toString() + "\n" // Contenido de la reserva
                    + "------------------------------------\n\n";
        }
        // Establecemos todo el texto final en el TextArea
        txtListaReservas.setText(resultLista);
    }


    //ELIMINAR RESERVA
    @FXML
    private void eliminarReserva(ActionEvent event){
        //comprobar si hay algo para elominar
        if (reservas.isEmpty()) {
            error("no hay reservas para eliminar");
            return;
        }

        // mostrar el este mensaje en la opcion de eliminar para q se introduzca algo
        TextInputDialog txtInput= new TextInputDialog();
        txtInput.setTitle("Eliminar Reserva");
        txtInput.setHeaderText("Eliminar reserva por nombre de cliente");
        txtInput.setContentText("Introduce el nombre del cliente:");

        // mostrar el diálogo y esperar a q
        Optional <String> resultado = txtInput.showAndWait();

        // si el usuario ingresa algo y acepta entra en este if
        if (resultado.isPresent()){
            String nombreBuscado = resultado.get().trim();

            if (nombreBuscado.isEmpty()){
                error("Tienes que introducir un nombre para buscar");
                return;
            }
            // Buscar la reserva con el nombre ingresado
            Reserva reservaEncontrada = null;
            for (Reserva reserva : reservas) {
                if (reserva.getNombreCliente().equalsIgnoreCase(nombreBuscado)) {
                    reservaEncontrada = reserva;
                    break;
                }
            }

            // Si se encontro eliminarla
            if (reservaEncontrada != null) {
                reservas.remove(reservaEncontrada);
                mostrarReservas(); // muestra con la lista actualiada
                info("Reserva de " + nombreBuscado + " eliminada correctamente");
            } else {
                error("No se encontró ninguna reserva con el nombre: " + nombreBuscado);
            }
        }
    }


    // metodo para salir con el boton salir
    @FXML
    private void salir (ActionEvent event) {
        // cerramos ventana
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
    }


    // metodo para lanzar error
    public void error(String mensaje){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // metodo para lanzar error
    public void info(String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFORMACION");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
