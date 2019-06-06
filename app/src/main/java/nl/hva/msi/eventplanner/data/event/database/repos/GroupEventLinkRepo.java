package nl.hva.msi.eventplanner.data.event.database.repos;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import nl.hva.msi.eventplanner.data.event.database.EventDatabase;
import nl.hva.msi.eventplanner.data.event.database.daos.GroupEventLinkDao;
import nl.hva.msi.eventplanner.data.event.database.entities.GroupEventLink;

public class GroupEventLinkRepo implements GroupEventLinkDao {

    private EventDatabase eventDatabase;
    private GroupEventLinkDao linkDao;
    private Executor executor = Executors.newSingleThreadExecutor();
    private LiveData<List<GroupEventLink>> allLinks;


    public GroupEventLinkRepo(Context context) {
        this.eventDatabase = EventDatabase.getDatabase(context);
        this.linkDao = eventDatabase.groupEventLinkDao();
        this.allLinks = linkDao.getAllLinks();
    }

    @Override
    public LiveData<List<GroupEventLink>> getAllLinks() {
        return allLinks;
    }

    @Override
    public void insertLink(GroupEventLink link) {
        executor.execute(() -> linkDao.insertLink(link));
    }

    @Override
    public void deleteLink(GroupEventLink link) {
        executor.execute(() -> linkDao.deleteLink(link));
    }

    @Override
    public void updateLink(GroupEventLink link) {
        executor.execute(() -> linkDao.updateLink(link));
    }
}
