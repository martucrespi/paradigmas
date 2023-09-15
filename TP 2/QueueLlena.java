package queue;

import java.util.ArrayList;

public class QueueLlena extends QueueMadre{
	private ArrayList<QueueMadre> lista = new ArrayList<>();
	private Object element;
	
	
	public QueueLlena (Object element) {
		this.element = element;
	}
	
	public Object getElement() {
		return element;
	}
	
	public QueueMadre take() {
		return lista.remove(lista.size()-1);
	}

	
	public QueueMadre head() {
		return lista.get(0);
	}

}
