# 🏫 Sistema de Gestión de Acceso de Visitantes

Este proyecto es una aplicación en Java diseñada para gestionar el acceso de **alumnos**, **visitantes** y **empleados** a un centro educativo.  
Permite registrar citas, controlar entradas y salidas, y mantener un registro organizado de los visitantes.

---

## 🚀 Funcionalidades principales

### 👨‍🎓 **Módulo Alumno**
- Solicitar cita con un empleado del centro.
- Cancelar una cita existente.
- Actualizar sus datos personales.
- Identificación mediante DNI.
- Creación automática del alumno si no existe en el sistema.

### 🧑‍💼 **Módulo Empleado**
- Consultar citas asignadas.
- Atender visitas.
- Registrar la atención realizada.

### 🛎️ **Módulo Recepción**
- Registrar entrada de visitantes.
- Registrar salida.
- Consultar visitantes dentro del centro.
- Ver citas del día.

---

## 🧱 Arquitectura del proyecto

El proyecto está organizado en clases que representan:

- **Visitante** → Clase base para cualquier persona que accede al centro.  
- **Alumno** → Hereda de Visitante, añade datos académicos.  
- **Empleado** → Personal del centro, con departamento asignado.  
- **Cita** → Representa una cita entre un alumno y un empleado.  
- **Gestores**  
  - `GestionVisitante`  
  - `GestionEmpleado`  
  - `GestionCita`  

Cada gestor se encarga de almacenar y manipular los datos correspondientes.

---

## 📂 Estructura del proyecto

