package nl.hva.msi.eventplanner.data.event.database.repos;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import nl.hva.msi.eventplanner.data.event.database.EventDatabase;
import nl.hva.msi.eventplanner.data.event.database.daos.GroupDao;
import nl.hva.msi.eventplanner.data.event.database.entities.GroupEntity;

public class GroupRepo implements GroupDao {

    private EventDatabase eventDatabase;
    private GroupDao groupDao;
    private Executor executor = Executors.newSingleThreadExecutor();
    private LiveData<List<GroupEntity>> groups;

    public GroupRepo(Context context) {
        this.eventDatabase = EventDatabase.getDatabase(context);
        this.groupDao = eventDatabase.groupDao();
        this.groups = groupDao.getAllGroups();
    }


    @Override
    public LiveData<List<GroupEntity>> getAllGroups() {
        return groups;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void insertGroup(GroupEntity groupEntity) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedString = localDate.format(formatter);
        groupEntity.setCreated(formattedString);
        executor.execute(()-> groupDao.insertGroup(groupEntity));
    }

    @Override
    public void deleteGroup(GroupEntity groupEntity) {
        executor.execute(()-> groupDao.deleteGroup(groupEntity));
    }

    @Override
    public void updateGroup(GroupEntity groupEntity) {
        executor.execute(()-> groupDao.updateGroup(groupEntity));
    }
}
