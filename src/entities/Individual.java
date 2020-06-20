package entities;

public class Individual extends TaxPayer {

	private Double healthExpenditures;

	public Individual() {
		super();
	}

	public Individual(String name, Double annualIncome, Double healthExpenditures) {
		super(name, annualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpense() {
		return healthExpenditures;
	}

	public void setHealthExpense(Double healthExpense) {
		this.healthExpenditures = healthExpense;
	}

	@Override
	public double calculateTax() {
		if (getAnnualIncome() < 2000.00) {
			return getAnnualIncome() * 0.15 - getHealthExpense() * 0.5;
		} else {
			return getAnnualIncome() * 0.25 - getHealthExpense() * 0.5;
		}
	}
}
