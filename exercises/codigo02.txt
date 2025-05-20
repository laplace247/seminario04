/*
Identificaremos si un postre es dulce o salado
 
*/
 
import java.util.Scanner;
 
class Nodo{
    String dato;
    Nodo izquierdo,derecho;
    public Nodo(String dato){
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}
 
class ArbolClasificacion{
    Nodo raiz;
    public ArbolClasificacion(){
        //crear arbol binario
        raiz = new Nodo("¿El postre es un sabor mayormente dulce?");
        raiz.izquierdo = new Nodo("¿Es un postre hornedo como galletas o pastel?");
        raiz.derecho = new Nodo("¿Contiene ingredientes como sal o mantequilla?");
 
        //subarbol izquierdo (dulce)
        raiz.izquierdo.izquierdo = new Nodo("Dulce Caliente XD");
        raiz.izquierdo.derecho = new Nodo("Dulce Frio xd");
        //subarbol derecho (salado)
        raiz.derecho.izquierdo = new Nodo("Saladito XD");
        raiz.derecho.derecho = new Nodo("Salado");    
    }
    public void clasificar(){
        Scanner scanner = new Scanner(System.in);
        Nodo actual = raiz;
        //navegar el arbol hasta llegar a la hoja
        while (actual.izquierdo != null && actual.derecho != null){
            System.out.println(actual.dato);
            System.out.println("Responde Si o No, XD:");
            String respuesta = scanner.nextLine().toLowerCase();
            if(respuesta.equals("si")){
                actual = actual.izquierdo;
            }else if(respuesta.equals("no")){
                actual = actual.derecho;
            }else{
                System.out.println("Respuesta Invalida!! XD!!, intentalo! otra vez! XD!!");
            }
        }
        //SI LLEGAMOS A UN NODO HOJA
        System.out.println("El postre es clasificado como: "+ actual.dato);       
    }  
}
 
 
public class ejercicio3 {
    public static void main(String[] args) {
        ArbolClasificacion arbol = new ArbolClasificacion();
        System.out.println("Ejercicio para clasificar postres si son dulces o salados XD!!");
        arbol.clasificar();
    }
}