package nl.hva.msi.eventplanner.data.event.model;

import com.google.gson.annotations.SerializedName;

public class VenuesItem{

	@SerializedName("country")
	private Country country;

	@SerializedName("address")
	private Address address;

	@SerializedName("test")
	private boolean test;

	@SerializedName("city")
	private City city;

	@SerializedName("_links")
	private Links links;

	@SerializedName("timezone")
	private String timezone;

	@SerializedName("upcomingEvents")
	private UpcomingEvents upcomingEvents;

	@SerializedName("postalCode")
	private String postalCode;

	@SerializedName("type")
	private String type;

	@SerializedName("locale")
	private String locale;

	@SerializedName("url")
	private String url;

	@SerializedName("location")
	private Location location;

	@SerializedName("id")
	private String id;

	public void setCountry(Country country){
		this.country = country;
	}

	public Country getCountry(){
		return country;
	}

	public void setAddress(Address address){
		this.address = address;
	}

	public Address getAddress(){
		return address;
	}

	public void setTest(boolean test){
		this.test = test;
	}

	public boolean isTest(){
		return test;
	}

	public void setCity(City city){
		this.city = city;
	}

	public City getCity(){
		return city;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	public void setTimezone(String timezone){
		this.timezone = timezone;
	}

	public String getTimezone(){
		return timezone;
	}

	public void setUpcomingEvents(UpcomingEvents upcomingEvents){
		this.upcomingEvents = upcomingEvents;
	}

	public UpcomingEvents getUpcomingEvents(){
		return upcomingEvents;
	}

	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}

	public String getPostalCode(){
		return postalCode;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setLocale(String locale){
		this.locale = locale;
	}

	public String getLocale(){
		return locale;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"VenuesItem{" + 
			"country = '" + country + '\'' + 
			",address = '" + address + '\'' + 
			",test = '" + test + '\'' + 
			",city = '" + city + '\'' + 
			",_links = '" + links + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",upcomingEvents = '" + upcomingEvents + '\'' + 
			",postalCode = '" + postalCode + '\'' + 
			",type = '" + type + '\'' + 
			",locale = '" + locale + '\'' + 
			",url = '" + url + '\'' + 
			",location = '" + location + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}