package nl.hva.msi.eventplanner.data.event.model;

import com.google.gson.annotations.SerializedName;

public class HomepageItem{

	@SerializedName("url")
	private String url;

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"HomepageItem{" + 
			"url = '" + url + '\'' + 
			"}";
		}
}