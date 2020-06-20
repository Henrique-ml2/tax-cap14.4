package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Tax payer #" + i + " data: ");
			System.out.print("Individual or Company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Annual income: ");
			double annualIncome = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Health expanditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, annualIncome, healthExpenditures));
			} else {
				System.out.print("Number of employees: ");
				int employeesNumber = sc.nextInt();
				list.add(new Company(name, annualIncome, employeesNumber));
			}
		}

		double sum = 0;
		System.out.println();
		System.out.println("TAXES PAID:");
		for (TaxPayer contrib : list) {
			System.out.println(contrib.getName() + ": $" + String.format("%.2f", contrib.calculateTax()));
			sum += contrib.calculateTax();
		}
		
		System.out.println();
		System.out.printf("TOTAL TAXES: $%.2f", sum);

		sc.close();
	}

}
