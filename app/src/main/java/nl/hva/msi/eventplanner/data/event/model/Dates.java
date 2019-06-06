package nl.hva.msi.eventplanner.data.event.model;

import com.google.gson.annotations.SerializedName;

public class Dates{

	@SerializedName("timezone")
	private String timezone;

	@SerializedName("start")
	private Start start;

	@SerializedName("status")
	private Status status;

	@SerializedName("spanMultipleDays")
	private boolean spanMultipleDays;

	public void setTimezone(String timezone){
		this.timezone = timezone;
	}

	public String getTimezone(){
		return timezone;
	}

	public void setStart(Start start){
		this.start = start;
	}

	public Start getStart(){
		return start;
	}

	public void setStatus(Status status){
		this.status = status;
	}

	public Status getStatus(){
		return status;
	}

	public void setSpanMultipleDays(boolean spanMultipleDays){
		this.spanMultipleDays = spanMultipleDays;
	}

	public boolean isSpanMultipleDays(){
		return spanMultipleDays;
	}

	@Override
 	public String toString(){
		return 
			"Dates{" + 
			"timezone = '" + timezone + '\'' + 
			",start = '" + start + '\'' + 
			",status = '" + status + '\'' + 
			",spanMultipleDays = '" + spanMultipleDays + '\'' + 
			"}";
		}
}