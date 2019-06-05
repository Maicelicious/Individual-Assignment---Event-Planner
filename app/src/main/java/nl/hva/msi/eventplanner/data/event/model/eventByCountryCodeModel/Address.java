package nl.hva.msi.eventplanner.data.event.model.eventByCountryCodeModel;

import com.google.gson.annotations.SerializedName;

public class Address{

	@SerializedName("line1")
	private String line1;

	public void setLine1(String line1){
		this.line1 = line1;
	}

	public String getLine1(){
		return line1;
	}

	@Override
 	public String toString(){
		return 
			"Address{" + 
			"line1 = '" + line1 + '\'' + 
			"}";
		}
}