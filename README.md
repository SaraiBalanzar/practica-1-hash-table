                                    Universidad Nacional Autónoma de México
                                Facultad de Ciencias  Ciencias de la Computación
                                           Modelado y Programación
                                           Práctica 01. Hash Table
        Explicación de la solución:
        
        
        ¿Cómo ejecutar el programa?
        
        
        ¿Por qué tener una colisión no significa que la tabla hash esté implementada incorrectamente?
        
        
        1. Lenguaje utilizado: Java.
        
        2. Explicación de cómo ejecutar los casos de prueba:
        
        3. Explicación de la función hash:
                La función hash nos da la aignación de posición de las llaves, y cada llave tiene un hash, 
            y este se mantiene constante siempre, es decir, siempre tendrá el mismo resultado. Utilizamos 
            el módulo "x" (en este caso 7) para asegurar que la llave se mantendrá dentro del rango que 
            tenemos. Si el valor de la llave supera a el tamaño de la tabla, el módulo reinicia el conteo,
            y así podemos afirmar que siempre se mantendrá dentro de los límites.
            
        4. Explicación del manejo de colisiones:
                En nuestra implementacion usamos el encadenamiento, es decir, cada posicion de la tabla se 
            guarda una lista en vez de un solo elemento. Asi, si dos elementos con diferentes keys generan 
            el mismo valor hash, se agregan a la lista correspondiente. De esta manera los datos con el mismo 
            hash no se "tocan", permitiendonos tener diferentes eleemntos con el mismo valor hash sin que se 
            afecten entre si, haciendo que las colisiones no representen un problema para el programa.
            
        5. Explicación de qué ocurre cuando dos llaves producen el mismo hash:
        6. Explicación de qué ocurre cuando varias llaves caen en la misma cubeta:
        7. Factor de carga final obtenido durante sus pruebas:
