package util;

import scale.EditOption;
import adapter.*;
import model.*;

public class Test {

	public static void main(String[] args) {
		
		BuildAuto auto = new BuildAuto();
		auto.buildAuto("src/data1.txt");
		
		System.out.println();
		System.out.println("Print the model:");
		auto.printAuto("Wagon ZTW");
		
		Automobile autoForThread = auto.findAuto("Wagon ZTW");
		
		
		//EditOption delete given option set and an option
		
		/*
		 * Only Thread1 will sleep for 5000ms
		 * Set in the Automobile class, deleteOptionSet method
		 * Since the method is synchronized.
		 * So thread 2 will not do anything before thread 1 finished
		 */
		
		EditOption eo = new EditOption(autoForThread, "Color","Side Impact Air Bags", "None");
		Thread t1 = new Thread(eo);
		EditOption eo2 = new EditOption(autoForThread, "Power Moonroof", "Transmission", "Standard");
		Thread t2 = new Thread(eo2);
		t1.setName("Thread1");
		t2.setName("Thread2");
		t1.start();
		t2.start();
		System.out.println();
		System.out.println("Started Thread");
		System.out.println("Now nothing is deleted since there is a sleep at the beginning of thread1");
		System.out.println("Thread 2 is waiting for the synchronized part of thread 1 to finish");
		
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
		System.out.println("Both thread1 and thread2 finished its deletion");
		
		System.out.println();
		
		auto.printAuto("Wagon ZTW");

		
		

	}

}
