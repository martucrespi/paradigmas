package queue;

import java.util.LinkedList;


public class Queue {
	private LinkedList lista = new LinkedList();
	
	public Queue() {
	}
	
  public boolean isEmpty() {
		return lista.isEmpty();
  }
  
	public Queue add( Object  cargo ) {
		lista.addLast(cargo);
		return this;
	}
	

	public Object take(){
		if(lista.isEmpty()) {
			throw new Error("Queue is empty");
		}else {
		return lista.pollFirst();
		}
	}

/*	
	public Object take() {
	    return lista.isEmpty() ? throw new Error("Queue is empty") : lista.pollFirst();
	}
*/
	
	
	
/*
 import java.util.Optional;

public Object take() {
    return Optional.ofNullable(lista.pollFirst())
                   .orElseThrow(() -> new Error("Queue is empty"));
}
 */
	
	
	
	public Object head() {
		
		if(lista.isEmpty()) {
			throw new Error("Queue is empty");
		}else {
		return lista.getFirst();
		}
		
		
	}

	public int size() {
		return lista.size();
	}

}



