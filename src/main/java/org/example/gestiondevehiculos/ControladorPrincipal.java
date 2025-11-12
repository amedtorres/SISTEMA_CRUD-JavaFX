package org.example.gestiondevehiculos;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControladorPrincipal implements Initializable {

    @FXML
    private TextField tfNombre;

    @FXML
    private ComboBox<String> comboVehiculo;

    @FXML
    private DatePicker dpFecha;

    @FXML
    private Spinner<Integer> spnHorasUso;

    @FXML
    private RadioButton rbCargaLenta;

    @FXML
    private RadioButton rbCargaRapida;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnRgistrar;

    @FXML
    private Button btnVer;

    private ToggleGroup cargaGroup;
    private final List<Reserva> reservas = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Tooltip tooltipRegistro = new Tooltip("Registra y calcula el valor total de la reserva de vehículos.");
        btnRgistrar.setTooltip(tooltipRegistro);

        comboVehiculo.setItems(FXCollections.observableArrayList("Tesla Model 3", "Nissan", "BMW"));

        // Configurar Spinner de 1 a 24 horas
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 24, 1);
        spnHorasUso.setValueFactory(valueFactory);

        // Configurar ToggleGroup para RadioButtons
        cargaGroup = new ToggleGroup();
        rbCargaLenta.setToggleGroup(cargaGroup);
        rbCargaRapida.setToggleGroup(cargaGroup);

        // Seleccionar carga lenta por defecto
        rbCargaLenta.setSelected(true);

    }

    @FXML
    public void registrarReserva(ActionEvent event){
        try {
            // obtenemos datos
            String nombre = tfNombre.getText().trim();
            String vehiculo = comboVehiculo.getValue();
            LocalDate fecha = dpFecha.getValue();
            int horas = spnHorasUso.getValue();

            // validar
            if (nombre.isEmpty() || !nombre.matches("[a-zA-Z]*")) {
                error("El campo nombre no puede estar vacio ni con caracteres invalidos");
                return;
            }
            if (vehiculo == null){
                error("Debe seleccionar una opción un vehiclo");
                return;
            }
            if (fecha == null){
                error("seleccione una fecha");
                return;
            }

            if (!rbCargaRapida.isSelected() && !rbCargaLenta.isSelected()){
                error("debe seleccionar un tipo de carga");
                return;
            }

            // obtenemos el tipo de carga seleecionado y añadmos el precio por hora
            String tipoCarga;
            double precioHora;

            if (rbCargaRapida.isSelected()){
                tipoCarga = "Carga Rapida";
                precioHora = 15.0;
            }
            else {
                tipoCarga= "Carga Lenta";
                precioHora = 10.0;
            }

            //calcular precio total de la reserva
            double precioTotal = precioHora * horas;

            // crear nuevo objeto
            Reserva reserva = new Reserva(nombre, vehiculo, fecha, horas, tipoCarga, precioTotal);

            //añadimos reserva
            reservas.add(reserva);


            // resumen q saldra en el texArea
            String resumen = "RESUMEN DE LA RESERVA\n" +
                    "Cliente: " + nombre + "\n" +
                    "Vehículo: " + vehiculo + "\n" +
                    "Fecha: " + fecha + "\n" +
                    "Horas de uso: " + horas + " h\n" +
                    "Tipo de carga: " + tipoCarga + "\n" +
                    "Precio por hora: " + String.format("%.2f", precioHora) + " €\n" +
                    "PRECIO TOTAL: " + String.format("%.2f", precioTotal) + " €\n";
            txtResult.setText(resumen);

            info("Reserva registrada correctamente :) ");


        }catch (Exception e){
            error("ERROR Al REGISTRAR" + e.getMessage());
        }
    }

    @FXML
    private void verListado(ActionEvent event){
        try {

            // cargo el FXML del dialogo de modificacion
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vistaLista.fxml"));

            // cargo ventana
            Parent root = loader.load();

            // selecciono y cargo el controlador
            ControladorLista controlador = loader.getController();

            //paso la lista al controlador listado
            controlador.setReservas(reservas);

            // creo ventana modal
            Stage stage = new Stage();
            stage.setTitle("Listado de Reservas");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

        }catch (IOException e){
        error("ERROR AL ABRIR VENTANA DE LISTADO " + e.getMessage());
        }
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