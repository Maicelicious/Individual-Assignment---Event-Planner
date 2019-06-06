package nl.hva.msi.eventplanner.data.event.model;

import com.google.gson.annotations.SerializedName;

public class JsonMemberPublic{

	@SerializedName("startDateTime")
	private String startDateTime;

	@SerializedName("startTBD")
	private boolean startTBD;

	@SerializedName("endDateTime")
	private String endDateTime;

	public void setStartDateTime(String startDateTime){
		this.startDateTime = startDateTime;
	}

	public String getStartDateTime(){
		return startDateTime;
	}

	public void setStartTBD(boolean startTBD){
		this.startTBD = startTBD;
	}

	public boolean isStartTBD(){
		return startTBD;
	}

	public void setEndDateTime(String endDateTime){
		this.endDateTime = endDateTime;
	}

	public String getEndDateTime(){
		return endDateTime;
	}

	@Override
 	public String toString(){
		return 
			"JsonMemberPublic{" + 
			"startDateTime = '" + startDateTime + '\'' + 
			",startTBD = '" + startTBD + '\'' + 
			",endDateTime = '" + endDateTime + '\'' + 
			"}";
		}
}