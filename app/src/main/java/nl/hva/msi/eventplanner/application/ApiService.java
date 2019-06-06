package nl.hva.msi.eventplanner.application;


import nl.hva.msi.eventplanner.BuildConfig;
import nl.hva.msi.eventplanner.data.event.database.repos.EventRepo;
import nl.hva.msi.eventplanner.data.event.model.EventResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This class is used to call API's and save them to the database a
 * Additional to that the ViewModel is used to get the values either through internet or local
 */
public class ApiService{

    private static final String BASE_URL = "https://app.ticketmaster.com/";
    private static final String LANGUAGE = "en-US";

    private static ApiService apiService;

    private TicketMasterApi ticketMasterApi;

    private EventRepo eventRepo;


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

    public void getEventById( String id, final GetCallback callback) {
        ticketMasterApi.getEventById(id, BuildConfig.ApiKey).enqueue(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                if (response.isSuccessful()) {
                    EventResponse event = response.body();
                    if (event != null) {
                        callback.onSuccess(event);
                    } else {
                        callback.onError();
                    }
                }
            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {
                callback.onError();
                System.out.println(t.getMessage());
            }
        });
    }

    public void getEventsByCountryCode(String countryCode, final GetCallback getCallback) {
        ticketMasterApi.getEventsByCountryCode(countryCode, BuildConfig.ApiKey).enqueue(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                if (response.isSuccessful()) {
                    EventResponse eventResponse = response.body();
                    getCallback.onSuccess(eventResponse);
                }
            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {
                getCallback.onError();
                System.out.println(t.getMessage());
            }
        });
    }

    public void getEventByKeyWord(String keyword, final GetCallback getCallback) {
        ticketMasterApi.getEventByKeyWord(keyword, BuildConfig.ApiKey).enqueue(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                if (response.isSuccessful()) {
                    EventResponse eventResponse = response.body();

                    getCallback.onSuccess(eventResponse);
                }
            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {
                getCallback.onError();
                System.out.println(t.getMessage());
            }
        });
    }

    public void getEventByKeyWordAndCountryCode(String keyword, String countryCode, final GetCallback getCallback) {
        ticketMasterApi.getEventByKeyWordAndCountryCode(keyword, countryCode, BuildConfig.ApiKey).enqueue(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                if (response.isSuccessful()) {
                    EventResponse eventResponse = response.body();
                    getCallback.onSuccess(eventResponse);
                }
            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {
                getCallback.onError();
                System.out.println(t.getMessage());
            }
        });
    }

    public void  getEventsByCity(String city, final GetCallback callback) {
        ticketMasterApi.getEventsByCity(city, BuildConfig.ApiKey).enqueue(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                if (response.isSuccessful()) {
                    EventResponse eventResponse = response.body();
                    callback.onSuccess(eventResponse);
                }
            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {
                callback.onError();
                System.out.println(t.getMessage());
            }
        });
    }

    public void getEventsByCityAndKeyword(String city, String keyword, final GetCallback callback) {
        ticketMasterApi.getEventsByCityAndKeyword(city, keyword, BuildConfig.ApiKey).enqueue(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                if (response.isSuccessful()) {
                    EventResponse eventResponse = response.body();
                    callback.onSuccess(eventResponse);
                }
            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {
                callback.onError();
                System.out.println(t.getMessage());
            }
        });
    }

    public void getEventsByCityAndCountryCode(String city, String countryCode, final GetCallback callback) {
        ticketMasterApi.getEventsByCityAndCountryCode(city, countryCode, BuildConfig.ApiKey).enqueue(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                if (response.isSuccessful()) {
                    EventResponse eventResponse = response.body();
                    callback.onSuccess(eventResponse);
                }
            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {
                callback.onError();
                System.out.println(t.getMessage());
            }
        });
    }

    public void getEventsByCityAndCountryCodeAndKeyWord(String city, String countryCode, String keyword, final GetCallback callback) {
        ticketMasterApi.getEventsByCityAndCountryCodeAndKeyWord(city, countryCode, keyword, BuildConfig.ApiKey).enqueue(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                if (response.isSuccessful()) {
                    EventResponse eventResponse = response.body();
                    callback.onSuccess(eventResponse);
                }
            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {
                callback.onError();
                System.out.println(t.getMessage());
            }
        });
    }




}
