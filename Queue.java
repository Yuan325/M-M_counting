
public class Queue<T> {
	private int manyItems;
	Node<T> head, tail;
	
	public Queue() {
		head = null;
		tail = null;
		manyItems = 0;
	}
	
	
	public void enqueue(T obj) {
		if (head == null) {
			Node<T> newNode = new Node<T>(obj);
			head = newNode;
			tail = newNode;
			manyItems++;
		}
		else {
			Node<T> newNode = new Node<T>(obj);
			tail.setNext(newNode);
			tail = newNode;
			manyItems++;
		}
	}
	
	public void add(Queue<T> collection) {
		if (tail == null) {
			head = collection.getHead();
			manyItems = collection.getManyItems();
		}
		else {
			tail.setNext(collection.getHead());
			manyItems = manyItems + collection.getManyItems();
		}
		tail = collection.getTail();
	}
	
	public boolean dequeue() {
		if (head == null) {
			System.out.println("Nothing to dequeue.");
			return false;
		}
		
		else if (head == tail){
			head = null;
			tail = null;
			manyItems--;
			return true;
		}
		
		else{
			head = head.getNext();
			manyItems--;
			return true;
		}
	}
	
	public int getManyItems() {
		return manyItems;
	}
	
	public Node<T> getHead() {
		return head;
	}
	
	public Node<T> getTail() {
		return tail;
	}
	

}
