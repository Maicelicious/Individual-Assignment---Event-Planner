package nl.hva.msi.eventplanner.data.event.model.eventByIdModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExternalLinks {
    @SerializedName("youtube")
    @Expose
    private List<Youtube> youtube = null;
    @SerializedName("twitter")
    @Expose
    private List<Twitter> twitter = null;
    @SerializedName("lastfm")
    @Expose
    private List<Lastfm> lastfm = null;
    @SerializedName("wiki")
    @Expose
    private List<Wiki> wiki = null;
    @SerializedName("facebook")
    @Expose
    private List<Facebook> facebook = null;
    @SerializedName("musicbrainz")
    @Expose
    private List<Musicbrainz> musicbrainz = null;
    @SerializedName("homepage")
    @Expose
    private List<Homepage> homepage = null;
}
