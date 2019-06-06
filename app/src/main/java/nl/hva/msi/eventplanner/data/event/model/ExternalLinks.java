package nl.hva.msi.eventplanner.data.event.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExternalLinks{

	@SerializedName("youtube")
	private List<YoutubeItem> youtube;

	@SerializedName("twitter")
	private List<TwitterItem> twitter;

	@SerializedName("facebook")
	private List<FacebookItem> facebook;

	@SerializedName("wiki")
	private List<WikiItem> wiki;

	@SerializedName("instagram")
	private List<InstagramItem> instagram;

	@SerializedName("musicbrainz")
	private List<MusicbrainzItem> musicbrainz;

	@SerializedName("homepage")
	private List<HomepageItem> homepage;

	public void setYoutube(List<YoutubeItem> youtube){
		this.youtube = youtube;
	}

	public List<YoutubeItem> getYoutube(){
		return youtube;
	}

	public void setTwitter(List<TwitterItem> twitter){
		this.twitter = twitter;
	}

	public List<TwitterItem> getTwitter(){
		return twitter;
	}

	public void setFacebook(List<FacebookItem> facebook){
		this.facebook = facebook;
	}

	public List<FacebookItem> getFacebook(){
		return facebook;
	}

	public void setWiki(List<WikiItem> wiki){
		this.wiki = wiki;
	}

	public List<WikiItem> getWiki(){
		return wiki;
	}

	public void setInstagram(List<InstagramItem> instagram){
		this.instagram = instagram;
	}

	public List<InstagramItem> getInstagram(){
		return instagram;
	}

	public void setMusicbrainz(List<MusicbrainzItem> musicbrainz){
		this.musicbrainz = musicbrainz;
	}

	public List<MusicbrainzItem> getMusicbrainz(){
		return musicbrainz;
	}

	public void setHomepage(List<HomepageItem> homepage){
		this.homepage = homepage;
	}

	public List<HomepageItem> getHomepage(){
		return homepage;
	}

	@Override
 	public String toString(){
		return 
			"ExternalLinks{" + 
			"youtube = '" + youtube + '\'' + 
			",twitter = '" + twitter + '\'' + 
			",facebook = '" + facebook + '\'' + 
			",wiki = '" + wiki + '\'' + 
			",instagram = '" + instagram + '\'' + 
			",musicbrainz = '" + musicbrainz + '\'' + 
			",homepage = '" + homepage + '\'' + 
			"}";
		}
}