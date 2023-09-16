package queue;

import java.util.ArrayList;


public class Queue {
	private ArrayList<QueueMadre> lista = new ArrayList<>();
	
	public Queue() {
		lista.add(0, new QueueVacia());
	}
	
  public boolean isEmpty() {
		return lista.size() == 1;
  }
  
	
	public Queue add( String cargo) {
		lista.add(1, new QueueLlena(cargo));
		return this;
	}

	public Object take(){
		QueueMadre removedElement = lista.remove(lista.size()-1);
		return removedElement.take();
	}

	
	public Object head() {
		QueueMadre headElement = lista.get(lista.size()-1);
		return headElement.head();
	}

	public int size() {
		return lista.size()-1;
	}

}




