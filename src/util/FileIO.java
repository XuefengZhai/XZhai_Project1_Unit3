/*
 * Xuefeng Zhai
 * xzhai@cmu.edu
 */
package util;
import model.*;
import java.io.*;
import java.util.Scanner;

import exception.*;

/*
 * Class for File IO
 */
public class FileIO {

	/*
	 * Read in a file and build object of automobile
	 */
	public Automobile buildAutoObject(String filename){
		
		/*
		 * Create new auto object for building
		 */
		Automobile model = new Automobile();
		
		/*
		 * Variables for save data
		 */
		String autoMake = null;
		String autoName = null;
		Float autoPrice = new Float(0);
		int optSetSize = 0;
		String optSetName = null;
		int optSize = 0;
		String optName = null;
		Float optPrice = new Float(0);
		
		
		System.out.println("Readin data from a file...");
		
		/*
		 * Read and parse the data in the file
		 */
		try{
			
			/*
			 * Custome Exception for empty file name
			 */
			try{
				if (filename == "" ){
					throw new CustomeException();
				}
			}catch(CustomeException e1){
				System.out.println("File name is Missing.Please enter the file name:");
				Scanner scanner = new Scanner(System.in);
				filename = scanner.nextLine();
			}
			
			FileReader file = new FileReader(filename);
			BufferedReader buff = new BufferedReader(file);

			buff.readLine();
			autoMake = buff.readLine();
			autoName = buff.readLine();
			
			
			buff.readLine();	
			autoPrice = Float.parseFloat(buff.readLine());
		    
			buff.readLine();
			optSetSize = Integer.parseInt(buff.readLine());
			model = new Automobile(autoMake,autoName,autoPrice);
			
			/*
			 * Read in option sets in the loop
			 */
			for(int i=0;i<optSetSize;i++){
				buff.readLine();
				buff.readLine();
				
				/*
				 * Custome Exception for empty option set name
				 */
				try {
					String temp = buff.readLine();
					if ( temp.isEmpty()){
						throw new CustomeException();
					}
					else{
						optSetName = temp;
					}
				}catch(CustomeException e2){
					System.out.println("The name of the No." + i+1 + " Option Set in missing ");
					System.out.println("Please enter an option name:");
					Scanner scanner = new Scanner(System.in);
					optSetName = scanner.nextLine();
				}
				
				
				buff.readLine();
				optSize = Integer.parseInt(buff.readLine());
				model.addOptset(optSetName);
				buff.readLine();
				/*
				 * Read in options in the loop
				 */
				
				for(int j=0;j<optSize;j++)
				{
					String temp2 = buff.readLine();
					
					/*
					 * Custome Exception for missing an option in the option set
					 */

					try {
						if (temp2.equals("--------------------------")){  
							throw new CustomeException();
						}
					}catch(CustomeException e4){
						System.out.println("Please check the file" + filename +", there is one option missing for the option set: "+optSetName);
						System.exit(1);
					}
					
					/*
					 * Custome Exception for missing option name
					 */

					try {
						String temp = buff.readLine();
						if ( temp.isEmpty()){
							throw new CustomeException();
						}
						else{
							optName = temp;
						}
					}catch(CustomeException e2){
						System.out.println("The name of the option in Option Set: "+optName+" in missing");
						System.out.println("Please enter new option name:");
						Scanner scanner = new Scanner(System.in);
						optName = scanner.nextLine();
					}
					
					buff.readLine();
					
					/*
					 * Custome Exception for mising option price
					 */

					try {
						String temp = buff.readLine();
						if ( temp.isEmpty()){
							throw new CustomeException();
						}
						else{
							optPrice = Float.parseFloat(temp);
						}
					}catch(CustomeException e2){
						System.out.println("The price for Option:"+optName+" in the Option Set "+optSetName+" is empty.");
						System.out.println("Please enter new price:");
						Scanner scanner = new Scanner(System.in);
						optPrice = Float.parseFloat(scanner.nextLine());
					}
					
					model.addOpt(optName, optPrice, i);
				}	
			}
	
			buff.close();
			
		}catch (IOException e) {
			System.out.println("Error " + e.toString()); }
		
		return model;
	}
	
	/*
	 * Serialize
	 */
	public void serializeAuto(Automobile model){
		try
		{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/serializeAuto.dat")); 
		out.writeObject(model);
		out.close();
		}
		catch(Exception e)
		{ 
			System.out.print("Error:"+e);
			System.exit(1); 
		}
	}
	
	/*
	 * Deserialize
	 */
	public Automobile deserializeAuto(String filename){
		Automobile model = new Automobile();
		try{
			ObjectInputStream in= new ObjectInputStream(new FileInputStream(filename));
			model = (Automobile) in.readObject();
			in.close();
		}
		catch(Exception e)
		{ 
			System.out.print("Error:"+e);
			System.exit(1); 
		}

		return model;
	}

	
	
}
