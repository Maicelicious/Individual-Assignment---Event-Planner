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

import java.util.List;

import nl.hva.msi.eventplanner.R;
import nl.hva.msi.eventplanner.application.ApiService;
import nl.hva.msi.eventplanner.application.GetCallback;
import nl.hva.msi.eventplanner.data.event.database.entities.EventEntity;
import nl.hva.msi.eventplanner.data.event.database.repos.EventRepo;
import nl.hva.msi.eventplanner.data.event.model.EventResponse;
import nl.hva.msi.eventplanner.data.mapper.Mapper;
import nl.hva.msi.eventplanner.ui.Fragments.Viewmodel.EventSearchViewModel;

public class EventSearchFragment extends Fragment {

    private EventResponse eventResponse;
    private EventSearchViewModel mViewModel;
    private ApiService apiService = ApiService.getInstance();
    private EventRepo eventRepo = new EventRepo(this.getContext());

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
            searchWithParameters(countryCode.getText().toString(), city.getText().toString(), keyword.getText().toString());
            Fragment newFragment = new EventFragment();

                newFragment = EventFragment.newInstance();
            if (getFragmentManager() != null) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, newFragment).commit();
            }
        });


        return view;
    }

    private void searchWithParameters(String countryCode, String city, String keyword) {

        if (!countryCode.trim().isEmpty() && !city.trim().isEmpty() && !keyword.trim().isEmpty()) {
            apiCallWithEveryParam(countryCode, city, keyword);
        }
        if (!countryCode.trim().isEmpty() && !city.trim().isEmpty()) {
            apiCallWithCCAndCity(countryCode, city);
        }
        if (!countryCode.trim().isEmpty() && !keyword.trim().isEmpty()) {
            apiCallWithCCAndKeyword(countryCode, keyword);
        }

        if (!city.trim().isEmpty() && !keyword.trim().isEmpty()) {
            apiCallWithCityAndKeyword(city, keyword);
        }
        if (!countryCode.trim().isEmpty()) {
            apiCallOnlyCC(countryCode);
        }
        if (!city.trim().isEmpty()) {
            apiCallOnlyCity(city);
        }
        if (!keyword.trim().isEmpty()) {
            apiCallWithKeyWord(keyword);
        }
    }

    private void apiCallWithKeyWord(String keyword) {
        apiService.getEventByKeyWord(keyword, new GetCallback() {
            @Override
            public void onSuccess(EventResponse event) {
                List<EventEntity> eventMapperList = Mapper.getInstance().EventResponseToEntity(event);
                for (EventEntity e :
                        eventMapperList) {
                    eventRepo.insertEvent(e);
                }
            }

            @Override
            public void onError() {

            }
        });

    }

    private void apiCallOnlyCity(String city) {
        apiService.getEventsByCity(city, new GetCallback() {
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
    }

    private void apiCallWithCityAndKeyword(String city, String keyword) {
        apiService.getEventsByCityAndKeyword(city, keyword, new GetCallback() {
            @Override
            public void onSuccess(EventResponse event) {
                List<EventEntity> eventMapperList = Mapper.getInstance().EventResponseToEntity(event);
                for (EventEntity e :
                        eventMapperList) {
                    eventRepo.insertEvent(e);
                }
            }

            @Override
            public void onError() {

            }
        });
    }

    private void apiCallOnlyCC(String countryCode) {
        apiService.getEventsByCountryCode(countryCode, new GetCallback() {
            @Override
            public void onSuccess(EventResponse event) {
                List<EventEntity> eventMapperList = Mapper.getInstance().EventResponseToEntity(event);
                for (EventEntity e :
                        eventMapperList) {
                    eventRepo.insertEvent(e);
                }
            }

            @Override
            public void onError() {

            }
        });
    }

    private void apiCallWithCCAndCity(String countryCode, String city) {
        apiService.getEventsByCityAndCountryCode(city, countryCode, new GetCallback() {
            @Override
            public void onSuccess(EventResponse event) {
                List<EventEntity> eventMapperList = Mapper.getInstance().EventResponseToEntity(event);
                for (EventEntity e :
                        eventMapperList) {
                    eventRepo.insertEvent(e);
                }
            }

            @Override
            public void onError() {

            }
        });

    }

    private void apiCallWithCCAndKeyword(String countryCode, String keyword) {
        apiService.getEventByKeyWordAndCountryCode(keyword, countryCode, new GetCallback() {
            @Override
            public void onSuccess(EventResponse event) {
                List<EventEntity> eventMapperList = Mapper.getInstance().EventResponseToEntity(event);
                for (EventEntity e :
                        eventMapperList) {
                    eventRepo.insertEvent(e);
                }
            }

            @Override
            public void onError() {

            }
        });

    }

    private void apiCallWithEveryParam(String countryCode, String city, String keyword) {
        apiService.getEventsByCityAndCountryCodeAndKeyWord(city, countryCode, keyword, new GetCallback() {
            @Override
            public void onSuccess(EventResponse event) {
                List<EventEntity> eventMapperList = Mapper.getInstance().EventResponseToEntity(event);
                for (EventEntity e :
                        eventMapperList) {
                    eventRepo.insertEvent(e);
                }
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EventSearchViewModel.class);
        // TODO: Use the ViewModel
    }

}
