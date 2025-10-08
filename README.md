# Act7_Multihilos
    Programación paralela y concurrente en Java. Actividad de clase de PPC2025B (Programación paralela y concurrente).

## Ej 1 (Concurrencia y Sincronización)
    Calcula el factorial de un número muy grande (N!) o, de forma más práctica, calcula la suma de los factoriales de un rango de números (por ejemplo, 1!+2!+⋯+1000!).
    * Divide el rango total de números en subrangos iguales.
    * Asigna cada subrango a un Hilo de Trabajo diferente.
    * Cada hilo calcula el factorial de los números en su subrango y mantiene una suma parcial.
    * El Hilo Principal espera a que todos los hilos terminen.
    * Suma los resultados parciales de todos los hilos para obtener el resultado final.

