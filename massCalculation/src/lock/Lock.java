package lock;

public class Lock implements AbstractLock{

	private boolean locked;
	
	public Lock(boolean locked){
		this.locked = locked;
	}
	
	/**
	 * Lock the Buffer.
	 */
	public synchronized void lock(){
		while (this.locked)
			try {
				this.wait();
			} catch (InterruptedException e) {
				return;
			}
				this.locked = true;
	}
	
	/**
	 * Unlock the Buffer;
	 */	
	public void unlock(){
		this.locked = false;
		this.notify();
	}
}
