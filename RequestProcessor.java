import java.util.concurrent.locks.ReentrantLock;

public class RequestProcessor extends Thread {
	
	private ReentrantLock collectionLock = new ReentrantLock();
	
	private Queue inputCollection;
	
	
	private ThreadLocal<ThreadStatisticsSetup> local = new ThreadLocal<ThreadStatisticsSetup>(){
		protected ThreadStatisticsSetup initialValue() {
			return new ThreadStatisticsSetup();
		}
	};
	
	
	public RequestProcessor(Queue collection) {
		inputCollection = collection;
	}

	public void run() {
		while (inputCollection.getHead() != null) {
			Integer data = null;
			collectionLock.lock();
			try {
				Node current = inputCollection.getHead();
				data = (Integer)current.getData();
				inputCollection.dequeue();
			}
			catch (Exception e){
			}
			finally {
				collectionLock.unlock();
			}
			if (data != null)
				local.get().process(data);
		}
		local.get().combineOutput();
	}
	
	public int getInputCollectionSize() {
		return inputCollection.getManyItems();
	}


}