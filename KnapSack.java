import java.util.*;

public class KnapSack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int capacity, size, temp;
        double total = 0;
        
        System.out.println("Enter the no of Objects that are in the knapSack :");
        size = sc.nextInt();

        System.out.println("Enter the capacity of the KnapSack :");
        capacity = sc.nextInt();

        int [] noOfObj = new int[size];
        int [] profit = new int[size];
        int [] weight = new int[size];
        double [] ratio = new double[size];
        
        System.out.println("Enter the elements in the array:");

        for(int i=0; i<noOfObj.length; i++) {
            noOfObj[i] = sc.nextInt();
            profit[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }

        System.out.println("Finding the Ratio for profit and weight :");
        
        for(int i=0; i<noOfObj.length; i++) {
            ratio[i] = (double)profit[i] / weight[i];
        }

        for(int i=0; i<size; i++) {
            for(int j=i+1; j<size; j++) {
                if(ratio[i] < ratio[j]) {
                    temp = noOfObj[j];
                    noOfObj[j] = noOfObj[i];
                    noOfObj[i] = temp;

                    temp = weight[j];
                    weight[j] = weight[i];
                    weight[i] = temp;

                    temp = profit[j];
                    profit[j] = profit[i];
                    profit[i] = temp;

                    double tempRatio = ratio[j];
                    ratio[j] = ratio[i];
                    ratio[i] = tempRatio;
                }
            }
        }

        System.out.println("Greedy method : ");

        for(int i=0; i<noOfObj.length; i++) {
            if(weight[i] > capacity) {
                total += ((double)profit[i]/weight[i]) * capacity;
                break;
            } else {
                total += profit[i];
                capacity -= weight[i];
            }
        }
        System.out.println("The maximum profit for the KnapSack after the Greedy Method is : " + total);
    }
}

