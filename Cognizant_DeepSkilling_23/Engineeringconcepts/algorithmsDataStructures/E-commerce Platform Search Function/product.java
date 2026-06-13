package algorithmsDataStructures;
class Product{
	int pId;
	String pName;
	String category;
	Product(int pId,String pName,String category){
		this.pId=pId;
		this.pName=pName;
		this.category=category;
	}
	void display() {
		System.out.println(pId+" - "+pName+" - "+category);
	}
}