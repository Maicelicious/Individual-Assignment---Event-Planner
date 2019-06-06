package nl.hva.msi.eventplanner.ui.Fragments.Viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import nl.hva.msi.eventplanner.application.ApiService;
import nl.hva.msi.eventplanner.data.event.database.daos.EventDao;
import nl.hva.msi.eventplanner.data.event.database.daos.GroupDao;
import nl.hva.msi.eventplanner.data.event.database.entities.EventEntity;
import nl.hva.msi.eventplanner.data.event.database.entities.GroupEntity;
import nl.hva.msi.eventplanner.data.event.database.repos.EventRepo;
import nl.hva.msi.eventplanner.data.event.database.repos.GroupRepo;
import nl.hva.msi.eventplanner.data.event.model.EventResponse;
import nl.hva.msi.eventplanner.data.mapper.Mapper;

public class EventViewModel extends AndroidViewModel implements EventDao, GroupDao {

    private ApiService apiService;
    private EventRepo eventRepo;
    private GroupRepo groupRepo;
    private Mapper mapper = Mapper.getInstance();
    private LiveData<List<GroupEntity>> groups;


    public EventViewModel(@NonNull Application application) {
        super(application);
        this.apiService = ApiService.getInstance();
        this.eventRepo = new EventRepo(application.getApplicationContext());
        this.groupRepo = new GroupRepo(application.getApplicationContext());
        groups = groupRepo.getAllGroups();
    }

    public void mapAndSaveEvents(EventResponse eventResponse) {
        List<EventEntity> newEventEntities = mapper.EventResponseToEntity(eventResponse);
        if (newEventEntities.isEmpty()) {
            //TODO SMth
        }
        for (EventEntity e:
             newEventEntities) {
            insertEvent(e);
        }

    }

    @Override
    public LiveData<List<EventEntity>> getAllEvents() {
        return eventRepo.getAllEvents();
    }

    @Override
    public LiveData<EventEntity> getEventByID(String id) {
        return eventRepo.getEventByID(id);
    }

    @Override
    public void insertEvent(EventEntity event) {
        eventRepo.insertEvent(event);
    }

    @Override
    public void deleteEvent(EventEntity event) {
        eventRepo.deleteEvent(event);
    }

    @Override
    public void updateEvent(EventEntity event) {
        eventRepo.updateEvent(event);
    }

    @Override
    public LiveData<List<GroupEntity>> getAllGroups() {
        return groupRepo.getAllGroups();
    }

    @Override
    public void insertGroup(GroupEntity groupEntity) {
        groupRepo.insertGroup(groupEntity);
    }

    @Override
    public void deleteGroup(GroupEntity groupEntity) {
        groupRepo.deleteGroup(groupEntity);
    }

    @Override
    public void updateGroup(GroupEntity groupEntity) {
        groupRepo.updateGroup(groupEntity);
    }

    public LiveData<List<GroupEntity>> getGroups() {
        return groups;
    }

    public void setGroups(LiveData<List<GroupEntity>> groups) {
        this.groups = groups;
    }
}
