# SISTEMA CRUD (JavaFX)

[![Java Badge](https://img.shields.io/badge/Language-Java_17+-blue.svg)](https://www.java.com/)
[![JavaFX Badge](https://img.shields.io/badge/Framework-JavaFX-green.svg)](https://openjfx.io/)
[![Design Badge](https://img.shields.io/badge/Style-Minimalist_CSS-red.svg)](https://developer.mozilla.org/es/docs/Web/CSS)

---

## Resumen del Proyecto

Este es un Simulador de Gestión de Reservas de Vehículos creado con JavaFX y Java 17+ como proyecto estudiantil. El objetivo principal es demostrar la aplicación de la Programación Orientada a Objetos (POO) y la implementación de una interfaz de usuario limpia y funcional.

---

## Características y Funcionalidades

El sistema implementa las funcionalidades básicas de gestión de CRUD parcial con foco en la usabilidad y la robustez de la entrada de datos:

* **Registro (Create):** Permite ingresar datos de la reserva (Nombre, Vehículo, Fecha y Horas).

* **Cálculo Automático:** Determina el Precio Total según las horas y el tipo de carga seleccionado.

* **Listado (Read):** Muestra todas las reservas activas en una ventana modal separada.

* **Eliminación (Delete):** Permite borrar reservas buscando por el nombre del cliente. La búsqueda es robusta ignora mayúsculas/minúsculas y espacios.

### Diseño y Estilo
* **Diseño Minimalista:** La interfaz está estilizada con **CSS personalizado**, replicando un **diseño plano y limpio** con un fondo sutilmente cálido para mejorar la estética.
* **Tooltips:** Implementados en los botones principales para mejorar la guía del usuario (UX).

---

## Tecnologías y Estructura

* **Lenguaje:** Java 17+
* **Framework de UI:** JavaFX
* **Diseño de Layout:** FXML
* **Estilo de la interfaz:** CSS

---
## Guía de Funcionamiento para el Usuario

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

---

## Cómo Ejecutar el Proyecto

1.  **Clonar el Repositorio:** Abre tu terminal, navega a la carpeta donde deseas guardar el proyecto y usa el siguente comando.
    ```bash
    git clone https://github.com/amedtorres/GestionReservasVehiculos-JavaFX.git
    ```
3.  **Abrir en IDE:** Abre la carpeta del proyecto directamente con un IDE como **IntelliJ IDEA** o **Eclipse** que soporte Maven. El IDE detectará automáticamente el `pom.xml` y descargará las dependencias de JavaFX.
4.  **Ejecutar:** Ejecuta la clase principal (`Application`) que inicializa la aplicación.

---

## Autor y Contexto

Desarrollado por **Amed Torres** como **proyecto estudiantil** para la asignatura **Desarrollo de Interfaces** en el ciclo de ***DAM***.
