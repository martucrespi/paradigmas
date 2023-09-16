package queue;

public abstract class QueueMadre {
	private Object elemento;
	public abstract Object take();
	public abstract Object head();
	
	public Object getElement() {
		return elemento;
	}
}
