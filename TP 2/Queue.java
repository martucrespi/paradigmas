package queue;

import java.util.ArrayList;


public class Queue {
	private ArrayList<QueueMadre> lista = new ArrayList<>();
	
	public Queue() {
		lista.add(0, (new QueueVacia()));
	}
	
  public boolean isEmpty() {
		return lista.size() == 1;
  }
  
	public Queue add( Object  cargo ) {
		QueueLlena element = new QueueLlena(cargo);
//		QueueMadre elementoVacio = lista.get(lista.size()-1);
		lista.add(lista.size()-2, element);
//		lista.remove(elementoVacio);
//		lista.add(element);	
//		lista.add(elementoVacio);
		return this;
	}
	

	public QueueMadre take(){
		return lista.get(lista.size()-1).take();
	}

	
	public QueueMadre head() {
		return lista.get(lista.size()-1).head();
	}

	public int size() {
		return lista.size()-1;
	}

}
