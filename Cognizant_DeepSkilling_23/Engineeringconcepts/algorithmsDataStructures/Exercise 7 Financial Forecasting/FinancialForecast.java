package financial_Forecasting;
import java.util.*;
public class FinancialForecast {
	static double calFutureValue(double currentvalue,double growthrate,int years) {
		if(years==0) {
			return currentvalue;
		}
		return calFutureValue(currentvalue,growthrate,years-1) * (1+growthrate);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter current value: ");
		double currentvalue=sc.nextDouble();
		System.out.println("Enter growth value: ");
		double growthrate=sc.nextDouble()/100;
		System.out.println("Enter number of years: ");
		int years=sc.nextInt();
		double futurevalue=calFutureValue(currentvalue,growthrate,years);
		System.out.printf("Predicted Future Value: %.2f",futurevalue);
		
	}

}
//Better Optimized Approach - To Save Memory

//Static double calFutureValueIterative(double currentvalue,double growthrate,int years) {
//	for(int i=1;i<=years;i++){
//  currentvalue=currentvalue*(1+growthrate);
//	}
//	return currentvalue;
//}
