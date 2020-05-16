
public class Driver {
	public static void main(String[] args) {
		
        Queue collection = new Queue();
        
        
        for (int index = 0; index < 10000; index++) {
            int mm = ((int) (Math.random() * 10000)) % 5;
            Integer integ = new Integer(mm);
            collection.enqueue(integ);
        }
        
        
        RequestProcessor processor = new RequestProcessor(collection);
        
        
        int numberOfThreads = 5;
        Thread[] threads = new Thread[numberOfThreads];
        
        for (int index = 0; index < threads.length; index++) {
            threads[index] = new Thread(processor);
            threads[index].start(); 
        }
        
        
        try {
            for (int index = 0; index < threads.length; index++) {
                threads[index].join();
        }
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        }
        
        ThreadStatisticsSetup.print(); 
    }
}
