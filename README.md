# SmartHome
Representa una simulación visual de una casa inteligente. A medida que los dispositivos de la casa, como luces o puertas del garaje, son controlados a través de una interfaz de usuario, SmartHome actualiza su representación gráfica mostrando puntos de colores en las ubicaciones de los dispositivos activados.


 **•	Clase GarageDoor: Representa la puerta de una cochera y contiene métodos que definen sus funcionalidades clave. Sus métodos incluyen:**
 
  o	Up(): Abre la cochera.
  
  o	Down(): Cierra la cochera.
  
  o	LightOn(): Prende la luz de la cochera.
  
  o	LightOff(): Apaga la luz de la cochera.
  
  o	IsDoorOpen(): Revisar si esta abierta la cochera. Regresa un booleano.
  
  o	isLightOn(): Revisa si esta prendida la luz de la cochera. Regresa un boleano. 
  
   Su constructor pide un String de localización para inicializarse.

 **• Clase Light: Representa a todas las luces de la casa. Contiene métodos que definen las funciones de prender y apagar:**
 
  o	On(): Prende las luces.
  
  o	Off(): Apagar las luces.
  
   Su constructor pide un String de localización.  
   
 **•	Clase TV: Contiene métodos que definen funciones de prender y apagar el televisor:**
 
  o	On(): Encender la television.
  
  o	Off(): Apagar la television.
  
  o	isOn(): Revisa si el televisor esta encendido, regresa un booleano.
  
   Además, contiene un método para ingresar el canal al que se quiere cambiar. 
   
 **•	Clase CeilingFan: Contiene métodos que definen el nivel del ventilador:**
 
  o	High(): Modifica la velocidad del ventilador a la contante final HIGH.
  
  o	Medium(): Modifica la velocidad del ventilador a la contante final MEDIUM.
  
  o	Low(): Modifica la velocidad del ventilador a la contante final LOW.
  
  o	On(): Enciende el ventilador automáticamente al nivel bajo.
  
  o	Off(): Apaga el ventilador.
  
  o	getSpeed(): Regresa el nivel que tiene el ventilador.
  
  Su constructor se inicializa con un String de la localización e inicializa el nivel del ventilador a cero.
  
 **•	Clase Stereo: Representa un stereo y esta compuesta por métodos que definen funciones del mismo:**
 
  o	On(): Enciende el stereo.
  
  o	Off(): Apaga el stereo.
  
  o	setCD(): Se inserta un CD al stereo.
  
  o	setDVD(): Se inserta un DVD al stereo.
  
  o	setRadio(): Se enciende el radio y se asigna a una estación determinada por un valor float (el usuario puede asignar la estación).
  
  o	setVolume(): Asigna el valor del nuevo volumen para el stereo por un valor entero ingresado (el usuario puede cambiar el volumen).
  
  o	getVolume(): Regresa un entero del volumen actual.
  
  o	getMode(): Regresa un String de el modo en el que esta el stereo.
  
   Su constructor se inicializa con un String de la localización.
    
 **•	Clase Hottub: Representa una bañera de hidromasaje. Esta compuesta de métodos que definen funciones de este aparato:**
 
  o	On(): Enciende el aparato.
  
  o	Off(): Apaga el aparato.
  
  o	bubblesOn(): Empieza a burbujear el agua (se activa al prender el Jacuzzi).
  
  o	setTemperature(): Cambia la temperatura del agua (el usuario puede ingresar la temperatura).
  
  o	heat(): Calienta el agua cambiando la temperatura del agua a 105 grados F.
  
  o	cool(): Enfría el agua cambiando la temperatura del agua a 15 grados F.     
  
   Su constructor se inicializa con un String de la localización.

Se usaron varios patrones de diseño:

**Patrón Comando**:

   - **Propósito**: Encapsula una solicitud como un objeto, permitiendo parametrizar objetos con diferentes solicitudes, encolar solicitudes y realizar operaciones que dependen de la solicitud.

**Patrón Observador**:

   - **Propósito**: Define una dependencia uno-a-muchos entre objetos, de manera que cuando un objeto cambia de estado, todos sus dependientes son notificados y actualizados automáticamente.

**Patrón Singleton** (mencionado pero no implementado explícitamente en el código proporcionado):
   - **Propósito**: Garantizar que una clase tenga solo una instancia y proporcionar un punto de acceso global a esta instancia.

## Interfaz gráfica: 
<img width="1440" alt="Captura de pantalla 2023-09-25 a la(s) 11 16 50" src="https://github.com/annlima/ProyectoEstructuras/assets/89811870/5a2cd5f8-093e-4034-b4ca-9764a0d91bdd">


Imagen de la casa obtenida de: https://www.youtube.com/watch?app=desktop&v=M4MxA0REDAU 

