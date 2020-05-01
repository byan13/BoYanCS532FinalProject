package project3;

import java.util.List;

public class Player {
	private String name;
	private double transferFee;
	private double startYear;
	private Club club;
	
	public Player(String pName, double pYear, double pFee) {
		name = pName;
		transferFee = pFee;
		startYear = pYear;
		club = null;
	}
	
	public void join(Club pClub) {
		club = pClub;
	}
	
	public String getName() {
		return name;
	}
	
	public double getFee() {
		return transferFee;
	}
	
	public String getClubName() {
		return club.getName();
	}
	
	public Performance getReturn() {
		int years = (int)(2019 - Math.round(startYear));
		double performance = 0;
		double perYear = 0;
		List<Double> leagueTitle = club.getLeagues();
		List<Double> championsLeagueTitle = club.getChampions();
		List<Double> europaLeagueTitle = club.getEuropas();
		int league = 0;
		int champion = 0;
		int europa = 0;
		if(leagueTitle != null) {
			for(double year: leagueTitle) {
				if(Math.round(year) > Math.round(startYear)) {
					league = league + 1;
				}
			}
		}
		if(championsLeagueTitle != null) {
			for(double year: championsLeagueTitle) {
				if(Math.round(year) > Math.round(startYear)) {
					champion = champion + 1;
				}
			}
		}
		if(europaLeagueTitle != null) {
			for(double year: europaLeagueTitle) {
				if(Math.round(year) > Math.round(startYear)) {
					europa = europa + 1;
				}
			}
		}
		performance = (1.5 * league + 2 * champion + europa) / transferFee;
		perYear = performance / years;
		
		return new Performance(name, getClubName(), (int)Math.round(startYear), (int)Math.round(transferFee), years, league + champion + europa, league, champion, europa, performance, perYear);
	}
	
	@Override
	public String toString() {
		return String.format("Player:\nName: %s\nClub joined: %s\nYear joined: %d\nTransfer fee: %d million dollars", name, getClubName(), Math.round(startYear), Math.round(transferFee));
	}
}
