package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		if (array[0] == null) {
			return null;
		}return array[0];
	}

	@Override
	public boolean isEmpty() {
		if (this.tail == -1) {
			return true;
		}return false;
	}

	@Override
	public boolean isFull() {
		if (this.tail == (this.array.length -1)) {
			return true;
		}return false;
	}

	private void shiftLeft() {
		for (int i = 0; i < this.tail; i++) {
			array[i] = array[i+1];
		
		} this.tail =-1;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		this.tail += 1;
		array[tail] = element;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		T aux = array[0];
		shiftLeft();
		return aux;
	}

}
