/*
 * Proxy for automobile
 */


package adapter;

import java.util.LinkedHashMap;

import util.FileIO;
import model.*;

public abstract class ProxyAutomobile {
	
	private static LinkedHashMap<String,Automobile> a1 = new LinkedHashMap<String,Automobile>();

	public void buildAuto(String filename){
		FileIO fio = new FileIO();
		Automobile temp = fio.buildAutoObject(filename);
		a1.put(temp.getModel(), temp);
	}
	
	public void printAuto(String modelname){
		a1.get(modelname).print();
	}
	
	public void updateOptionSetName(String modelname, String optionSetname, String newName){
		a1.get(modelname).updateOptionSetName(optionSetname, newName);
	}
	public void updateOptionPrice(String modelname, String optionSetname, String option, float newPrice){
		a1.get(modelname).updateOption(optionSetname, option, newPrice);
	}
}



