package nl.hva.msi.eventplanner.ui.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

import nl.hva.msi.eventplanner.R;
import nl.hva.msi.eventplanner.data.event.database.entities.EventEntity;
import nl.hva.msi.eventplanner.data.event.database.entities.GroupEntity;
import nl.hva.msi.eventplanner.data.event.database.entities.GroupEventLink;
import nl.hva.msi.eventplanner.ui.Fragments.Viewmodel.GroupEventListViewModel;
import nl.hva.msi.eventplanner.ui.logic.GroupListRecyclerViewAdapter;

public class GroupEventListFragment extends Fragment implements RecyclerView.OnItemTouchListener {

    private GroupEventListViewModel groupEventListViewModel;
    private GroupListRecyclerViewAdapter groupListRecyclerViewAdapter;
    private RecyclerView recyclerView;
    private List<EventEntity> events = new LinkedList<>();
    private List<GroupEventLink> groupEventLinks;
    private View.OnClickListener getGetMyGameBack;
    private List<EventEntity> allEvents;
    private GroupEventLink tempGroupLink;

    private GroupEntity groupEntity;


    private static final String GROUP_KEY = "veryKey";

    public static GroupEventListFragment newInstance(GroupEntity groupEntity) {
        GroupEventListFragment groupEventListFragment = new GroupEventListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(GROUP_KEY, groupEntity);
        groupEventListFragment.setArguments(bundle);
        return groupEventListFragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.group_event_list_fragment, container, false);
        groupEventListViewModel = ViewModelProviders.of(this).get(GroupEventListViewModel.class);

        recyclerView = view.findViewById(R.id.recyclerViewGroupEvent);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if (getArguments() != null) {
            groupEntity = (GroupEntity) getArguments().getSerializable(GROUP_KEY);
        }


        groupEventListViewModel.getAllEvents().observe(this, events -> {
            if (events != null && !events.isEmpty()) {
                allEvents = events;
            }
        });

        groupEventListViewModel.getAllLinks().observe(this, links -> {
            groupEventLinks = links;
            String groupId = String.valueOf(groupEntity.getId());
            for (GroupEventLink groupEventLink :
                    groupEventLinks) {
                String groupEventLinkGroupId = groupEventLink.getGroupId();
                if (groupEventLinkGroupId.equals(groupId)) {
                    if (allEvents != null) {
                        for (EventEntity ev :
                                allEvents) {
                            String entityId = String.valueOf(ev.getEntityID());
                            if (groupEventLink.getEventId().equals(entityId)) {
                                events.add(ev);
                            }
                        }
                    }

                }
            }
            updateUI();
        });

        updateUI();
        return view;
    }

    private void updateUI() {
        if (groupListRecyclerViewAdapter == null) {
            groupListRecyclerViewAdapter = new GroupListRecyclerViewAdapter(events);
            recyclerView.setAdapter(groupListRecyclerViewAdapter);
            groupListRecyclerViewAdapter.notifyDataSetChanged();
        } else {
            groupListRecyclerViewAdapter.swapList(events);

        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        groupEventListViewModel = ViewModelProviders.of(this).get(GroupEventListViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }
}
