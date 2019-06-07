package nl.hva.msi.eventplanner.ui.Fragments.Viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import nl.hva.msi.eventplanner.application.ApiService;
import nl.hva.msi.eventplanner.data.event.database.daos.EventDao;
import nl.hva.msi.eventplanner.data.event.database.daos.GroupDao;
import nl.hva.msi.eventplanner.data.event.database.daos.GroupEventLinkDao;
import nl.hva.msi.eventplanner.data.event.database.entities.EventEntity;
import nl.hva.msi.eventplanner.data.event.database.entities.GroupEntity;
import nl.hva.msi.eventplanner.data.event.database.entities.GroupEventLink;
import nl.hva.msi.eventplanner.data.event.database.repos.EventRepo;
import nl.hva.msi.eventplanner.data.event.database.repos.GroupEventLinkRepo;
import nl.hva.msi.eventplanner.data.event.database.repos.GroupRepo;
import nl.hva.msi.eventplanner.data.mapper.Mapper;

/**
 * This is the ViewModel of the Events that are attached to a group
 * Here you can access all 3 Repositories to save and get everything from the DB
 */
public class GroupEventListViewModel extends AndroidViewModel implements GroupDao, EventDao, GroupEventLinkDao {


    private ApiService apiService;
    private EventRepo eventRepo;
    private GroupRepo groupRepo;
    private GroupEventLinkRepo groupEventLinkRepo;
    private Mapper mapper = Mapper.getInstance();
    private LiveData<List<GroupEntity>> groups;
    private LiveData<List<EventEntity>> events;
    private LiveData<List<GroupEventLink>> groupEventLinks;



    public GroupEventListViewModel(@NonNull Application application) {
        super(application);
        this.apiService = ApiService.getInstance();
        this.eventRepo = new EventRepo(application.getApplicationContext());
        this.groupRepo = new GroupRepo(application.getApplicationContext());
        this.groupEventLinkRepo = new GroupEventLinkRepo(application.getApplicationContext());
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

    }

    @Override
    public void deleteEvent(EventEntity event) {

    }

    @Override
    public void updateEvent(EventEntity event) {

    }

    @Override
    public LiveData<List<GroupEntity>> getAllGroups() {
        return groupRepo.getAllGroups();
    }

    @Override
    public void insertGroup(GroupEntity groupEntity) {

    }

    @Override
    public void deleteGroup(GroupEntity groupEntity) {

    }

    @Override
    public void updateGroup(GroupEntity groupEntity) {

    }

    @Override
    public LiveData<List<GroupEventLink>> getAllLinks() {
        return groupEventLinkRepo.getAllLinks();
    }

    @Override
    public void insertLink(GroupEventLink link) {
        groupEventLinkRepo.insertLink(link);
    }

    @Override
    public void deleteLink(GroupEventLink link) {
        groupEventLinkRepo.deleteLink(link);
    }

    @Override
    public void updateLink(GroupEventLink link) {

    }
}
