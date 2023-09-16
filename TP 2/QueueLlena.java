package queue;

import java.util.ArrayList;

public class QueueLlena extends QueueMadre{
	private ArrayList<QueueMadre> lista = new ArrayList<>();
	private Object element;
	
	
	public QueueLlena (Object element) {
		this.element = element;
	}
	
	public Object take() {
		return element;
	}

	
	public Object head() {
		return element;
	}

}
