package nl.hva.msi.eventplanner.application;

import nl.hva.msi.eventplanner.data.event.model.eventByCountryCodeModel.EventResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * This Interface is used to call the Api's
 */
public interface TicketMasterApi {

    @GET("discovery/v2/events/{id}.json?")
    Call<EventResponse> getEventById(
            @Path("id") String id,
            @Query("apikey") String apikey
    );

    @GET("discovery/v2/events/{id}.json?attraction/")
    Call<EventResponse> getEventsAndAttractionsById(
            @Path("id") String id,
            @Query("id") String attractionId,
            @Query("apikey") String apiKey
    );

    @GET("discovery/v2/events.json")
    Call<EventResponse> getEventsByCountryCode(
            @Query("countryCode") String countryCode,
            @Query("apikey") String apiKey
    );

    @GET("discovery/v2/events.json")
    Call<EventResponse> getEventByKeyWord(
            @Query("keyword") String keyword,
            @Query("apikey") String apiKey
    );
    @GET("discovery/v2/events.json")
    Call<EventResponse> getEventByKeyWordAndCountryCode(
            @Query("keyword") String keyword,
            @Query("countryCode") String countryCode,
            @Query("apikey") String apiKey
    );

    @GET("discovery/v2/events.json")
    Call<EventResponse> getEventsByClassificationNameAndDMAID(
            @Query("classificationName") String classificationName,
            @Query("dmaId") String dmaId,
            @Query("apikey") String apiKey
    );

    @GET("discovery/v2/events.json")
    Call<EventResponse> getEventsByCity(
            @Query("city") String city,
            @Query("apikey") String apiKey
    );

    @GET("discovery/v2/events.json")
    Call<EventResponse> getEventsByCityAndKeyword(
            @Query("city") String city,
            @Query("keyword") String keyword,
            @Query("apikey") String apikey
    );

    @GET("discovery/v2/events.json")
    Call<EventResponse> getEventsByCityAndCountryCode(
            @Query("city") String city,
            @Query("countryCode") String country,
            @Query("apikey") String apikey
    );

    @GET("discovery/v2/events.json")
    Call<EventResponse> getEventsByCityAndCountryCodeAndKeyWord(
            @Query("city") String city,
            @Query("countryCode") String country,
            @Query("keyword") String keyword,
            @Query("apikey") String apikey
    );



}
