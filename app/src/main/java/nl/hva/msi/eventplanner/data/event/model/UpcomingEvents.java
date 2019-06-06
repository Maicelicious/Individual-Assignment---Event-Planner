package nl.hva.msi.eventplanner.data.event.model;

import com.google.gson.annotations.SerializedName;

public class UpcomingEvents{

	@SerializedName("_total")
	private int total;

	@SerializedName("mfx-nl")
	private int mfxNl;

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setMfxNl(int mfxNl){
		this.mfxNl = mfxNl;
	}

	public int getMfxNl(){
		return mfxNl;
	}

	@Override
 	public String toString(){
		return 
			"UpcomingEvents{" + 
			"_total = '" + total + '\'' + 
			",mfx-nl = '" + mfxNl + '\'' + 
			"}";
		}
}