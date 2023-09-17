package queue;

public class ElementoValido extends QueueElemento{
	private Object element;
	
	
	public ElementoValido (Object element) {
		this.element = element;
	}
	
	public Object getElement() {
		return element;
	}

}
