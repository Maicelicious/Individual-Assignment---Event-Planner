package nl.hva.msi.eventplanner.ui.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import nl.hva.msi.eventplanner.R;
import nl.hva.msi.eventplanner.application.ApiService;
import nl.hva.msi.eventplanner.application.GetCallback;
import nl.hva.msi.eventplanner.data.event.model.eventByCountryCodeModel.EventResponse;
import nl.hva.msi.eventplanner.ui.Fragments.Viewmodel.EventSearchViewModel;

public class EventSearchFragment extends Fragment {

    private EventResponse eventResponse;
    private EventSearchViewModel mViewModel;
    private ApiService apiService = ApiService.getInstance();

    public static EventSearchFragment newInstance() {
        return new EventSearchFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event_search_fragment, container, false);

        EditText city = view.findViewById(R.id.cityInput);
        EditText keyword = view.findViewById(R.id.keyWordInput);
        EditText countryCode = view.findViewById(R.id.countryCodeInput);

        //The floatingButton action
        FloatingActionButton floatingActionButton = view.findViewById(R.id.searchEventFab);
        floatingActionButton.setOnClickListener(view1 -> {
            EventResponse eventResponse = searchWithParameters(countryCode.getText().toString(), city.getText().toString(), keyword.getText().toString());
            Fragment newFragment = new EventFragment();

            if (eventResponse != null) {
                newFragment = EventFragment.newInstance(eventResponse);
            }
            if (getFragmentManager() != null) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, newFragment).commit();
            }
        });


        return view;
    }

    private EventResponse searchWithParameters(String countryCode, String city, String keyword) {
        EventResponse e;
        if (countryCode.matches("/^(\\+?\\d{1,3}|\\d{1,4})$/") && city.matches("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$") && !keyword.isEmpty()) {
            e = apiCallWithEveryParam(countryCode, city, keyword);
        } else if (countryCode.matches("/^(\\+?\\d{1,3}|\\d{1,4})$/") && !keyword.isEmpty()) {
            e = apiCallWithCCAndKeyword(countryCode, keyword);
        } else if (countryCode.matches("/^(\\+?\\d{1,3}|\\d{1,4})$/") && city.matches("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$")) {
            e = apiCallWithCCAndCity(countryCode, city);
        } else if (countryCode.matches("/^(\\+?\\d{1,3}|\\d{1,4})$/")) {
            e = apiCallOnlyCC(countryCode);
        } else if (city.matches("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$") && !keyword.isEmpty()) {
            e = apiCallWithCityAndKeyword(city, keyword);
        } else if (city.matches("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$")) {
            e = apiCallOnlyCity(city);
        } else if (!keyword.isEmpty()) {
            e = apiCallWithKeyWord(keyword);
        } else {
            //TODO: Error Handling
            e = new EventResponse();
        }
        return e;
    }

    private EventResponse apiCallWithKeyWord(String keyword) {
        apiService.getEventByKeyWord(keyword, new GetCallback() {
            @Override
            public void onSuccess(EventResponse event) {
                eventResponse = event;
            }

            @Override
            public void onError() {

            }
        });

        EventResponse eventResponse;
        eventResponse = this.eventResponse;
        return eventResponse;
    }

    private EventResponse apiCallOnlyCity(String city) {
        apiService.getEventsByCity(city, new GetCallback() {
            @Override
            public void onSuccess(EventResponse event) {

            }

            @Override
            public void onError() {

            }
        });

        EventResponse eventResponse;
        eventResponse = this.eventResponse;
        return eventResponse;
    }

    private EventResponse apiCallWithCityAndKeyword(String city, String keyword) {
        apiService.getEventsByCityAndKeyword(city, keyword, new GetCallback() {
            @Override
            public void onSuccess(EventResponse event) {

            }

            @Override
            public void onError() {

            }
        });

        EventResponse eventResponse;
        eventResponse = this.eventResponse;
        return eventResponse;
    }

    private EventResponse apiCallOnlyCC(String countryCode) {
        apiService.getEventsByCountryCode(countryCode, new GetCallback() {
            @Override
            public void onSuccess(EventResponse event) {

            }

            @Override
            public void onError() {

            }
        });

        EventResponse eventResponse;
        eventResponse = this.eventResponse;
        return eventResponse;
    }

    private EventResponse apiCallWithCCAndCity(String countryCode, String city) {
        apiService.getEventsByCityAndCountryCode(city, countryCode, new GetCallback() {
            @Override
            public void onSuccess(EventResponse event) {

            }

            @Override
            public void onError() {

            }
        });

        EventResponse eventResponse;
        eventResponse = this.eventResponse;
        return eventResponse;
    }

    private EventResponse apiCallWithCCAndKeyword(String countryCode, String keyword) {
        apiService.getEventByKeyWordAndCountryCode(keyword, countryCode, new GetCallback() {
            @Override
            public void onSuccess(EventResponse event) {

            }

            @Override
            public void onError() {

            }
        });
        EventResponse eventResponse;
        eventResponse = this.eventResponse;
        return eventResponse;
    }

    private EventResponse apiCallWithEveryParam(String countryCode, String city, String keyword) {
        apiService.getEventsByCityAndCountryCodeAndKeyWord(city, countryCode, keyword, new GetCallback() {
            @Override
            public void onSuccess(EventResponse event) {

            }

            @Override
            public void onError() {

            }
        });
        EventResponse eventResponse;
        eventResponse = this.eventResponse;
        return eventResponse;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EventSearchViewModel.class);
        // TODO: Use the ViewModel
    }

}
