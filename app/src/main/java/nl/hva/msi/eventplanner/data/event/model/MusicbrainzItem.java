package nl.hva.msi.eventplanner.data.event.model;

import com.google.gson.annotations.SerializedName;

public class MusicbrainzItem{

	@SerializedName("id")
	private String id;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"MusicbrainzItem{" + 
			"id = '" + id + '\'' + 
			"}";
		}
}