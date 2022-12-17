package concurrentcollections;

import java.util.concurrent.BlockingQueue;

public class OrderConsumer implements Runnable {

	private BlockingQueue<String> queue;

	public OrderConsumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			// take : このキューの先頭を取得し削除する。必要であれば、要素が利用可能になるまで待つ。
			System.out.println(queue.take());
			System.out.println(queue.take());
			System.out.println(queue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
