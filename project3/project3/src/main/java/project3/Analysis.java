package project3;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Analysis {
	private Map<String, Club> clubs;
	private Map<String, Player> players;
	
	public Analysis() {
		clubs = new HashMap<String, Club>();
		players = new HashMap<String, Player>();
	}
	
	public void addClub(String clubName, Club club) {
		if(!clubs.containsKey(clubName)) {
			clubs.put(clubName, club);
		}
	}
	
	public void addPlayer(String playerName, Player player) {
		if(!players.containsKey(playerName)) {
			players.put(playerName, player);
		}
	}
	
	public Club getClub(String name) {
		return clubs.get(name);
	}
	
	public String investmentsAnalysis() {
		String most = "";
		double mostFee = 0;
		for(Entry<String, Club> entry: clubs.entrySet()) {
			String name = entry.getKey();
			Club club = entry.getValue();
			double fee = club.getInvestments();
			if(fee > mostFee) {
				most = name;
				mostFee = fee;
			}
		}
		return String.format("******\n=> The football club with most total transfer investment fee from 2010 to 2019 is %s with a total fee of %d millin dollars.\n******", most, Math.round(mostFee));
	}
	
	public String titleAnalysis() {
		String most = "";
		int mostTitles = 0;
		for(Entry<String, Club> entry: clubs.entrySet()) {
			String name = entry.getKey();
			Club club = entry.getValue();
			int titles = club.getNumberOfTitles();
			if(titles > mostTitles) {
				most = name;
				mostTitles = titles;
			}
		}
		return String.format("******\n=> The football club which earned most number of titles from 2010 to 2019 is %s with a total number of %d titles.\n******", most, mostTitles);
	}
	
	public String playerValueAnalysis() {
		String most = "";
		String club = "";
		double mostFee = 0;
		for(Entry<String, Player> entry: players.entrySet()) {
			String name = entry.getKey();
			Player player = entry.getValue();
			double fee = player.getFee();
			if(fee > mostFee) {
				most = name;
				mostFee = fee;
				club = player.getClubName();
			}
		}
		return String.format("******\n=> The player with most expensive transfer fee from 2010 to 2019 is %s who was transfered to %s with a total fee of %d millin dollars.\n******", most, club, Math.round(mostFee));
	}
	
	public String playerReturnAnalysis() {
		Performance p = null;
		Performance pY = null;
		Performance pT = null;
		double per = 0;
		double perY = 0;
		int t = 0;
		int y = 10;
		
		for(Entry<String, Player> entry: players.entrySet()) {
			Player player = entry.getValue();
			double performance = player.getReturn().getPerformance();
			double performancePerYear = player.getReturn().getPerformancePerYear();
			int titles = player.getReturn().getTitles();
			int years = player.getReturn().getYears();
			if(performance > per) {
				per = performance;
				p = player.getReturn();
			}
			if(performancePerYear > perY) {
				perY = performancePerYear;
				pY = player.getReturn();
			}
			if(titles >= t) {
				if(titles == t) {
					if(years <= y) {
						t = titles;
						y = years;
						pT = player.getReturn();
					}
				} else {
					t = titles;
					y = years;
					pT = player.getReturn();
				}
			}
		}
		
		String first = String.format("******\n=> The transfer with highest competition return on transfer investment from 2010 to 2019 is %s.\nHe transfered to %s with a total fee of %d millin dollars in %d.\n", p.getName(), p.getClub(), p.getFee(), p.getYear());
		String second =String.format("During the %d years of play, %s has won %d titles in total.\n", p.getYears(), p.getName(), p.getTitles());
		String third = String.format("=> The player with best competition return on transfer investment per year after transfer is %s of %s.\nHe can win %2f titles per year with only %d million dollars of transfer fee.\n", pY.getName(), pY.getClub(), ((double)(pY.getTitles())) / pY.getYears(), pY.getFee());
		String fourth = String.format("=> The player who won most titles after transfer is %s of %s.\n%d titles are won by him in %d years.", pT.getName(), pT.getClub(), t, pT.getYears());
		
		return first + second + third + fourth + "\n******";
	}
	
	public String trendAnalysis() {
		String c1 = "";
		String c2 = "";
		String c3 = "";
		String l = "";
		double p1 = 0;
		double p2 = 0;
		double p3 = 0;
		int t = 0;
		Map<String, Integer> leagues = new HashMap<String, Integer>();
		
		for(Entry<String, Club> entry: clubs.entrySet()) {
			String name = entry.getKey();
			Club club = entry.getValue();
			if(!leagues.containsKey(club.getCountry())) {
				leagues.put(club.getCountry(), 0);
			}
			leagues.put(club.getCountry(), leagues.get(club.getCountry()) + 1);
			double fP = club.getSuccess()[0];
			double tP = club.getSuccess()[1];
			double oP = club.getSuccess()[2];
			if(fP > p1) {
				c1 = name;
				p1 = fP;
			}
			if(tP > p2) {
				c2 = name;
				p2 = tP;
			}
			if(oP > p3) {
				c3 = name;
				p3 = oP;
			}
		}
		
		for(Entry<String, Integer> entry: leagues.entrySet()) {
			String name = entry.getKey();
			int count= entry.getValue();
			if(count > t) {
				t = count;
				l = name;
			}
		}
		
		String first = String.format("******\n=> The most valuable club is %s.\n", c1);
		String second = String.format("=> The club with best transfer investment performance is %s.\n", c2);
		String third = String.format("The best european football league is %s, which has won %d UEFA level titles.\n", l, t);
		String fourth = String.format("The club with overall best competition performance from 2010 to 2019 is %s.", c3);
		
		return first + second + third + fourth + "\n******";
	}
	
	@Override
	public String toString() {
		return clubs.toString();
	}
}
