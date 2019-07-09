public class ImpToOop {
	public static void main(String[] args) {
		int mazdaHorsepower = 181;
		int subaruHorsepower = 205;
		double mazdaWeight = 1112.66;
		double subaruWeight = 1269.15;

		System.out.println("The Mazda MX-5 has " + mazdaHorsepower
			+ "hp and weighs " + mazdaWeight + "kg.");
		System.out.println("The Subaru BRZ has " + subaruHorsepower
			+ "hp and weighs " + subaruWeight + "kg.");

		double mazdaHpToWeightRatio = mazdaHorsepower/mazdaWeight;
		double subaruHpToWeightRatio = subaruHorsepower/subaruWeight;

		String winner;
		if (mazdaHpToWeightRatio > subaruHpToWeightRatio) {
			winner = "Mazda";
		} else {
			winner = "Subaru";
		}
		System.out.println("In a race, the " + winner + " will probably win.");
	}
}
