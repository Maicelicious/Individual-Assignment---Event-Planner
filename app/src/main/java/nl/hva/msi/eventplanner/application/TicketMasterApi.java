package nl.hva.msi.eventplanner.application;

import nl.hva.msi.eventplanner.data.event.model.Event;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface TicketMasterApi {
    @GET("discovery/v2/events/{id}.json?attraction/")
    Call<Event> getEventById(
            @Path("id") String id,
            @Query("id") String attractionId,
            @Query("apikey") String apiKey
    );
}
