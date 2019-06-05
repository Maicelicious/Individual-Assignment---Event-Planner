package nl.hva.msi.eventplanner.ui.Fragments.Viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import nl.hva.msi.eventplanner.application.ApiService;
import nl.hva.msi.eventplanner.data.event.model.eventByIdModel.Event;

public class EventViewModel extends AndroidViewModel {

    private ApiService apiService;


    public EventViewModel(@NonNull Application application) {
        super(application);
        this.apiService = ApiService.getInstance();
    }

    public Event getViewEventById(int id){
        return null;
    }
}
