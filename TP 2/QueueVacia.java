package queue;

public class QueueVacia extends QueueMadre {
	
	public QueueVacia() {
	}


	public Object take() {
		throw new Error("Queue is empty");
	}


	public Object head() {
		throw new Error("Queue is empty");
	}


}
