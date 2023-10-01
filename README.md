# Smart Home Control System

Este proyecto implementa un sistema de control para una Smart Home, que permite gestionar varios dispositivos y realizar acciones en diferentes habitaciones de una casa inteligente. El sistema se basa en patrones de diseño como Comando y Observador para proporcionar funcionalidades de control y notificación.

## Funcionalidades Destacadas

- Encender y apagar luces en diferentes habitaciones.
- Abrir y cerrar la puerta del garaje.
- Encender y apagar la televisión.
- Controlar la velocidad de un ventilador de techo.
- Encender y apagar una bañera de hidromasaje.
- Controlar una radio estéreo en la sala de estar y en el dormitorio.

## Patrones de Diseño Utilizados

- **Patrón Comando**: Los comandos específicos para cada dispositivo encapsulan las solicitudes y permiten su ejecución en momentos diferentes.

- **Patrón Observador**: Los dispositivos notifican a los observadores cuando cambian de estado, y los observadores (como la clase `SmartHome`) reaccionan en consecuencia.

- **Patrón Singleton**: Se utiliza para garantizar una única instancia de la central del sistema (`SmartHomeCentral`).

## Requisitos del Proyecto

Este proyecto está desarrollado en Java y utiliza la biblioteca Swing para crear una interfaz gráfica de usuario (GUI). Asegúrate de tener Java instalado en tu entorno de desarrollo.

## Uso del Proyecto

1. Clona este repositorio en tu máquina local.
2. Abre el proyecto en tu entorno de desarrollo Java preferido.
3. Ejecuta la clase `Main.java` para iniciar la aplicación.

## Interfaz de Usuario

La interfaz de usuario proporciona un control fácil de usar para administrar los dispositivos de la Smart Home. Puedes realizar acciones como encender y apagar luces, abrir la puerta del garaje, ajustar la velocidad del ventilador y más.

## Interfaz gráfica: 
<img width="1440" alt="Captura de pantalla 2023-09-25 a la(s) 11 16 50" src="https://github.com/annlima/ProyectoEstructuras/assets/89811870/5a2cd5f8-093e-4034-b4ca-9764a0d91bdd">


Imagen de la casa obtenida de: https://www.youtube.com/watch?app=desktop&v=M4MxA0REDAU 

## Contribuciones

Las contribuciones son bienvenidas. Si deseas mejorar este proyecto, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una rama para tu mejora (`git checkout -b feature/mejora`).
3. Realiza tus cambios y realiza confirmaciones significativas.
4. Envía tus cambios (`git push origin feature/mejora`).
5. Abre una solicitud de extracción y describe tus cambios.

## Autor

- Andrea Lima Blanca
- Contacto: andrealimablanca@outlook.com
