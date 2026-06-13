package algorithmsDataStructures;
import java.util.*;

public class EcommerceSearch {
	
	static Product LinearSearch(Product[] products,int id) {
		for(int i=0;i<products.length;i++) {
			if(products[i].pId==id) {
				return products[i];
			}
		}
		return null;
	}
	
	static Product binarySearch(Product[] products,int id) {
		int low=0;
		int high=products.length-1;
		while(low<high) {
			int mid=low+(high-low)/2;
			if(products[mid].pId==id) {
				return products[mid];
			}else if(products[mid].pId<id) {
				low=mid+1;
			}else {
				high=mid-1;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product[] products= {
				new Product(105,"Laptop","Electronics"),
	            new Product(101,"Shoes","Fashion"),
	            new Product(103,"Mobile","Electronics"),
	            new Product(102,"Watch","Accessories"),
	            new Product(104,"Bag","Travel")
		};
		System.out.println("Linear Search Result: ");
		Product r1=LinearSearch(products,103);
		if(r1!=null) {
			r1.display();
		}else {
			System.out.println("Product not found");
		}
		Arrays.sort(products,Comparator.comparingInt(p->p.pId));
		System.out.println("\nBinary Search Result: ");
		Product r2=binarySearch(products,103);
		if(r2!=null) {
			r2.display();
		}else {
			System.out.println("Product not found");
		}

	}

}
