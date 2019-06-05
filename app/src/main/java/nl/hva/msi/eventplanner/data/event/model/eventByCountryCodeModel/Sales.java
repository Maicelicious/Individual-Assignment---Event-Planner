package nl.hva.msi.eventplanner.data.event.model.eventByCountryCodeModel;

import com.google.gson.annotations.SerializedName;

public class Sales{

	@SerializedName("public")
	private JsonMemberPublic jsonMemberPublic;

	public void setJsonMemberPublic(JsonMemberPublic jsonMemberPublic){
		this.jsonMemberPublic = jsonMemberPublic;
	}

	public JsonMemberPublic getJsonMemberPublic(){
		return jsonMemberPublic;
	}

	@Override
 	public String toString(){
		return 
			"Sales{" + 
			"public = '" + jsonMemberPublic + '\'' + 
			"}";
		}
}