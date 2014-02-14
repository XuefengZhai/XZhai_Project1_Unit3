/*
 * EditOption thread class
 */
package scale;


import model.Automobile;

public class EditOption implements Runnable {
	
	private Automobile auto = new Automobile();
	private String optionSetname = null;
	private String optionSetName2 = null;
	private String optionName = null;
	
	public EditOption(Automobile auto, String optionSetname, String optionSetName2, String optionName){
		
		this.auto = auto;
		this.optionSetname = optionSetname;
		this.optionSetName2 = optionSetName2;
		this.optionName = optionName;
	}


	public void run(){
		auto.deleteOptionSet(optionSetname);
		auto.deleteOption(optionSetName2, optionName);
	}
	
	
}
