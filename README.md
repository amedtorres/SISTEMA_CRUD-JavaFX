# 🚗 Sistema de Gestión de Reservas de Vehículos (JavaFX)

[![Java Badge](https://img.shields.io/badge/Language-Java_17+-blue.svg)](https://www.java.com/)
[![JavaFX Badge](https://img.shields.io/badge/Framework-JavaFX-green.svg)](https://openjfx.io/)
[![Design Badge](https://img.shields.io/badge/Style-Minimalist_CSS-red.svg)](https://developer.mozilla.org/es/docs/Web/CSS)

---

## 🌟 Resumen del Proyecto

Este proyecto es un **Simulador de Gestión de Reservas de Vehículos** desarrollado íntegramente con **JavaFX**. Su objetivo principal es demostrar la comprensión de la **Programación Orientada a Objetos (POO)**, el manejo de colecciones y la interacción entre la lógica del negocio (Java) y la interfaz de usuario (FXML).

La aplicación permite a un usuario **registrar** nuevas reservas, **calcular** automáticamente el costo, **visualizar** un listado de entradas activas y **eliminar** registros existentes de forma robusta.

---

## ✨ Características y Funcionalidades

El sistema implementa las funcionalidades básicas de gestión (CRUD parcial) con foco en la usabilidad y la robustez de la entrada de datos:

### 1. Registro y Cálculo
* **Modelo POO:** Utiliza la clase `Reserva` para modelar y almacenar los datos de cada entrada.
* **Validación de Datos:** Valida campos esenciales (Nombre, Vehículo, Fecha) antes del registro.
* **Cálculo Automático:** Determina el **Precio Total** de la reserva basándose en las horas de uso y el tipo de carga seleccionado (Lenta: 10.0€/h o Rápida: 15.0€/h).

### 2. Listado y Gestión
* **Ventana Modal:** Muestra todas las reservas activas en una ventana separada (`listadoVista.fxml`).
* **Eliminación Robusta:** Permite eliminar una reserva buscando por el nombre del cliente. La búsqueda utiliza `String.equalsIgnoreCase()` para ser tolerante a mayúsculas/minúsculas y `String.trim()` para ignorar espacios sobrantes.
* **Feedback al Usuario:** Implementa alertas informativas y de error (`Alerts`) para guiar la operación.

### 3. Diseño y Estilo
* **Diseño Minimalista:** La interfaz está estilizada con **CSS personalizado**, replicando un **diseño plano y limpio** con un fondo sutilmente cálido para mejorar la estética.
* **Tooltips:** Implementados en los botones principales para mejorar la guía del usuario (UX).

---

## 🛠️ Tecnologías y Estructura

* **Lenguaje:** Java 17+
* **Framework de UI:** JavaFX
* **Diseño de Layout:** FXML
* **Estilismo:** CSS (Estilo de la interfaz en `estilos.css`)

### Estructura de Clases

Clase | Función Principal |
| :--- | :--- |
| `ReservasApplication.java` | ***Punto de Entrada (main)***: Inicializa la aplicación JavaFX y carga la vista principal (vistaPrincipal.fxml). |
| `Reserva.java` | **Modelo POO:** Define la estructura de datos. |
| `ControladorPrincipal.java` | **Controlador:** Gestiona la creación de reservas, validaciones y cálculos de precio. |
| `ControladorLista.java` | **Controlador:** Gestiona la visualización, la búsqueda y la eliminación de reservas. |

---
## 🚀 Guía de Funcionamiento para el Usuario

Esta sección describe el uso básico de la interfaz de la aplicación:

### 1. Ventana Principal: Registro de Reservas

| Control | Función |
| :--- | :--- |
| **Ingreso de Datos** | Introduce el nombre del cliente, selecciona el vehículo, la fecha y el número de horas de uso. |
| **Tipo de Carga** | Define la tarifa por hora (Lenta o Rápida). |
| **REGISTRAR RESERVA** | Guarda la reserva en la lista del sistema, calcula el coste total y muestra un resumen en el panel lateral. |
| **VER RESERVAS** | Abre la ventana secundaria para consultar el listado y realizar eliminaciones. |

### 2. Ventana Secundaria: Listado de Reservas

| Botón/Área | Función |
| :--- | :--- |
| **Listado de Reservas** | Muestra todas las reservas activas en la memoria, separadas por líneas de guiones (`---`). |
| **ELIMINAR RESERVA** | Abre un diálogo para que el usuario escriba el **nombre exacto** del cliente a eliminar. Si lo encuentra, la reserva es borrada de la lista y el listado se actualiza. |
| **SALIR** | Cierra la ventana del listado y vuelve a la ventana de registro. |

*(Nota: La lista de reservas se mantiene en la memoria mientras la aplicación está abierta. Al cerrar la aplicación, la lista se reinicia.)*

---

## 🚀 Cómo Ejecutar el Proyecto

1.  **Clonar el Repositorio:** Abre tu terminal, navega a la carpeta donde deseas guardar el proyecto y usa el siguente comando.
    ```bash
    git clone https://github.com/amedtorres/GestionReservasVehiculos-JavaFX.git
    ```
3.  **Abrir en IDE:** Abre la carpeta del proyecto directamente con un IDE como **IntelliJ IDEA** o **Eclipse** que soporte Maven. El IDE detectará automáticamente el `pom.xml` y descargará las dependencias de JavaFX.
4.  **Ejecutar:** Ejecuta la clase principal (`Application`) que inicializa la aplicación.

---

## 🧑‍💻 Autor y Contexto

Desarrollado por **Amed Torres** como **proyecto estudiantil** para la asignatura **Desarrollo de Interfaces** en el ciclo de ***DAM***.
