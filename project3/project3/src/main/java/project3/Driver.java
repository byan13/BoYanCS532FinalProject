package project3;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import java.util.Scanner;

import java.util.ArrayList;

import org.bson.Document;

public class Driver {
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("project3");
		Analysis analysis = new Analysis();
		
		MongoCollection<Document> playerCollection = database.getCollection("players");
		FindIterable<Document> players = playerCollection.find();
		for(Document playerDocument: players) {
			String name = playerDocument.get("name", String.class);
			String clubName = playerDocument.get("club", String.class);
			double year = playerDocument.get("year", Double.class);
			double fee = playerDocument.get("fee", Double.class);
			
			Player player = new Player(name, year, fee);
			analysis.addPlayer(name, player);
			Club club = analysis.getClub(clubName);
			if(null == club) {
				club = new Club(clubName);
				analysis.addClub(clubName, club);
			}
			player.join(club);
			club.buyPlayers(player);
		}
		
		MongoCollection<Document> clubCollection = database.getCollection("clubs");
		FindIterable<Document> clubs = clubCollection.find();
		for(Document clubDocument: clubs) {
			String name = clubDocument.get("name", String.class);
			String country = clubDocument.get("country", String.class);
			double investments = clubDocument.get("transferInvestments", Double.class);
			double value = clubDocument.get("value", Double.class);
			double revenue = clubDocument.get("revenue", Double.class);
			ArrayList<Double> league = (ArrayList<Double>)clubDocument.get("league");
			ArrayList<Double> champion = (ArrayList<Double>)clubDocument.get("UEFAChampionsLeague");
			ArrayList<Double> europa = (ArrayList<Double>)clubDocument.get("UEFAEuropaLeague");
			
			Club club = analysis.getClub(name);
			if(null == club) {
				club = new Club(name);
				analysis.addClub(name, club);
			}
			club.setClub(country, investments, value, revenue, league, champion, europa);	
		}
		
		System.out.println("Welcome to the analysis system!");
		System.out.println("These system can analyze top european football clubs' performance on the transfer market.\n");
		System.out.println("Supported basic queries: ");
		System.out.println("1: Club with most transfer investment.");
		System.out.println("2: Club won most titles.");
		System.out.println("3: Player with most expensive transfer fee.");
		System.out.println("Supported sohisticated queries: ");
		System.out.println("4: Analysis on transfer return.");
		System.out.println("5: Analysis on Europian football.");
		System.out.println("Please enter the id of supported queries and press enter to start query or press q to quit: ");
		
		Scanner input = new Scanner(System.in);
		String in = input.nextLine();
		while(!(in.equals("q") || in.equals("1") || in.equals("2") || in.equals("3") || in.equals("4") || in.equals("5"))) {
			System.out.println("Please enter the id of supported queries, note you can only input 1, 2, 3, 4, 5 or q to quit: ");
			in = input.nextLine();
		}
		while(!in.equals("q")) {
			if(in.equals("1")) {
				System.out.println(analysis.investmentsAnalysis());
			}
			if(in.equals("2")) {
				System.out.println(analysis.titleAnalysis());
			}
			if(in.equals("3")) {
				System.out.println(analysis.playerValueAnalysis());
			}
			if(in.equals("4")) {
				System.out.println(analysis.playerReturnAnalysis());
			}
			if(in.equals("5")) {
				System.out.println(analysis.trendAnalysis());
			}
			System.out.println("Please enter the id of supported queries and press enter to start query or press q to quit: ");
			in = input.nextLine();
		}
		mongoClient.close();
		System.out.println("Thank you for using!");
		System.exit(0);
	}
}
