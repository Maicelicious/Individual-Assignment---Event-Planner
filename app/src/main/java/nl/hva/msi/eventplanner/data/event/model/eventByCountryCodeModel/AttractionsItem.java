package nl.hva.msi.eventplanner.data.event.model.eventByCountryCodeModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AttractionsItem{

	@SerializedName("classifications")
	private List<ClassificationsItem> classifications;

	@SerializedName("images")
	private List<ImagesItem> images;

	@SerializedName("test")
	private boolean test;

	@SerializedName("_links")
	private Links links;

	@SerializedName("upcomingEvents")
	private UpcomingEvents upcomingEvents;

	@SerializedName("name")
	private String name;

	@SerializedName("externalLinks")
	private ExternalLinks externalLinks;

	@SerializedName("id")
	private String id;

	@SerializedName("type")
	private String type;

	@SerializedName("locale")
	private String locale;

	@SerializedName("url")
	private String url;

	public void setClassifications(List<ClassificationsItem> classifications){
		this.classifications = classifications;
	}

	public List<ClassificationsItem> getClassifications(){
		return classifications;
	}

	public void setImages(List<ImagesItem> images){
		this.images = images;
	}

	public List<ImagesItem> getImages(){
		return images;
	}

	public void setTest(boolean test){
		this.test = test;
	}

	public boolean isTest(){
		return test;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	public void setUpcomingEvents(UpcomingEvents upcomingEvents){
		this.upcomingEvents = upcomingEvents;
	}

	public UpcomingEvents getUpcomingEvents(){
		return upcomingEvents;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setExternalLinks(ExternalLinks externalLinks){
		this.externalLinks = externalLinks;
	}

	public ExternalLinks getExternalLinks(){
		return externalLinks;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
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

	@Override
 	public String toString(){
		return 
			"AttractionsItem{" + 
			"classifications = '" + classifications + '\'' + 
			",images = '" + images + '\'' + 
			",test = '" + test + '\'' + 
			",_links = '" + links + '\'' + 
			",upcomingEvents = '" + upcomingEvents + '\'' + 
			",name = '" + name + '\'' + 
			",externalLinks = '" + externalLinks + '\'' + 
			",id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			",locale = '" + locale + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}