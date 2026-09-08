package src;

public class HashTableOpenAddressing<K, V>{
    private Tupla<K, V>[] table;
    private int cubetas;
    private final Tupla<K, V> DELETED = new Tupla<>(null, null); //etiqueta para cuando se elimine algo.

    public HashTableOpenAddressing(int cubetas){
        this.cubetas  = cubetas;
        this.table = (Tupla<K, V> [])new Tupla[cubetas];
    }

    private int hash(K key){
        return Math.abs(key.hashCode()) % this.cubetas;
    } 

    public void insertar(K key, V value){
        int i = 0;
        int hash = hash(key);
        int indice = hash;
        int primerEliminado = -1;

        while(table[indice] != null && i < cubetas){
            if(table[indice] == DELETED){
                if(primerEliminado == -1){
                    primerEliminado = indice;
                }
            }else if(table[indice].getKey().equals(key)){
                table[indice].setValue(value);
                return;
            }
            i++;
            indice = (hash + i) % this.cubetas;

        }    

        if(primerEliminado != -1){
            table[primerEliminado] = new Tupla<>(key, value);
        }else if(i < cubetas){
            table[indice] = new Tupla<>(key, value);
        }else{
            System.out.println("La tabla ya se llenó");
        }
    }

    public V buscar(K key){
        int indice = hash(key);
        int hash = hash(key);
        int i = 0;

         while(table[indice] != null && i < cubetas){
            if (table[indice] != DELETED && table[indice].getKey().equals(key)){
                return table[indice].getValue();
            }

            i++;
            indice = (hash + i) % table.length;
        }    
        return null;
    }

    public void eliminar(K key){
        int indice = hash(key);
        int hash = hash(key);
        int i = 0;

        while(table[indice] != null && i < cubetas){
            if(table[indice] != DELETED && table[indice].getKey().equals(key)){
                table[indice] = DELETED;
                return;
            }

            i++;
            indice = (hash + i) % this.cubetas;

        }
    }

    @Override 
    public String toString(){
        String cadena = "";

        for(int i = 0; i < table.length; i++){
            cadena += i + " -> ";

            if(table[i]== null){
                cadena += "null";
            } else if(table[i] == DELETED){
                cadena += "DELETED";
            }else{
                cadena += "[" + table[i].getKey() + ", " + table[i].getValue() + "]";
            } 
            
            cadena += " null\n";
        }
        return cadena;
    }
}   


