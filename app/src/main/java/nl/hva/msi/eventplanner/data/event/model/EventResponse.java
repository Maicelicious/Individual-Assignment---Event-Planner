package nl.hva.msi.eventplanner.data.event.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class EventResponse implements Serializable {

	@SerializedName("_embedded")
	private Embedded embedded;

	@SerializedName("_links")
	private Links links;

	@SerializedName("page")
	private Page page;

	public void setEmbedded(Embedded embedded){
		this.embedded = embedded;
	}

	public Embedded getEmbedded(){
		return embedded;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	public void setPage(Page page){
		this.page = page;
	}

	public Page getPage(){
		return page;
	}

	@Override
 	public String toString(){
		return 
			"EventResponse{" +
			"_embedded = '" + embedded + '\'' + 
			",_links = '" + links + '\'' + 
			",page = '" + page + '\'' + 
			"}";
		}
}