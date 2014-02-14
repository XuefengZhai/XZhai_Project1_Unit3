/*
 * Xuefeng Zhai
 * xzhai@cmu.edu
 */
package model;

import java.util.ArrayList;

import model.OptionSet;

/*
 * Automobile Serializable Class
 */
public class Automobile implements
java.io.Serializable
{

	private static final long serialVersionUID = 6867974146880162446L;
	private String make;
	private String model;
	private float baseprice;
	private ArrayList<OptionSet> optSet;
	
	/*
	 * Constroctors
	 */
	public Automobile(){
	
	}

	public Automobile(String make, String model, float baseprice) {
		this.make = make;
		this.model = model;
		this.baseprice = baseprice;
		optSet = new ArrayList<OptionSet>();
	}

	/*
	 * Getters
	 */
	public synchronized String getMake() {
		return make;
	}
	
	public synchronized String getModel() {
		return model;
	}
	
	public synchronized float getBaseprice() {
		return baseprice;
	}
		
	public synchronized String getOptionChoice(String setName){
		return findOptSet(setName).getOptChoice().getName();
	}
	
	public synchronized float getOptionChoicePrice(String setName){
		return findOptSet(setName).getOptChoice().getPrice();	
		}
	
	public synchronized float getTotalPrice(){
		
		float totalPrice = 0;
		for(int i=0;i<optSet.size();i++){
			if( optSet.get(i).getOptChoice() == null){
				continue;
			}
			else
				totalPrice = totalPrice+optSet.get(i).getOptChoice().getPrice();
			}
		return totalPrice;
	}

	/*
	 * Setters
	 */

	public synchronized void setMake(String make) {
		this.make = make;
	}
	
	public synchronized void setModel(String model) {
		this.model = model;
	}

	public synchronized void setBaseprice(float baseprice) {
		this.baseprice = baseprice;
	}
	
	public synchronized void setOptionChoice(String setName, String optionName ){
		findOptSet(setName).setOptChoice(optionName);
	}
	
	
	
	public synchronized void addOptset(String name) {
		
		OptionSet temp = new OptionSet(name);
		optSet.add(temp);
	}
	
	public synchronized void addOpt(String name, float price, int setIndex) {
		
		this.optSet.get(setIndex).setOpt(name, price);
		
	}

	/*
	 * Find option set by name
	 */
	public synchronized OptionSet findOptSet(String optionSetName){
	
		OptionSet temp = new OptionSet();
		for(int i=0;i<optSet.size();i++){
			temp = optSet.get(i);
			if( temp.getName().equals(optionSetName)){
				break;
			}
		
		}
		return temp;
	}
	
	/*
	 * Find option by option set name and option
	 */
	public synchronized OptionSet.Option findOpt(String optionSetName,String optionName){
		
		int i,j;
		for(i=0;i<optSet.size();i++){
			
			if(optSet.get(i).getName().equals(optionSetName)){
				break;
			}
		}

		for(j=0;j<optSet.get(i).getOpt().size();j++){
				if(optSet.get(i).getOpt().get(j).getName().equals(optionName)){
					break;
			}
			
		}
		return optSet.get(i).getOpt(j);
		
	}
	
	
	/*
	 * Delete Option set
	 */
	public synchronized void deleteOptionSet(String name){
		
		/*
		 * Only sleep thread 1
		 */
		String threadname = Thread.currentThread().getName();
		
		if( threadname.equals("Thread1") ){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		int i;
		for(i=0;i<optSet.size();i++){
			if( optSet.get(i).getName().equals(name)){
				break;
			}
		}
		optSet.remove(i);
		
		System.out.println();
		System.out.println("Option Set "+name+" is deleted by "+threadname+".");
		
	}
	
	/*
	 * Delete Option
	 */

	public synchronized void deleteOption(String optionSetName, String optionName){
		
		String threadname = Thread.currentThread().getName();
		
		int i,j;
		for(i=0;i<optSet.size();i++){
			
			if(optSet.get(i).getName().equals(optionSetName)){
				break;
			}
		}

		for(j=0;j<optSet.get(i).getOpt().size();j++){
				if(optSet.get(i).getOpt().get(j).getName().equals(optionName)){
					break;
			}
			
		}
		optSet.get(i).getOpt().remove(j);
		
		System.out.println();
		System.out.println("The option "+optionName+" in option set "+optionSetName+" is deleted by "+threadname+".");

	}
	
	/*
	 * Update
	 */
	public synchronized void updateOptionSetName (String oldName, String newName){
		findOptSet(oldName).setName(newName);
	}
	
	public synchronized void updateOption (String optionSetName, String optionName, float newPrice){
		findOpt(optionSetName, optionName).setPrice(newPrice);
		
	}

	/*
	 * Print
	 */
	public synchronized void print(){
		System.out.println("Name of the automobile: " + this.make +" "+ this.model);
		System.out.println("Base price of the automobile: "+ this.baseprice);
		System.out.println("-----------------------------------------------");
		for(int i=0;i<optSet.size();i++){
			
				System.out.println("  Option Set Name: "+optSet.get(i).getName());
				System.out.println("  Options:");
				for(int j=0;j<optSet.get(i).getOpt().size();j++){
						System.out.println();
						System.out.println("    Name: "+optSet.get(i).getOpt().get(j).getName());
						System.out.println("    Price: "+optSet.get(i).getOpt().get(j).getPrice());
				}
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			}
		}
}


