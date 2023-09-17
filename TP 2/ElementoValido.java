package queue;

import java.util.ArrayList;

public class ElementoValido extends QueueElemento{
	private ArrayList<QueueElemento> lista = new ArrayList<>();
	private Object element;
	
	
	public ElementoValido (Object element) {
		this.element = element;
	}
	
	public Object getElement() {
		return element;
	}

	
	public Object head() {
		return element;
	}

}
