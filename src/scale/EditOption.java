package scale;


import model.Automobile;

public class EditOption implements Runnable {
	
	Automobile auto = new Automobile();
	String optionSetname = null;
	String optionSetName2 = null;
	String optionName = null;
	
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
