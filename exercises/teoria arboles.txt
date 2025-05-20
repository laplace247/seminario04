/*
¿QUE ES UN ARBOL BINARIO?
- ESTRUCTURA DE DATOS (JERARQUICA)
- DESARROLLO DE ALGORITMOS
- PERMITE LA ORGANIZACION DE DATOS
- REALIZAR UN BUSQUEDA BINARIA
 
*PARTES DE UN ARBOL BINARIO
- RAIZ : NODO SUPERIOR DEL ARBOL
- NODO : ELEMENTO INTERNO / TERMINALES
- NODO/HIJO : OPERANDO DEL NODO
- HOJA : NODO QUE NO TIENE HIJO
- ALTURA/DIMENSION : SON LOS NIVELES DESDE LA RAIZ
  HASTA LA HOJA
 
*/
 
public class ejercicioArbolBinario {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        //insertamos elementos en el arbol binario
        arbol.insertar(80);
        arbol.insertar(60);
        arbol.insertar(70);
        arbol.insertar(40);
        arbol.insertar(20);
        arbol.insertar(30);
        arbol.insertar(50);
        //realizar un recorrido en orden
        System.out.println("Recorrido Inorder:");
        arbol.inorder();
        //comprobar si un valor existe o no
        System.out.println("El valor 40 esta en el arbol?" + arbol.existe(40));
        System.out.println("El valor 90 esta en el arbol?" + arbol.existe(90));
    }
}
 
class Nodo{
    int valor;
    Nodo izquierdo,derecho;
 
    //crear un nuevo nodo - metodo constructor
    public Nodo(int valor){
        this.valor = valor;
        izquierdo = derecho = null;
    }    
}
 
class ArbolBinario{
    Nodo raiz;
    //metodo constructor
    public ArbolBinario(){
        raiz = null;
    }
    public void insertar(int valor){
        raiz = insertarRecursivo(raiz, valor);
    }
    //metodo recursivo para insertar un nuevo valor
    private Nodo insertarRecursivo(Nodo raiz,int valor){
        //si el arbol esta vacio, coloca el nuevo nodo
        if(raiz == null){
            raiz = new Nodo(valor);
            return raiz;
        }
        //si el valor es menor, lo insertamos 
        //en el subarbol izquierdo
        if(valor < raiz.valor){
            raiz.izquierdo = insertarRecursivo(raiz.izquierdo,valor);
        }
        //si el valor es mayor, lo insertamos
        //en el subarbol derecho
        if(valor > raiz.valor){
            raiz.derecho = insertarRecursivo(raiz.derecho, valor);    
        }
        //retornar el nodo sin cambios
        return raiz;
    }
    //metodo para realizar un recorrido en orden(inorder)
    public void inorder(){
        //creamos antes un metodo recursivo 
        //para el recorrido en orden
        inorderRecursivo(raiz);
    }
    //Metodo recursivo para hacer el recorrido en orden
    private void inorderRecursivo(Nodo raiz){
        if(raiz != null){
            inorderRecursivo(raiz.izquierdo);
            System.out.println(raiz.valor + " ");
            inorderRecursivo(raiz.derecho);
            //ahora si lo invoco para ejecutar en inorder()
        }
    }
    //metodo para verificar si un valor existe en el arbol
    public boolean existe(int valor){
        return existeRecursivo(raiz, valor);
    }
    //creare un metodo para verificar si existe o no
    private boolean existeRecursivo(Nodo raiz, int valor){
        if(raiz == null){
            return false;
        }
        if(raiz.valor == valor){
            return true;
        }
        return valor < raiz.valor
                ?existeRecursivo(raiz.izquierdo, valor)
                :existeRecursivo(raiz.derecho, valor);
    }

}