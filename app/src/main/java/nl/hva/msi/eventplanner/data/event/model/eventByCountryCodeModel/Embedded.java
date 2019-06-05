package nl.hva.msi.eventplanner.data.event.model.eventByCountryCodeModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Embedded{

	@SerializedName("events")
	private List<EventsItem> events;

	@SerializedName("venues")
	private List<VenuesItem> venues;

	@SerializedName("attractions")
	private List<AttractionsItem> attractions;

	public void setEvents(List<EventsItem> events){
		this.events = events;
	}

	public List<EventsItem> getEvents(){
		return events;
	}

	public void setVenues(List<VenuesItem> venues){
		this.venues = venues;
	}

	public List<VenuesItem> getVenues(){
		return venues;
	}

	public void setAttractions(List<AttractionsItem> attractions){
		this.attractions = attractions;
	}

	public List<AttractionsItem> getAttractions(){
		return attractions;
	}

	@Override
 	public String toString(){
		return 
			"Embedded{" + 
			"events = '" + events + '\'' + 
			",venues = '" + venues + '\'' + 
			",attractions = '" + attractions + '\'' + 
			"}";
		}
}