package ace.ucv.ro.queue_management;

public class Person {

	private int task;
	private int index;

	public Person(int task, int index) {
		this.task = task;
		this.index = index;
	}

	public int getTask() {
		return task;
	}

	public int getIndex() {
		return index;
	}
}
