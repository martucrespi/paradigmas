package queue;

import java.util.ArrayList;


public class Queue {
	private ArrayList<QueueMadre> lista = new ArrayList<>();
	
	public Queue() {
		lista.add(new QueueVacia());
	}
	
  public boolean isEmpty() {
		return lista.size() == 1;
  }
  
	
	public Queue add( String cargo) {
		lista.add(0, new QueueLlena(cargo));
		return this;
	}

	public Object take(){
		return lista.remove(lista.size()-2).getElement();
	}

	
	public Object head() {
		return lista.get(lista.size()-2).getElement();
	}

	public int size() {
		return lista.size()-1;
	}

}




