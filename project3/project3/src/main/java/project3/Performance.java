package project3;

public class Performance {
	private String name;
	private String club;
	private int year;
	private int fee;
	private int years;
	private int titles;
	private int league;
	private int champion;
	private int europa;
	private double performance;
	private double performancePerYear;
	
	public Performance(String pName, String pClub, int pYear, int pFee, int pYears, int pTitles, int pLeague, int pChampion, int pEuropa, double pPerformance, double perYear) {
		name = pName;
		club = pClub;
		year = pYear;
		fee = pFee;
		years = pYears;
		titles = pTitles;
		league = pLeague;
		champion = pChampion;
		europa = pEuropa;
		performance = pPerformance;
		performancePerYear = perYear;
	}
	
	public String getName() {
		return name;
	}
	
	public String getClub() {
		return club;
	}
	
	public int getYear() {
		return year;
	}

	public int getFee() {
		return fee;
	}

	public int getYears() {
		return years;
	}
	
	public int getTitles() {
		return titles;
	}
	
	public int getLeague() {
		return league;
	}

	public int getChampion() {
		return champion;
	}

	public int getEuropa() {
		return europa;
	}

	public double getPerformance() {
		return performance;
	}

	public double getPerformancePerYear() {
		return performancePerYear;
	}
}
