
public class ThreadStatisticsSetup {
	
	private static Queue<ThreadStatisticsSetup> combine = new Queue<ThreadStatisticsSetup>();
	
	private int red;
	private int brown;
	private int yellow;
	private int green;
	private int blue;
	
	private double total;
	
	public ThreadStatisticsSetup() {
	}
	
	public int getRed() {
		return red;
	}
	
	public int getBrown() {
		return brown;
	}
	
	public int getYellow() {
		return yellow;
	}
	
	public int getGreen() {
		return green;
	}
	
	public int getBlue() {
		return blue;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void process(Integer current) {
		if (current == 0) {
			red++;
			total++;
		}
		else if (current == 1) {
			brown++;
			total++;
		}
		else if(current == 2) {
			yellow++;
			total++;
		}
		else if(current ==3) {
			green++;
			total++;
		}
		else if(current ==4) {
			blue++;
			total++;
		}
	}
	
	public ThreadStatisticsSetup get() {
		return get();
	}
	
	public void combineOutput() {
		combine.enqueue(this);
	}
	
	public static void print() {
		int total = 0;
		int red = 0;
		int brown= 0;
		int yellow =0;
		int green =0;
		int blue=0;
		Node<ThreadStatisticsSetup> current = combine.getHead();
		for (int i = 1; i<combine.getManyItems()+1; i++) {
			ThreadStatisticsSetup currentData = current.getData();
			System.out.println("Tabulator: " + i + " Count " + currentData.getRed() + " for color Red = " + (currentData.getRed()/currentData.getTotal()*100) + "%");
			System.out.println("Tabulator: " + i + " Count " + currentData.getBrown() + " for color Brown = " + (currentData.getBrown()/currentData.getTotal()*100) + "%");
			System.out.println("Tabulator: " + i + " Count " + currentData.getYellow() + " for color Yellow = " + (currentData.getYellow()/currentData.getTotal()*100) + "%");
			System.out.println("Tabulator: " + i + " Count " + currentData.getGreen() + " for color Green = " + (currentData.getGreen()/currentData.getTotal()*100) + "%");
			System.out.println("Tabulator: " + i + " Count " + currentData.getBlue() + " for color Blue = " + (currentData.getBlue()/currentData.getTotal()*100) + "%\n");
			current = current.getNext();
			total += currentData.getTotal();
			red += currentData.getRed();
			brown += currentData.getBrown();
			yellow += currentData.getYellow();
			green += currentData.getGreen();
			blue += currentData.getBlue();
		}
		
		System.out.println("== Totals ==");
		System.out.println("Color Red composes " + String.format("%.2f", (red/10000.0*100)) + "% of the total");
		System.out.println("Color Brown composes " + String.format("%.2f",(brown/10000.0*100)) + "% of the total");
		System.out.println("Color Yellow composes " + String.format("%.2f",(yellow/10000.0*100)) + "% of the total");
		System.out.println("Color Green composes " + String.format("%.2f",(green/10000.0*100)) + "% of the total");
		System.out.println("Color Blue composes " + String.format("%.2f",(blue/10000.0*100)) + "% of the total");
		
		
	}

}


