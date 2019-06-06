package nl.hva.msi.eventplanner.data.event.model;

import com.google.gson.annotations.SerializedName;

public class ClassificationsItem{

	@SerializedName("subGenre")
	private SubGenre subGenre;

	@SerializedName("segment")
	private Segment segment;

	@SerializedName("genre")
	private Genre genre;

	@SerializedName("subType")
	private SubType subType;

	@SerializedName("type")
	private Type type;

	@SerializedName("family")
	private boolean family;

	@SerializedName("primary")
	private boolean primary;

	public void setSubGenre(SubGenre subGenre){
		this.subGenre = subGenre;
	}

	public SubGenre getSubGenre(){
		return subGenre;
	}

	public void setSegment(Segment segment){
		this.segment = segment;
	}

	public Segment getSegment(){
		return segment;
	}

	public void setGenre(Genre genre){
		this.genre = genre;
	}

	public Genre getGenre(){
		return genre;
	}

	public void setSubType(SubType subType){
		this.subType = subType;
	}

	public SubType getSubType(){
		return subType;
	}

	public void setType(Type type){
		this.type = type;
	}

	public Type getType(){
		return type;
	}

	public void setFamily(boolean family){
		this.family = family;
	}

	public boolean isFamily(){
		return family;
	}

	public void setPrimary(boolean primary){
		this.primary = primary;
	}

	public boolean isPrimary(){
		return primary;
	}

	@Override
 	public String toString(){
		return 
			"ClassificationsItem{" + 
			"subGenre = '" + subGenre + '\'' + 
			",segment = '" + segment + '\'' + 
			",genre = '" + genre + '\'' + 
			",subType = '" + subType + '\'' + 
			",type = '" + type + '\'' + 
			",family = '" + family + '\'' + 
			",primary = '" + primary + '\'' + 
			"}";
		}
}