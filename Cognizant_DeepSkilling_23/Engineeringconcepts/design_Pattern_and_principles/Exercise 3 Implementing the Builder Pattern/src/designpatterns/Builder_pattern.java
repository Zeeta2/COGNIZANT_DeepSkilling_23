package designpatterns;

public class Builder_pattern {
	public static void main(String[] args) {
		Computer gamingPC =new Computer.Builder()
				.setcpu("Intel i9")
				.setram("32GB")
				.setstorage("1TB")
				.build();
		Computer officePC =new Computer.Builder()
				.setcpu("Intel i5")
				.setram("8GB")
				.setstorage("256GB")
				.build();
		gamingPC.display();
		officePC.display();
	}
}
