package nl.hva.msi.eventplanner.data.event.model;

import com.google.gson.annotations.SerializedName;

public class ImagesItem{

	@SerializedName("width")
	private int width;

	@SerializedName("fallback")
	private boolean fallback;

	@SerializedName("url")
	private String url;

	@SerializedName("ratio")
	private String ratio;

	@SerializedName("height")
	private int height;

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return width;
	}

	public void setFallback(boolean fallback){
		this.fallback = fallback;
	}

	public boolean isFallback(){
		return fallback;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setRatio(String ratio){
		this.ratio = ratio;
	}

	public String getRatio(){
		return ratio;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}

	@Override
 	public String toString(){
		return 
			"ImagesItem{" + 
			"width = '" + width + '\'' + 
			",fallback = '" + fallback + '\'' + 
			",url = '" + url + '\'' + 
			",ratio = '" + ratio + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}
}