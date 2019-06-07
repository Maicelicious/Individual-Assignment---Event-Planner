package nl.hva.msi.eventplanner.ui.Fragments.Viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

import java.util.List;

import nl.hva.msi.eventplanner.data.event.database.daos.GroupDao;
import nl.hva.msi.eventplanner.data.event.database.entities.GroupEntity;
import nl.hva.msi.eventplanner.data.event.database.repos.GroupRepo;

/**
 * This is the ViewModel Class of the GroupCreateFragment which makes the CRUD functionality for the Fragemt
 */
public class GroupCreateViewModel extends AndroidViewModel implements GroupDao {

    private GroupRepo groupRepo;
    private LiveData<List<GroupEntity>> groups;

    public GroupCreateViewModel(@NonNull Application application) {
        super(application);
        groupRepo = new GroupRepo(application.getApplicationContext());
        groups = groupRepo.getAllGroups();
    }

    @Override
    public LiveData<List<GroupEntity>> getAllGroups() {
        return groups;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
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
}
