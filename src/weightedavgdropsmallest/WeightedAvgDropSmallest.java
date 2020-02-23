/* The program prompts the user for five to ten numbers all on one line, 
separated by spaces, calculates the weighted average of all those numbers except
the lowest n numbers, where n and the weight are also given by the user, and 
displays all the numbers, the weight, the number of lowest numbers dropped, and
the calculated average to the user.

The program uses methods to:

1. Get the numbers used to calculate the average
2. Get the number of lowest numbers to drop before calculating the average
3. Get the weight, a double greater than 0 and less than or equal to 1
4. Calculate the weighted average of the numbers (except the lowest n numbers)
entered by the user
5. Print the results

The first method should take no arguments and return an array list of doubles.

The second method should take no arguments and return a single integer, the 
number of the lowest numbers to drop before calculating the average.

The third method should take no arguments and return a double (the weight)

The fourth method should take three arguments: an array list of numbers 
(the return value of the first method above); an integer (the number of smallest
items to drop before calculating the average); and a double (the weight). This 
method should return a double (the weighted average of all the numbers except
the lowest n values).

The fifth method should take four arguments: an array list of numbers (the 
return value of the first method above); an integer (the number of smallest 
numbers to drop before calculating the average); a double (the weight); and a 
double (the weighted average returned from the fourth method above). This method
should have no return value.

For example:

If the user gives these numbers for calculating the average:

40 60 80 100 20

and the user gives the number 2 to indicate how many of the lowest values should
be dropped before calculating the average, and gives a weight of 0.5, then the 
program should give as output:

The weighted average of the numbers is 40.0, when using the data 40.0, 60.0, 
80.0, 100.0, 20.0, where 0.5 is the weight used, and the average is computed 
after dropping the lowest 2 values.
 */
package weightedavgdropsmallest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WeightedAvgDropSmallest {

     public static ArrayList<Double> userInput(){
       Scanner input = new Scanner(System.in);
       System.out.println("Enter 5 to 10 numbers, separated by spaces");
       String[] numbers = input.nextLine().split(" ");
       ArrayList<Double> arr = new ArrayList<Double>();
       for(int i = 0; i < numbers.length; i++){
           arr.add(Double.parseDouble(numbers[i]));
       }
       return arr;      
   }
   public static int numberDrop(){
       Scanner input = new Scanner(System.in);
       System.out.print("Enter numbers to drop: ");
       int numbers = input.nextInt();
       return numbers;
   }
   public static double weightInput(){
       Scanner input = new Scanner(System.in);
       System.out.print("Enter the weight (0.0 - 1.0): ");
       double numbers = input.nextDouble();
       return numbers;
   }
   public static double weightedMean(ArrayList<Double> arr, int drop, double weight) {
       Collections.sort(arr, Collections.reverseOrder());
       double avg = 0;
       for(int i = 0; i < arr.size() - drop; i++){
           avg += weight * arr.get(i);
       }
       return avg / (arr.size() - drop);
   }
  
   public static void print(ArrayList<Double> arr, int drop, double weight, double avg){
       System.out.print("Given the numbers ");
       for(int i = 0; i < arr.size(); i++){
           System.out.printf("%.2f,", arr.get(i));
           if(i == arr.size() - 2) System.out.printf(" and ");
       }
       System.out.print("and using a weight of " + weight + ",\n"
               + "the weighted average of all the numbers except the lowest " + drop + " numbers is ");
      
       System.out.printf("%.2f", avg);      
   }
   public static void main(String args[]){
       ArrayList<Double> arrayList = userInput();
       int drop = numberDrop();
       double weight = weightInput();
       double mean = weightedMean(arrayList, drop, weight);
       print(arrayList, drop, weight, mean);
   }
}