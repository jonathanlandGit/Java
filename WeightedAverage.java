package WeightedAverage;

/*
 * Jonathan Land 


 * This program computes the weighted average of class scores. I have another program that 
 * integrates a lot of the duplicated code into one method. This program does have some duplicated code.
 *
 * What needs to be added:
 * 1. A gui to make it look better
 * 2. Switch statements to choose when to apply weighted avg at any given time
 */

import java.util.ArrayList;
import java.util.Scanner;

public class WeightedAverage 
{
	public static void main(String[] args) 
	{
		int n = 0;
		double o = 0;
		int sum = 0;

		double examAverage;
		double examWeightedAvg;

		Scanner in = new Scanner(System.in);

		System.out.print("Enter no. of tests you want in array: ");

		n = in.nextInt();

		int a[] = new int[n];

		System.out.println("Enter these values: ");

		for (int i = 0; i < n; i++) 
		{
			a[i] = in.nextInt();
			sum = sum + a[i];
		}

		System.out.println("Sum: " + sum);

		examAverage = (double) sum / n;

		System.out.println("Average: " + examAverage);

		System.out.println("Enter the weighted percentage: ");

		o = in.nextDouble();

		examWeightedAvg = examAverage * o;

		System.out.println();

		System.out.println("Your weighted average for exams is: " + examWeightedAvg);

		////////////// HW/////////////

		int p = 0;
		double q = 0;
		int hwSum = 0;

		double hwAverage;
		double hwWeightedAvg;

		double weightedSum = 0;

		Scanner in2 = new Scanner(System.in);

		System.out.print("Enter no. of HWs you want in array: ");

		p = in2.nextInt();

		int b[] = new int[p];

		System.out.print("Enter these values: ");

		for (int i = 0; i < p; i++) 
		{
			b[i] = in.nextInt();
			hwSum = hwSum + b[i];
		}

		System.out.println("Sum: " + hwSum);

		hwAverage = (double) hwSum / p;

		System.out.println("Average: " + hwAverage);
		System.out.println();

		System.out.println("Enter the weighted percentage: ");

		q = in.nextDouble();

		hwWeightedAvg = hwAverage * q;
		System.out.println();

		System.out.println("Your weighted average for HW is: " + hwWeightedAvg);
		System.out.println();

		weightedSum = examWeightedAvg + hwWeightedAvg;

		System.out.println("Your weighted average overall is:" + weightedSum);

		/////////////////////////Final//////////////

		double r = 0;
		double s = 0;
		int finalExamSum = 0;
		double finalExamWeightedAvg;

		double allWeightedSum = 0;

		Scanner in3 = new Scanner(System.in);

		System.out.print("Enter your final exam grade: ");

		n = in3.nextInt();

		System.out.println("Enter the weighted percentage of the final exam: ");

		r = in3.nextDouble();

		finalExamWeightedAvg = n * r;

		System.out.println("Your weighted average for the final exam is:" + finalExamWeightedAvg);

		allWeightedSum = finalExamWeightedAvg + hwWeightedAvg + examWeightedAvg;

		System.out.println("Your overall grade is: " + allWeightedSum);

		/*
		 * System.out.println("Please enter weighted percentage: "); double
		 * weightedPerc = in.nextDouble();
		 * 
		 * if (weightedVal == -1 || weightedPerc == -1 ) { break; }
		 * 
		 * double grade = 0; double sumNums = 0;
		 * 
		 * if (weightedVal > -1) { sumNums = weightedVal; grade = weightedVal *
		 * weightedPerc; System.out.println("The sum is: " + sumNums);
		 * 
		 * }
		 * 
		 * System.out.println("This counts " + grade +
		 * " points toward your grade"); System.out.println();
		 * 
		 * System.out.println("Please enter another value: ");
		 */
	}
}
