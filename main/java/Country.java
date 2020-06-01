package main.java;

public class Country 
{
	private String countryId;
	
	private String CountryName;

	public Country(String countryId, String countryName) {
		super();
		this.countryId = countryId;
		CountryName = countryName;
	}

	public String getCountryId() {
		return countryId;
	}

	public String getCountryName() {
		return CountryName;
	}
}
