package main.java;

public class Player 
{
	private String playerName;
	
	private int matchesPlayed;
	
	private int runs;
	
	private int highestScore;
	
	private Country country;

	public Player(String playerName, int matchesPlayed, int runs, int highestScore, Country country) 
	{
		super();
		this.playerName = playerName;
		this.matchesPlayed = matchesPlayed;
		this.runs = runs;
		this.highestScore = highestScore;
		this.country = country;
	}

	public String getPlayerName() {
		return playerName;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public int getRuns() {
		return runs;
	}

	public int getHighestScore() {
		return highestScore;
	}

	public Country getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", matchesPlayed=" + matchesPlayed + ", runs=" + runs
				+ ", highestScore=" + highestScore + ", country=" + country.getCountryName() + "]";
	}
}
