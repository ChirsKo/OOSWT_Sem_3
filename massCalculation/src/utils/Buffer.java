package utils;

import java.util.*;

import lock.*;


public class Buffer<A> {
	
	private List<A> buffer;
	private AbstractLock lock;
	private AbstractLock criticalSection;
	
	public Buffer(){
		
		this.buffer = new Vector<A>();
		this.lock = new Lock(true);
		this.criticalSection = new Lock(false);
		
	}
	
	
	public void put(A object){
		this.criticalSection.lock();
		this.buffer.add(object);
		this.lock.unlock();
		this.criticalSection.unlock();
	}
	
	public A get(){
		this.lock.lock();
		this.criticalSection.lock();
		A result = this.buffer.get(0);
		this.buffer.remove(0);
		if (!this.buffer.isEmpty())
			this.lock.unlock();
			this.criticalSection.unlock();
		return result;
		
	}
	
}
