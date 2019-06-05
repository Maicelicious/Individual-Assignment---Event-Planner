package nl.hva.msi.eventplanner.data.event.model.eventByCountryCodeModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EventsItem{

	@SerializedName("images")
	private List<ImagesItem> images;

	@SerializedName("test")
	private boolean test;

	@SerializedName("_links")
	private Links links;

	@SerializedName("dates")
	private Dates dates;

	@SerializedName("priceRanges")
	private List<PriceRangesItem> priceRanges;

	@SerializedName("type")
	private String type;

	@SerializedName("locale")
	private String locale;

	@SerializedName("url")
	private String url;

	@SerializedName("sales")
	private Sales sales;

	@SerializedName("classifications")
	private List<ClassificationsItem> classifications;

	@SerializedName("_embedded")
	private Embedded embedded;

	@SerializedName("name")
	private String name;

	@SerializedName("promoter")
	private Promoter promoter;

	@SerializedName("id")
	private String id;

	@SerializedName("promoters")
	private List<PromotersItem> promoters;

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

	public void setDates(Dates dates){
		this.dates = dates;
	}

	public Dates getDates(){
		return dates;
	}

	public void setPriceRanges(List<PriceRangesItem> priceRanges){
		this.priceRanges = priceRanges;
	}

	public List<PriceRangesItem> getPriceRanges(){
		return priceRanges;
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

	public void setSales(Sales sales){
		this.sales = sales;
	}

	public Sales getSales(){
		return sales;
	}

	public void setClassifications(List<ClassificationsItem> classifications){
		this.classifications = classifications;
	}

	public List<ClassificationsItem> getClassifications(){
		return classifications;
	}

	public void setEmbedded(Embedded embedded){
		this.embedded = embedded;
	}

	public Embedded getEmbedded(){
		return embedded;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPromoter(Promoter promoter){
		this.promoter = promoter;
	}

	public Promoter getPromoter(){
		return promoter;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setPromoters(List<PromotersItem> promoters){
		this.promoters = promoters;
	}

	public List<PromotersItem> getPromoters(){
		return promoters;
	}

	@Override
 	public String toString(){
		return 
			"EventsItem{" + 
			"images = '" + images + '\'' + 
			",test = '" + test + '\'' + 
			",_links = '" + links + '\'' + 
			",dates = '" + dates + '\'' + 
			",priceRanges = '" + priceRanges + '\'' + 
			",type = '" + type + '\'' + 
			",locale = '" + locale + '\'' + 
			",url = '" + url + '\'' + 
			",sales = '" + sales + '\'' + 
			",classifications = '" + classifications + '\'' + 
			",_embedded = '" + embedded + '\'' + 
			",name = '" + name + '\'' + 
			",promoter = '" + promoter + '\'' + 
			",id = '" + id + '\'' + 
			",promoters = '" + promoters + '\'' + 
			"}";
		}
}