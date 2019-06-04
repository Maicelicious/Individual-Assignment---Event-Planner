package nl.hva.msi.eventplanner.application;


import nl.hva.msi.eventplanner.BuildConfig;
import nl.hva.msi.eventplanner.data.event.model.Event;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This class is used to call API's and save them to the database a
 * Additional to that the ViewModel is used to get the values either through internet or local
 */
public class ApiService {

    private static final String BASE_URL = "https://app.ticketmaster.com/";
    private static final String LANGUAGE = "en-US";

    private static ApiService apiService;

    private TicketMasterApi ticketMasterApi;


    private ApiService(TicketMasterApi api) {
        this.ticketMasterApi = api;
    }


    public static ApiService getInstance() {
        if (apiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiService = new ApiService(retrofit.create(TicketMasterApi.class));
        }

        return apiService;
    }

    public void getEventById(final GetCallback callback, String id) {
        ticketMasterApi.getEventById(id, id, BuildConfig.ApiKey).enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {
                if (response.isSuccessful()) {
                    Event event = response.body();
                    if (event != null) {
                        callback.onSuccess(event);
                    } else {
                        callback.onError();
                    }
                }
            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {
                callback.onError();
            }
        });
    }




}
