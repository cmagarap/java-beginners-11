package application;

import java.util.Iterator;

class Ring<E> implements Iterable<E>{
	
	private E[] items;
	private int writePosition = 0;
	private int numberOfItems = 0;
	
	private class RingIterator implements Iterator<E> {
		
		private int readPosition = 0;

		@Override
		public boolean hasNext() {
			return readPosition < numberOfItems;
		}

		@Override
		public E next() {
			return items[readPosition++];
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public Ring(int size) {
		items = (E[])new Object[size];
	}
	
	public void add(E element) {
		items[writePosition++] = element;
		
		if(writePosition == items.length) {
			writePosition = 0;
		}
		
		if(++numberOfItems > items.length) {
			numberOfItems = items.length;
		}
	}
	
	public E get(int index) {
		return items[index];
	}
	
	public int size() {
		return numberOfItems;
	}

	@Override
	public Iterator<E> iterator() {
		return new RingIterator();
	}
}

public class App {

	public static void main(String[] args) {
		
		Ring<Integer> ring = new Ring<>(3);
		
		ring.add(1);
		ring.add(2);
		ring.add(3);
		ring.add(4);
		ring.add(5);
		
		for(var it = ring.iterator(); it.hasNext(); ) {
			System.out.println(it.next());
		}

	}

}
