package ace.ucv.ro.queue_implementation;

import java.util.LinkedList;

import ace.ucv.ro.queue_management.Person;

public class Queue {
	private LinkedList<Person> list;

	public Queue() {
		list = new LinkedList<Person>();
	}

	public boolean isEmpty() {
		return (list.size() == 0);
	}

	public void add(Person item) {
		list.addLast(item);
	}

	public int remove() {
		int sarcina = list.get(0).getTask();
		list.remove(0);

		return sarcina;
	}

	public int fistElement() {
		return list.get(0).getTask();
	}

	public int getSize() {
		return list.size();
	}

	public int getTimeSize() {
		int a = 0;
		if (list == null) {
			return 0;
		} else {
			for (int i = 0; i < list.size(); i++) {
				a += list.get(i).getTask();
			}
			return a;
		}
	}
}
