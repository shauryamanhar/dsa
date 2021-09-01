package dsa.shaurya.multithreading;

public class EvenOddPrint {
	boolean isOdd;
	int count = 1;
	int maxCount = 1000;

	void printOdd() {
		while (count < maxCount) {
			synchronized (this) {
				while (isOdd == false) {
					try {
						System.out.println("Odd printer is waiting");
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} // while
				System.out.println(count);
				count++;
				isOdd = false;
				this.notify();
			} // sync
		}
	}

	void printEven() {
		while (count < maxCount) {
			synchronized (this) {
				while (isOdd == true) {
					try {
						System.out.println("Even printer is waiting");
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} // while
				System.out.println(count);
				count++;
				isOdd = true;
				this.notify();
			} // sync
		}
	}

	public static void main(String[] args) {
		EvenOddPrint evenOddPrint = new EvenOddPrint();
		Thread t1 = new Thread(() -> {
			evenOddPrint.printOdd();
		});
		Thread t2 = new Thread(() -> {
			evenOddPrint.printEven();
		});
		t1.start();
		t2.start();
	}

}
