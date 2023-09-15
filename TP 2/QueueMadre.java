package queue;

public abstract class QueueMadre {
	private String elemento;
	public abstract QueueMadre take();
	public abstract QueueMadre head();
	
	public String getQueueElement() {
		return elemento;
	}
	public void setQueueElement(String elemento) {
		this.elemento = elemento;
	}
	
	
}
