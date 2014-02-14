package exception;
/*
 * Xuefeng Zhai
 * xzhai@cmu.edu
 *A customeException class to handle an exception
 */

public class CustomeException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
    public CustomeException(){
    }
    
    public CustomeException(String msg){
        super(msg);
    }
}


