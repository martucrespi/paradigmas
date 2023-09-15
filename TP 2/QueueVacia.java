package queue;

public class QueueVacia extends QueueMadre {
	
	public QueueVacia() {
	}


	public QueueMadre take() {
		throw new Error("Queue is empty");
	}


	public QueueMadre head() {
		throw new Error("Queue is empty");
	}

}
