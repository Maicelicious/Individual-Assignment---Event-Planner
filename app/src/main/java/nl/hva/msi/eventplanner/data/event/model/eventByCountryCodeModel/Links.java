package nl.hva.msi.eventplanner.data.event.model.eventByCountryCodeModel;

import com.google.gson.annotations.SerializedName;

public class Links{

	@SerializedName("self")
	private Self self;

	public void setSelf(Self self){
		this.self = self;
	}

	public Self getSelf(){
		return self;
	}

	@Override
 	public String toString(){
		return 
			"Links{" + 
			"self = '" + self + '\'' + 
			"}";
		}
}