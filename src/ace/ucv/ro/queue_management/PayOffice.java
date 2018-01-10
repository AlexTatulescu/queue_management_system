package ace.ucv.ro.queue_management;

import ace.ucv.ro.queue_implementation.Queue;

public class PayOffice extends Thread {

	private Queue officeQueue;
	private int target;

	public PayOffice(Queue officeQueue) {
		this.officeQueue = officeQueue;
		this.target = 0;
	}

	public void run() {
		int aux = 0;

		while (target < 500) {
			if (!officeQueue.isEmpty()) {
				try {
					aux = officeQueue.remove();
					target += aux;
					Thread.sleep(aux);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				try {
					Thread.sleep(10);
					target += 10;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public Queue getOfficeQueue() {
		return officeQueue;
	}
}
