package util;

import scale.EditOption;
import adapter.*;
import model.*;

public class Test {

	public static void main(String[] args) {
		
		BuildAuto auto = new BuildAuto();
		auto.buildAuto("src/data1.txt");
		
		System.out.println();
		System.out.println("Print the first model:");
		auto.printAuto("Wagon ZTW");
		
		Automobile autoForThread = auto.findAuto("Wagon ZTW");
		
		
		//EditOption delete given option set and an option
		
		EditOption eo = new EditOption(autoForThread, "Color","Power Moonroof", "New Selected");
		Thread t1 = new Thread(eo);
		EditOption eo2 = new EditOption(autoForThread, "Power Moonroof", "Transmission", "Standard");
		Thread t2 = new Thread(eo2);
		t1.start();
		t2.start();

	}

}
