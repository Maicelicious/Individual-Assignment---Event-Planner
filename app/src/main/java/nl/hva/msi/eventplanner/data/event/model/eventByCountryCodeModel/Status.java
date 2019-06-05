package nl.hva.msi.eventplanner.data.event.model.eventByCountryCodeModel;

import com.google.gson.annotations.SerializedName;

public class Status{

	@SerializedName("code")
	private String code;

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	@Override
 	public String toString(){
		return 
			"Status{" + 
			"code = '" + code + '\'' + 
			"}";
		}
}