package nl.hva.msi.eventplanner.data.event.model.eventByCountryCodeModel;

import com.google.gson.annotations.SerializedName;

public class Country{

	@SerializedName("countryCode")
	private String countryCode;

	@SerializedName("name")
	private String name;

	public void setCountryCode(String countryCode){
		this.countryCode = countryCode;
	}

	public String getCountryCode(){
		return countryCode;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"Country{" + 
			"countryCode = '" + countryCode + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}