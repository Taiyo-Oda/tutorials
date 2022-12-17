package concurrentcollections;

import java.util.concurrent.BlockingQueue;

public class OrderProducer implements Runnable {

	private BlockingQueue<String> queue;

	public OrderProducer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			// put : 指定された要素をこのキューに挿入し、必要ならスペースが空くまで待つ。
			queue.put("Mac Book");
			queue.put("Dell LapTop");
			queue.put("Iphone");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
