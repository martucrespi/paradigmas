package queue;

public abstract class QueueMadre {
	private Object elemento;
	public abstract QueueMadre take();
	public abstract QueueMadre head();
	
	public Object getElement() {
		return elemento;
	}
}
