package dsa.shaurya.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConstumer {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int maxSize = 100;
		Producer producer = new Producer(queue, maxSize);
		Consumer consumer = new Consumer(queue, maxSize);
		System.out.println("Threads going to start");
		producer.start();
		consumer.start();
	}
}

class Producer extends Thread {
	Queue<Integer> queue;
	int maxSize;

	Producer(Queue<Integer> queue, int maxSize) {
		this.queue = queue;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				while (maxSize == queue.size()) {
					try {
						System.out.println("Producer is waiting");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Random random = new Random();
				int num = random.nextInt(100);
				System.out.println("Producer added " + num);
				queue.add(num);
				queue.notify();
			} // sync
		} // while
	}
}

class Consumer extends Thread {
	Queue<Integer> queue;
	int maxSize;

	Consumer(Queue<Integer> queue, int maxSize) {
		this.queue=queue;
		this.maxSize=maxSize;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				while (queue.isEmpty()) {
					try {
						System.out.println("Consmer is waiting ");
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				int num = queue.poll();
				System.out.println("Consumer used " + num);
				queue.notify();
			}
		} // while
	}

}
