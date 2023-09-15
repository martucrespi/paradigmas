package queue;

import java.util.ArrayList;

public class QueueLlena extends QueueMadre{
	private ArrayList<QueueMadre> lista = new ArrayList<>();
	
	public QueueLlena () {
	}
	
	
	public QueueMadre take() {
		return lista.remove(lista.size()-1);
	}

	
	public QueueMadre head() {
		return lista.get(lista.size()-1);
	}

}
