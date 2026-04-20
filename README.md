# Tarea 2 - Plataforma de Localización de Mascotas
**Curso:** Programación Orientada a Objetos (SOFT-04 / BISOFT-07)  
**Universidad:** CENFOTEC  
**Periodo:** C1-2026

---

## Descripción

Aplicación de consola en Java que permite registrar mascotas y administrar su localización mediante dispositivos inteligentes simulados. Los dispositivos generan ubicaciones de forma automática y concurrente usando hilos.

---

## Clases del proyecto

| Clase | Descripción |
|-------|-------------|
| `Principal` | Menú principal y punto de entrada |
| `Mascota` | Representa una mascota registrada |
| `DispositivoLocalizacion` | Dispositivo GPS asociado a una mascota |
| `RegistroUbicacion` | Ubicación registrada en un momento dado |
| `EventoDispositivo` | Evento generado por un dispositivo |
| `Alerta` | Alerta generada a partir de la información del dispositivo |
| `SimuladorDispositivo` | Hilo que simula el comportamiento automático del dispositivo |
| `TipoEvento` | Enumerado con los tipos de evento posibles |
| `TipoAlerta` | Enumerado con los tipos de alerta posibles |

---

## Funcionalidades

1. Registrar mascotas
2. Registrar dispositivos de localización
3. Asociar un dispositivo a una mascota
4. Añadir ubicación manualmente
5. Ver toda la información almacenada
6. Iniciar simulación automática de dispositivos
7. Ver eventos registrados durante la simulación
8. Ver alertas generadas

---

## Requisitos técnicos aplicados

- Encapsulamiento (getters y setters)
- Sobrecarga de métodos (`agregarUbicacion`)
- Sobrescritura de métodos (`run()`, `toString()`)
- Uso de enumerados (`TipoEvento`, `TipoAlerta`)
- Variables de clase estáticas (`contadorEventos`, `contadorAlertas`)
- Hilos concurrentes (`SimuladorDispositivo extends Thread`)
- Manejo de excepciones (`try/catch`)
- Almacenamiento exclusivamente en memoria (`ArrayList`)

---

## Cómo ejecutar

1. Clonar el repositorio
```bash
git clone https://github.com/tu-usuario/tu-repositorio.git
```

2. Compilar todos los archivos
```bash
javac *.java
```

3. Ejecutar la aplicación
```bash
java Principal
```

---

## Ejemplo de uso

```
========== MENÚ PRINCIPAL ==========
1. Registrar mascota
2. Registrar dispositivo
3. Asociar dispositivo a mascota
4. Añadir ubicación manual
5. Ver toda la información
6. Iniciar simulación automática
7. Ver eventos registrados
8. Ver alertas registradas
9. Salir
```
