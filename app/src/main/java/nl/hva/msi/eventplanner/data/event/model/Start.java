package nl.hva.msi.eventplanner.data.event.model;

import com.google.gson.annotations.SerializedName;

public class Start{

	@SerializedName("dateTime")
	private String dateTime;

	@SerializedName("localTime")
	private String localTime;

	@SerializedName("dateTBA")
	private boolean dateTBA;

	@SerializedName("noSpecificTime")
	private boolean noSpecificTime;

	@SerializedName("timeTBA")
	private boolean timeTBA;

	@SerializedName("localDate")
	private String localDate;

	@SerializedName("dateTBD")
	private boolean dateTBD;

	public void setDateTime(String dateTime){
		this.dateTime = dateTime;
	}

	public String getDateTime(){
		return dateTime;
	}

	public void setLocalTime(String localTime){
		this.localTime = localTime;
	}

	public String getLocalTime(){
		return localTime;
	}

	public void setDateTBA(boolean dateTBA){
		this.dateTBA = dateTBA;
	}

	public boolean isDateTBA(){
		return dateTBA;
	}

	public void setNoSpecificTime(boolean noSpecificTime){
		this.noSpecificTime = noSpecificTime;
	}

	public boolean isNoSpecificTime(){
		return noSpecificTime;
	}

	public void setTimeTBA(boolean timeTBA){
		this.timeTBA = timeTBA;
	}

	public boolean isTimeTBA(){
		return timeTBA;
	}

	public void setLocalDate(String localDate){
		this.localDate = localDate;
	}

	public String getLocalDate(){
		return localDate;
	}

	public void setDateTBD(boolean dateTBD){
		this.dateTBD = dateTBD;
	}

	public boolean isDateTBD(){
		return dateTBD;
	}

	@Override
 	public String toString(){
		return 
			"Start{" + 
			"dateTime = '" + dateTime + '\'' + 
			",localTime = '" + localTime + '\'' + 
			",dateTBA = '" + dateTBA + '\'' + 
			",noSpecificTime = '" + noSpecificTime + '\'' + 
			",timeTBA = '" + timeTBA + '\'' + 
			",localDate = '" + localDate + '\'' + 
			",dateTBD = '" + dateTBD + '\'' + 
			"}";
		}
}