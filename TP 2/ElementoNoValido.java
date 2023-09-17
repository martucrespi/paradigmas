package queue;

public class ElementoNoValido extends QueueElemento {
	
	public ElementoNoValido() {
	}
	

	public Object take() {
		throw new Error("Queue is empty");
	}


	public Object head() {
		throw new Error("Queue is empty");
	}


}
