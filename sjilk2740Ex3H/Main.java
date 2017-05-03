package sjilk2740Ex3H;

import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double [] dblRainfall = {
				1.2, 2.7, 2.2, 3.1, 2.9, 5.1};
		
		String [] strRainfall = {
				"1.2", "2.7", "2.2", "3.1", "2.9", "5.1"};
		DecimalFormat fmt = new DecimalFormat("#0.0");
		
		Rainfall rainfall = new Rainfall(dblRainfall);
		System.out.println("Rainfall total: " + fmt.format(rainfall.getTotal()));
		System.out.println("Rainfall average: " + fmt.format(rainfall.getAverage()));
		System.out.println("Rainfall highest: " + fmt.format(rainfall.getHighest()));
		System.out.println("Rainfall lowest: " + fmt.format(rainfall.getLowest()));
		System.out.println();
		
		rainfall = new Rainfall(strRainfall);
		System.out.println("Rainfall total: " + fmt.format(rainfall.getTotal()));
		System.out.println("Rainfall average: " + fmt.format(rainfall.getAverage()));
		System.out.println("Rainfall highest: " + fmt.format(rainfall.getHighest()));
		System.out.println("Rainfall lowest: " + fmt.format(rainfall.getLowest()));
		System.out.println();
		

	}

}
