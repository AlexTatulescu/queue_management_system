package ace.ucv.ro.agency_simulation;

import java.util.Arrays;
import java.util.Scanner;

import ace.ucv.ro.queue_implementation.Queue;
import ace.ucv.ro.queue_management.Agency;
import ace.ucv.ro.queue_management.PayOffice;

public class AgencySimulation {
	public static void main(String[] args) throws InterruptedException {

		Scanner in = new Scanner(System.in);
		System.out.println("Introduceti numarul de ghisee ale agentiei:");
		int payOfficeNumber = in.nextInt();
		in.close();

		PayOffice[] payOffices = new PayOffice[payOfficeNumber];
		Queue[] payOfficesQueue = new Queue[payOfficeNumber];

		for (int i = 0; i < payOfficeNumber; i++) {
			payOfficesQueue[i] = new Queue();
		}

		for (int i = 0; i < payOfficeNumber; i++) {
			payOffices[i] = new PayOffice(payOfficesQueue[i]);
		}

		Agency agency = new Agency(Arrays.asList(payOffices));

		agency.start();

		agency.join();
	}
}
