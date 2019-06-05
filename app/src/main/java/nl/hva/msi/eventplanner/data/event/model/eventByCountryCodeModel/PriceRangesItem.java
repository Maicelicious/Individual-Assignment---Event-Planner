package nl.hva.msi.eventplanner.data.event.model.eventByCountryCodeModel;

import com.google.gson.annotations.SerializedName;

public class PriceRangesItem{

	@SerializedName("min")
	private double min;

	@SerializedName("max")
	private double max;

	@SerializedName("currency")
	private String currency;

	@SerializedName("type")
	private String type;

	public void setMin(double min){
		this.min = min;
	}

	public double getMin(){
		return min;
	}

	public void setMax(double max){
		this.max = max;
	}

	public double getMax(){
		return max;
	}

	public void setCurrency(String currency){
		this.currency = currency;
	}

	public String getCurrency(){
		return currency;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"PriceRangesItem{" + 
			"min = '" + min + '\'' + 
			",max = '" + max + '\'' + 
			",currency = '" + currency + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}