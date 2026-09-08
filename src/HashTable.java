package src;
import java.util.LinkedList;

public class HashTable<K,V>{

    private LinkedList<Tupla<K,V>>[] table;
    private int cubetas;
    private int numElementos;

    @SuppressWarnings("unchecked")
    public HashTable(int cubetas){
        this.cubetas  = cubetas;
        table = new LinkedList[cubetas];

        for(int i = 0; i < cubetas; i++){
            this.table[i] = new LinkedList<>();
        }
    }

    private int hash(K key){
        return Math.abs(key.hashCode()) % this.cubetas;
    } 

    public void insertar(K key, V value){
        int indice = hash(key);

        for(Tupla<K,V> tupla : this.table[indice]){
            if(tupla.getKey().equals(key)){
                tupla.setValue(value);
                return;
            }
        }
        table[indice].add(new Tupla<>(key,value));
        this.numElementos++;
    }

    public V buscar(K key){
        int indice = hash(key);

        for(Tupla<K,V> tupla : this.table[indice]){
            if(tupla.getKey().equals(key))
                return tupla.getValue();
        }
        return null;
    }

    public void eliminar(K key){
        int indice = hash(key);

        for(Tupla<K,V> tupla : this.table[indice]){
            if(tupla.getKey().equals(key)){
                table[indice].remove(tupla);
                this.numElementos--;
                return;
            }
        }
    }

    public double factorCarga(){
        return (double) this.numElementos / this.cubetas;
    }

    @Override 
    public String toString(){
        String cadena = "";

        for(int i = 0; i < table.length; i++){
            cadena += i + " -> ";

            if(table[i]!=null && !table[i].isEmpty()){
                for(Tupla<K,V> tupla : table[i]){
                    cadena += "[" + tupla.getKey() + ", " + tupla.getValue() + "] -> ";
                } 
            }
            cadena += " null\n";
        }
        
        return cadena;
    }

}