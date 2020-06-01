package main.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamOperationsExercise 
{
	static List<Player> playerList = new ArrayList<>();
	
	static
	{
		Country country1 = new Country("100", "india");
		Country country2 = new Country("101", "england");
		Country country3 = new Country("102", "srilanka");
		Country country4 = new Country("103", "pakistan");
		Country country5 = new Country("104", "west indies");
		
		Player player1 = new Player("sachin", 400, 20000, 200, country1);
		Player player2 = new Player("kohli", 250, 10000, 83, country1);
		Player player3 = new Player("butler", 150, 6000, 100, country2);
		Player player4 = new Player("jayawardene", 300, 12000, 150, country3);
		Player player5 = new Player("aktar", 200, 4000, 20, country4);
		Player player6 = new Player("lara", 390, 16000, 160, country5);
		
		playerList.add(player1);
		playerList.add(player2);
		playerList.add(player3);
		playerList.add(player4);
		playerList.add(player5);
		playerList.add(player6);
	}
	
	public static void displayPlayers()
	{
		playerList.stream().forEach(player -> System.out.println(player.getPlayerName()));
	}
	
	public static void displayPlayersForCountry(String countryName)
	{
		Predicate<Player> countryPredicate = player -> {
			Country country = player.getCountry();
			return country.getCountryName().equals(countryName);
		};
		
		playerList.stream().filter(countryPredicate.and(player -> player.getHighestScore()>100)).forEach(player -> System.out.println(player.getPlayerName()));
	}
	
	public static LinkedList<String> getPlayerNames()
	{
		return playerList.stream().filter(player -> player.getRuns()>5000).map(player -> player.getPlayerName()).sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(LinkedList::new));
	}
	
	public static double getAverageRunsByCountry(String countryName)
	{
		return  playerList.stream().filter(player -> player.getCountry().getCountryName().equals(countryName)).mapToInt(Player::getRuns).average().getAsDouble();
	}
	
	public static List<String> getPlayerNamesSorted() 
	{
		Function<Player, String> function = player -> {
			Country country = player.getCountry();
			return country.getCountryName();
		};
		
		return playerList.stream().sorted(Comparator.comparing(function).thenComparing(Player::getMatchesPlayed).reversed()).map(player -> player.getPlayerName()).collect(Collectors.toList());
	}
	
	public static Map<String, String> getPlayerCountry()
	{		
		return playerList.stream().filter(player -> player.getMatchesPlayed()>200).collect(Collectors.toMap(Player::getPlayerName, player -> player.getCountry().getCountryName()));
	}
	
	public static String getMaxRunsPlayer()
	{
		return playerList.stream().max(Comparator.comparing(Player::getRuns)).get().getPlayerName();
	}
	
	public static Player findPlayer(String playerName, String countryName)
	{
		return playerList.stream().filter(player -> player.getCountry().getCountryName().equalsIgnoreCase(countryName) && player.getPlayerName().equalsIgnoreCase(playerName)).findFirst().get();
	}
	
	public static boolean checkHighScorerByCountry(String country)
	{
		return playerList.stream().anyMatch(player -> player.getCountry().getCountryName().equalsIgnoreCase(country) && player.getRuns()>10000);
	}
}
