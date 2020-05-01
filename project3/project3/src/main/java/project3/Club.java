package project3;

import java.util.ArrayList;
import java.util.List;

public class Club {
	private String name;
	private String country;
	private double investments;
	private double value;
	private double revenue;
	private List<Double> leagueTitle;
	private List<Double> championsLeagueTitle;
	private List<Double> europaLeagueTitle;
	private List<Player> players;
	
	public Club(String pName) {
		name = pName;
		country = "";
		investments = 0;
		value = 0;
		revenue = 0;
		leagueTitle = new ArrayList<Double>();
		championsLeagueTitle = new ArrayList<Double>();
		europaLeagueTitle = new ArrayList<Double>();
		players = new ArrayList<Player>();
	}
	
	public void buyPlayers(Player player) {
		players.add(player);
	}
	
	public String getName() {
		return name;
	}
	
	public int getChampionTitles() {
		int champion = 0;
		if(championsLeagueTitle != null) {
			champion = championsLeagueTitle.size();
		}
		return champion;
	}
	
	public int getUEFATitles() {
		
		int europa = 0;
		
		if(europaLeagueTitle != null) {
			europa = europaLeagueTitle.size();
		}
		return getChampionTitles() + europa;
	}
	
	public int getNumberOfTitles() {
		int league = 0;
		if(leagueTitle != null) {
			league = leagueTitle.size();
		}
		return league + getUEFATitles();
	}
	
	public int getNumberOfPlayers() {
		int counter = 0;
		if(players != null) {
			counter = players.size();
		}
		return counter;
	}
	
	public void setClub(String pCountry, double pInvestments, double pValue, double pRevenue, ArrayList<Double> league, ArrayList<Double> champion, ArrayList<Double> europa) {
		country = pCountry;
		investments = pInvestments;
		value = pValue;
		revenue = pRevenue;
		leagueTitle = league;
		championsLeagueTitle = champion;
		europaLeagueTitle = europa;
	}
	
	public double getInvestments() {
		return investments;
	}
	
	public List<Double> getLeagues() {
		return leagueTitle;
	}
	
	public List<Double> getChampions() {
		return championsLeagueTitle;
	}
	
	public List<Double> getEuropas() {
		return europaLeagueTitle;
	}
	
	public double[] getSuccess() {
		double[] result = new double[3];
		double financePerformance = value / revenue;
		double transferPerformance = 0;
		double performance = (1.5 * (getNumberOfTitles() - getUEFATitles()) + 2 * getChampionTitles() + (getUEFATitles() - getChampionTitles())) / investments;
		int count = 0;
		
		if(players != null) {
			for(Player player: players) {
				transferPerformance = transferPerformance + player.getReturn().getPerformance();
				count = count + 1;
			}
		}
		
		if(count >0) {
			transferPerformance = transferPerformance / count;
		}
		
		result[0] = financePerformance;
		result[1] = transferPerformance;
		result[2] = performance;
		
		return result;
	}
	
	public String getCountry() {
		return country;
	}
	
	@Override
	public String toString() {
		return String.format("Club:\nName: %s\nCountry: %s\nInvestment: %d million dollars\nValue: %d million dollars\nRevenue: %d million dollars\nNumber of titles earned: %d\nPlayers: \n%s", name, country, Math.round(investments), Math.round(value), Math.round(revenue), getNumberOfTitles(), players.toString());
	}
	
}
