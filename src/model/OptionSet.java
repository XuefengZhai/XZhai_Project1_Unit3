/*
 * Xuefeng Zhai
 * xzhai@cmu.edu
 */
package model;

import java.util.ArrayList;

/*
 * OptionSet serializable class
 */
public class OptionSet implements
java.io.Serializable
 {
	
	private static final long serialVersionUID = 3024128351917169821L;
	private String name;
	private ArrayList<Option> opt;
	private Option choice;
	
	/*
	 * Constructors
	 */
	protected OptionSet(){
		
	}

	protected OptionSet(String name) {
		
		this.name = name;
		opt = new ArrayList<Option>();
		choice = null;
	}

	/*
	 * Getters
	 */
	protected String getName() {
		return name;
	}

	protected Option getOpt(int index) {
		return opt.get(index);
	}
	
	protected ArrayList<Option> getOpt(){
		return opt;
	}
		
	protected Option getOptChoice(){
		return choice;
	}
	
	/*
	 * Setters
	 */
	protected void setName(String name) {
		this.name = name;
	}

	protected void setOpt(String name, float price) {
		
		Option newOption = new Option(name, price);
		opt.add(newOption);
	}
	
	protected void setOptChoice(String optionName){
		Option temp = new Option();
		for(int i=0;i<opt.size();i++){
			temp = opt.get(i);
			if(temp.getName().equals(optionName)){
				break;
			}
		}
		this.choice = temp;
	}
	
	/*
	 * Inner Class Option
	 */
	public class Option implements
	java.io.Serializable
{
		private static final long serialVersionUID = -3149609984354841462L;
		private String name;
		private float price;
		
		/*
		 * Constructors
		 */
		protected Option(){
			
		}
		
		protected Option(String name, float price){
			this.name = name;
			this.price = price; 
		}
		
		/*
		 * Getters
		 */
		protected String getName() {
			return name;
		}

		protected float getPrice() {
			return price;
		}
		/*
		 * Setters
		 */
		protected void setName(String name) {
			this.name = name;
		}

		protected void setPrice(float price) {
			this.price = price;
		}
	}


	
	
}
