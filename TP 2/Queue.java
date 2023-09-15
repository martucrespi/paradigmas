package queue;

import java.util.ArrayList;


public class Queue {
	private ArrayList<QueueMadre> lista = new ArrayList<>();
	
	public Queue() {
		lista.add(0, (new QueueVacia()));
	}
	
  public boolean isEmpty() {
		return lista.isEmpty();
  }
  
	public Queue add( QueueMadre  cargo ) {
		lista.add(0, cargo);
		return this;
	}
	

	public QueueMadre take(){
		return lista.get(lista.size()-1).take();
	}

	
	public QueueMadre head() {
		return lista.get(lista.size()-1).head();
	}

	public int size() {
		return lista.size();
	}

}




