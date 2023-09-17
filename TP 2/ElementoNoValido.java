package queue;

public class ElementoNoValido extends QueueElemento {
	
	public ElementoNoValido() {
	}
	

	public Object getElement() {
		throw new Error("Queue is empty");
	}

}
