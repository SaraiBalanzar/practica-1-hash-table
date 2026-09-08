                                    Universidad Nacional Autónoma de México
                                Facultad de Ciencias  Ciencias de la Computación
                                           Modelado y Programación
                                           Práctica 01. Hash Table
        
## Explicación de la implementación
La implementación que realizamos está basada en Java como único lenguaje.


Las clases principales dentro de la carpeta src son:
### HashTable
Esta clase es la principal y la que realiza toda la lógica  de la tabla de dispersión.
#### **Métodos de la clase**
Dentro de esta clase podemos encontrar los siguientes métodos:
1. **hash(K key).** Este método se encarga de calcular el índice que le corresponde a la llave. Se pidió que la función de dispersión se realizara con el módulo -> f(key) = key % cubetas.
2. **insertar(K key, V value).** Inserta un elemento (k,v) en la tabla de dispersión.
3. **buscar(K key).** Este método busca un elemento a partir de su llave asociada y devuelve el valor guardado.
4. **eliminar(K key).** Elimina un elemento a partir de la llave asociada.


### Tupla
Esta clase se creo para poder modelar los pares (key, value). Envolvemos los datos en objeto de tipo tupla para guardarlos en la tabla.


### Pruebas
Dentro de la carpeta tests encontramos el método main que ejecutará paso por paso las validaciones para la tabla de dispersión y verificar que todo funcione correctamente.


### PUNTO EXTRA: HashTableOpenAdrressing
Implementación del punto extra. Tabla de dispersión que maneja colisiones con direccionamiento abierto.


**Estructuras de apoyo utilizadas**
Para implementar la tabla hash y resolver las colisiones a través de encadenamiento, utilizamos la clase LinkedList de java que es una implementación de una lista doblemente ligada. Elegimos una lista puesto que es la forma más clásica de representar el encadenamiento.
También implementamos una tupla que envuelve los valores (key, value).

        


## Ejecución y Compilación del programa
1. clone el repositorio desde la terminal: git clone https://github.com/SaraiBalanzar/practica-1-hash-table.git
2. Ubicarse en la carpeta principal: cd practica-1-hash-table
3. Compile los archivos principales: javac src/*.java
4. Compile el archivo principal de pruebas: javac tests/Pruebas.java
5. Ejecute el archivo con el método principal: java tests.Pruebas




## Preguntas teóricas acerca de la tabla de dispersión    


#### 1. ¿Por qué tener una colisión no significa que la tabla hash esté implementada incorrectamente?       
Una colisión ocurre cuando dos llaves distintas k1 y k2 terminan en la misma cubeta, es decir, bajo la función de dispersión h se tiene que h(k1)=h(k2), y esto es algo esperado, no un error. 


Para el caso de las pruebas que se realizaron, nuestra tabla solo tiene 7 cubetas (m = 7), pero el espacio de posibles llaves es mucho más grande (cualquier entero puede ser una llave). Como hay más llaves posibles que cubetas disponibles, tarde o temprano dos llaves diferentes van a mapear al mismo índice sin importar qué tan bien esté hecha la función hash.


Por eso se resolvieron las colisiones con encadenamiento: cada cubeta de la tabla no guarda un solo elemento, sino una lista donde pueden coexistir varios pares (key, value) que comparten índice. Al insertar buscar o eliminar, primero calculamos la cubeta con hash(key) y después recorremos solo esa lista comparando la llave exacta con getKey().equals(key), para actuar siempre sobre el elemento correcto y no sobre cualquier otro que haya caído ahí.


Lo que si sería un error de implementación es que, al insertar un nuevo elemento en una cubeta que ya tení algo, se sobreescribiera o se perdiera el elemento anterior. Nuestra tabla evita esto porque siempre agrega a la lista de la cubeta en vez de reemplazar su contenido, y al eliminar solo quita el nodo cuya llave coincide, dejando los demás intactos. 


#### 2. Explicación de la función hash
La _función hash_ nos da la asignación de posición de las llaves. Cada llave tiene un hash y este se mantiene constante siempre, es decir, siempre tendrá el mismo resultado. Utilizamos el módulo "x" (en este caso 7) para asegurar que la llave se mantendrá dentro del rango que tenemos. Si el valor de la llave supera a el tamaño de la tabla, el módulo reinicia el conteo, y así podemos afirmar que siempre se mantendrá dentro de los límites.


#### 3. Explicación del manejo de colisiones
En nuestra implementacion usamos el encadenamiento, es decir, en cada posicion de la tabla se guarda una lista en lugar de solo un elemento. De este modo, si dos elementos con diferentes keys generan el mismo valor bajo la funciṕn hash, se agregan a la lista correspondiente. De esta manera los datos con el mismo hash no se "tocan", permitiendonos guardar diferentes elementos con el mismo valor hash asociado sin que se afecten entre si, haciendo que las colisiones no representen un problema para el programa.
            

#### 4. Explicación de qué ocurre cuando dos llaves producen el mismo hash
Ocurre una colisión. Una situación esperada debido a que el número de posibles llaves es mucho mayor que el número de casillas disponibles en la tabla.


#### 5. Explicación de qué ocurre cuando varias llaves caen en la misma cubeta
En encadenamiento cada tabla se crea con un número fijo de cubetas y cada cubeta contiene una lista ligada. Cuando más de una llave cae en la misma cubeta, ese dato se guarda dentro de la lista, manejando las colisiones por encadenamiento. Al insertar, se recorre la lista y, en caso de que la llave sea nueva, se agrega una nueva Tupla en la lista correspondiente; si ya existe, se actualiza su valor. Al buscar, se recorre igualmente la lista comparando llaves. Al eliminar, se recorre la lista para encontrar la Tupla correspondiente y se remueve únicamente esa, dejando el resto de la lista intacta. En direccionamiento abierto (HashTableOpenAddressing) En este caso no se usan listas, cada cubeta usa una Tupla o ninguna, en caso de una colisión se busca la siguiente cubeta disponible aumentando 1 a un contador y calculando el hash y el modulo de esa nueva cubeta, en este caso se agrega la etiqueta DELETED cuando se elimina y queda vacía para no interrumpir la búsqueda. 


#### 6. Factor de carga final obtenido durante sus pruebas
La tabla final de nuestras pruebas tiene un tamaño de 7 y guarda unicamente 4 elementos, así el factor de carga que se define como **(numero de elementos guardados) / (numero de cubetas)** corresponde un valor aproximado de 0.57




## Integrantes del equipo
- **Ruth Sarai Guadalupe Balanzar**
- **Alondra Campos Mendoza**
- **Edith Alejandra Mendoza Aragón**
- **Evelyn Vianey Mondragón Ceballos**
- **Oscar Adolfo Jaimez Martinez**
- **Jorge Guadalupe Mancilla Lagunacd doc**