package main.java;


public class Test 
{
	public static void main(String[] args) 
	{
		System.out.println("Display players");
		StreamOperationsExercise.displayPlayers();
		System.out.println();
		
		System.out.println("Display players for country");
		StreamOperationsExercise.displayPlayersForCountry("india");
		System.out.println();
		
		System.out.println("Display players who have scored more than 5000");
		StreamOperationsExercise.getPlayerNames().forEach(System.out::println);
		System.out.println();
		
		System.out.println("Display average runs by country");
		System.out.println(StreamOperationsExercise.getAverageRunsByCountry("india"));
		System.out.println();
		
		System.out.println("Display player names sorted");
		StreamOperationsExercise.getPlayerNamesSorted().forEach(System.out::println);
		System.out.println();
		
		System.out.println("Display player and country");
		StreamOperationsExercise.getPlayerCountry().forEach((k, v) -> System.out.println(k + ": " + v));
		System.out.println();
		
		System.out.println("Display player with maximum runs");
		System.out.println(StreamOperationsExercise.getMaxRunsPlayer());
		System.out.println();
		
		System.out.println("Display found player");
		System.out.println(StreamOperationsExercise.findPlayer("jayawardene", "srilanka"));
		System.out.println();
		
		System.out.println("Display high scorer by country");
		System.out.println(StreamOperationsExercise.checkHighScorerByCountry("srilanka"));
		System.out.println();
	}
}
