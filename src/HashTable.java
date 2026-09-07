
import java.util.LinkedList;

public class HashTable<K,V>{

    private LinkedList<Tupla<K,V>>[] table;
    private int cubetas;

    public HashTable(int cubetas){
        this.cubetas  = cubetas;
        table = new LinkedList[this.cubetas];

        for(int i = 0; i < table.length; i++){
            table[i] = new LinkedList<>();
        }
    }

    private int hash(K key){
        return Math.abs(key.hashCode()) % this.cubetas;
    } 

<<<<<<< HEAD
    public void insertar(K key, V value){
        int indice = hash(key);

        for(Tupla<K,V> tupla : this.table[indice]){
            if(tupla.getKey().equals(key)){
                tupla.setValue(value);
                return;
            }
        }
        table[indice].add(new Tupla<>(key,value));
    }
=======
    
>>>>>>> e946abd1afccb792754f25db87d0333fd608e3b9

}