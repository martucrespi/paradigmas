package queue;

import java.util.ArrayList;


public class Queue {
	private ArrayList<QueueElemento> lista = new ArrayList<>();
	
	public Queue() {
		lista.add(0, new ElementoNoValido());
	}
	
  public boolean isEmpty() {
		return lista.size() == 1;
  }
  
	
	public Queue add( String cargo) {
		lista.add(1, new ElementoValido(cargo));
		return this;
	}

	public Object take(){
		QueueElemento removedElement = lista.remove(lista.size()-1);
		return removedElement.take();
	}

	
	public Object head() {
		QueueElemento headElement = lista.get(lista.size()-1);
		return headElement.head();
	}

	public int size() {
		return lista.size()-1;
	}

}
