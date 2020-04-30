# Proyecto Final PCyP central telefónica

## Objetivo.
Escribir un programa concurrente en lenguaje JAVA que simule el funcionamiento de una central telefónica con
10 teléfonos conectados a ella. Los teléfonos tendrán una interfaz de comunicación entre los usuarios y la central telefónica.

## Requisitos.
1. El usuario puede realizar las siguientes acciones sobre el teléfono:
    - Descolgar.  
    - Marcar un número telefónico (cada uno de los 10 teléfonos tiene asignado un número telefónico de un solo dígito que va del 0 al 9).
    - Colgar.
2. El teléfono comunicará al usuario (a manera de simulación) la situación en la que se encuentra:  
    - Colgado y en espera.  
    - Colgado y recibiendo llamada: Ring-Ring.  
    - Descolgado y dando señal: Piiiii...  
    - Descolgado y marcando: Marcando x con 0<=x<=9.
    - Descolgado y llamando: Piii-Piii-Piii...
    - Descolgadoyocupado: Tuuu-Tuuu-Tuuu...
    - Descolgado y estableciendo comunicación: Hablando con x.  
3. El teléfono debe comunicar a la central telefónica que el usuario:
    - Ha descolgado.
    - Ha marcado un número.
    - Ha colgado.
4. La central telefónica debe comunicar al teléfono lo que posteriormente “muestra” al usuario:
    - Hay una llamada entrante (Ring-Ring).
    - Hay tono (Piii...).
    - Está llamando (Piii-Piii).
    - Está ocupado (Tuu-Tuu-Tuu).
    - Estableciendo comunicación (Hablando con x).   
    
Esta  simulación  debe  estar  lo más  apegada  posible  al  funcionamiento  real  de un teléfono. 
Lo que no es necesario simular es el intercambio de información entre los usuarios (es decir, lo que hablan los usuarios). 
Algunas reglas a respetar son:
- Cuando un usuario descuelga el teléfono, éste lo tiene que comunicar a la central de teléfonos quien a suvez deberá 
comunicar al teléfono que hay línea.
- Cuando un usuario marca después de descolgar, el teléfono debe comunicar a la central telefónica el número marcado 
a la vez que se lo muestra al usuario (Marcando x); cuando la central contacte con el otro teléfono deberá hacerlo sonar 
(Ring-Ring) si está colgado y comunicar al teléfono origen que se está llamando al otro lado (Piii-Piii). Si el otro 
teléfono está descolgado (porque la persona que está en ese teléfono está hablando o bien va a hacerlo) deberá comunicar al 
teléfono que origina la llamada que está ocupado (tuuu-tuuu).
- Cuando se está llamando a un teléfono (Ring-Ring) y se descuelga; en ambos lados (el que llama y el llamado) la central 
telefónica deberá advertir que están conectados (Hablando con x)
- En general cuando la central telefónica comunica a un teléfono un mensaje, este deberá comunicar al usuario la situación 
(bastará con visualizar el Ring-Ring, Piii, Piii-Piii, tuuu-tuuu, Hablando con x respectivo).
-Cuando un usuario cuelga después de haberse establecido el contacto con otro teléfono, éste último debe dar señal de ocupado 
(tuu-tuu-tuu) y el primero mostrará su situación de (Colgado).

Pueden  realizar  la  ejecución  en  consola  (modo  texto)  o  bien  mediante  una  interfaz  de usuario gráfica a través 
de Frames utilizando memoria compartida o paso de mensajes.

## Requisitos de entrega.

### FECHA DE ENTREGA: 12 de mayo de 2020 
### FORMA DE ENTREGA:  
Podrán formar equipos de 5 personas como máximo. Cada equipo entregará en la fecha indicada el código fuente y compilado 
libre de errores sintácticos, es decir, archivos .java y .class, en un CD etiquetado o rotulado con los nombres y matrículas 
de los integrantes del equipo

## Analisis del sistema.  
el sistema estára formado con dos clases principales: 
- CentralTelefonica, su tarea será administrar los telefonos y las llamadas a estos.
- Telefono, durante la ejecucion del programa, se crearan diez instancias de dicha clase, y seran estás las que intertactuen 
con el usuario.
