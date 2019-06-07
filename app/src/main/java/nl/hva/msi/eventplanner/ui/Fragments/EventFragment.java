package nl.hva.msi.eventplanner.ui.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import nl.hva.msi.eventplanner.R;
import nl.hva.msi.eventplanner.data.event.database.entities.EventEntity;
import nl.hva.msi.eventplanner.data.event.database.entities.GroupEntity;
import nl.hva.msi.eventplanner.data.event.model.EventResponse;
import nl.hva.msi.eventplanner.ui.Fragments.Viewmodel.EventViewModel;
import nl.hva.msi.eventplanner.ui.logic.ClickListener;
import nl.hva.msi.eventplanner.ui.logic.EventRecyclerViewAdapter;
import nl.hva.msi.eventplanner.ui.logic.RecyclerViewTouchListener;


/**
 * This Fragment shows all Events that you get from the Event Search in a Recyclerview
 */
public class EventFragment extends Fragment implements RecyclerView.OnItemTouchListener {


    private static final String EVENTRESPONSE_KEY = "someKey";
    private TextView textView;
    private EventResponse newEvent;
    private ImageButton groupAddButton;

    private View eventView;
    private Spinner spinner;
    List<GroupEntity> groups;

    private EventRecyclerViewAdapter eventRecyclerViewAdapter;
    private RecyclerView recyclerView;
    private List<EventEntity> events;
    private List<EventEntity> temEvents;
    private EventViewModel eventViewModel;

    private EventEntity addToGroupEntity;

    public EventFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EventFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventFragment newInstance() {
        EventFragment fragment = new EventFragment();
//        Bundle args = new Bundle();
//        args.putSerializable(EVENTRESPONSE_KEY,eventResponse);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EventResponse eventResponse = null;
        if (getArguments() != null) {
            eventResponse = (EventResponse) getArguments().getSerializable(EVENTRESPONSE_KEY);
        }

        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);

        if (eventResponse != null) {
            eventViewModel.mapAndSaveEvents(eventResponse);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        eventView = inflater.inflate(R.layout.fragment_event, container, false);

        this.recyclerView = eventView.findViewById(R.id.eventRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        events = new LinkedList<>();
        temEvents = new LinkedList<>();
        updateUI();


        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);

        eventViewModel.getAllEvents().observe(this, eventEntities -> {
            events = eventEntities;
            updateUI();
        });


        eventViewModel.getAllGroups().observe(this, eventEntities -> {
            groups = eventEntities;
            updateUI();
        });

        FloatingActionButton fab = eventView.findViewById(R.id.searchFab);
        fab.setOnClickListener(view1 -> {
            for (EventEntity e :
                    events) {
                eventViewModel.deleteEvent(e);
            }
            Fragment searchFragment = EventSearchFragment.newInstance();
            if (getFragmentManager() != null) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, searchFragment).commit();
            }
        });

        FloatingActionButton deleteFab = eventView.findViewById(R.id.deleteAllFap);
        deleteFab.setOnClickListener(view1 -> {
            for (EventEntity e :
                    events) {
                eventViewModel.deleteEvent(e);
            }
            updateUI();
        });

//        //Onclick to add to a group
//        groupAddButton = eventView.findViewById(R.id.addToGroupButton);
//        groupAddButton.setOnClickListener(v -> {
//            eventRecyclerViewAdapter.addEventToGroup(addToGroupEntity);
//            Toast.makeText(this.getContext(), "The Event " + addToGroupEntity.getName() + " has been added", Toast.LENGTH_SHORT).show();
//        });

        //touchlistener for the recyclerView
        recyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(getContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                addToGroupEntity = events.get(position);
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));
        return eventView;
    }


    private void updateUI() {
        if (eventRecyclerViewAdapter == null) {
            eventRecyclerViewAdapter = new EventRecyclerViewAdapter(events, groups, getContext());
            recyclerView.setAdapter(eventRecyclerViewAdapter);
        } else {
            eventRecyclerViewAdapter.swapList(events, groups);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
    }
}
