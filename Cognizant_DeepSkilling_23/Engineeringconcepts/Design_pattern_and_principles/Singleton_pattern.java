//Exercise 1: Implementing the Singleton Pattern
package designpattern;

class Logger{
	private static Logger instance;
	private Logger() {
		
	}
	public static Logger getInstance() {
		if(instance==null) {
			instance = new Logger();
		}
		return instance;
		
	}
}
//test class
public class Singleton_pattern {

	public static void main(String[] args) {
		Logger l1=Logger.getInstance();
		Logger l2=Logger.getInstance();
        Logger l3=Logger.getInstance();
		if(l1==l2&&l1==l3) {
			System.out.println("Only one instance is created");
		}
	}

}