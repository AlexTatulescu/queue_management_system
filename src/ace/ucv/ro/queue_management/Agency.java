package ace.ucv.ro.queue_management;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ace.ucv.ro.queue_implementation.Queue;

public class Agency extends Thread {

	private Random random;
	private final int TASK_1 = 20;
	private final int TASK_2 = 25;
	private final int TASK_3 = 30;
	private final int TASK_4 = 35;
	private List<PayOffice> payOfficeList;
	private List<Integer> tasks;

	public Agency(List<PayOffice> payOfficeList) {

		this.random = new Random();

		this.payOfficeList = new ArrayList<PayOffice>();
		this.payOfficeList = payOfficeList;

		this.tasks = new ArrayList<Integer>();
		tasks.add(TASK_1);
		tasks.add(TASK_2);
		tasks.add(TASK_3);
		tasks.add(TASK_4);
	}

	public Queue minumumQueue(Queue queue1, Queue queue2) {
		if (queue1.getTimeSize() < queue2.getTimeSize()) {
			return queue1;
		} else {
			return queue2;
		}
	}

	public Queue leastTimeQueue(List<PayOffice> payOfficeList2) {

		Queue minQueue = minumumQueue(payOfficeList2.get(0).getOfficeQueue(), payOfficeList2.get(1).getOfficeQueue());

		for (int i = 2; i < payOfficeList2.size(); i++) {
			minQueue = minumumQueue(minQueue, payOfficeList2.get(i).getOfficeQueue());
		}

		return minQueue;
	}

	public void run() {

		for (int i = 0; i < payOfficeList.size(); i++) {
			payOfficeList.get(i).start();
		}

		for (int i = 0; i < 50; i++) {
			leastTimeQueue(payOfficeList).add(new Person(i, tasks.get(random.nextInt(4))));
			for (int j = 0; j < payOfficeList.size(); j++) {
				System.out.println(
						"Ghiseul " + j + " are " + payOfficeList.get(j).getOfficeQueue().getSize() + " clienti");
			}
			try {
				Thread.sleep(random.nextInt(10));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		try {
			for (int j = 0; j < payOfficeList.size(); j++) {
				payOfficeList.get(j).join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
