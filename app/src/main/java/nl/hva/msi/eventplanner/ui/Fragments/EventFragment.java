package nl.hva.msi.eventplanner.ui.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.net.Uri;
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
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EventFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EventFragment#newInstance} factory method to
 * create an instance of this fragment.
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

    private OnFragmentInteractionListener mListener;

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


        //Swiping with a ItemTouchHelper

//        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
//            @Override
//            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
//                return false;
//            }
//
//            @Override
//            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
//                int pos = viewHolder.getAdapterPosition();

        //TODO: Maybe add to a group
//            tempEvent = events.get(pos);
//            eventViewModel.deleteGroup(groups.get(pos));
//            groups.remove(pos);
//            groupRecyclerViewAdapter.notifyItemRemoved(pos);
//
//            Snackbar.make(Objects.requireNonNull(getActivity()).findViewById(android.R.id.content), tempGroup.getGroupName() + " has been deleted", Snackbar.LENGTH_LONG)
//                    .setAction(R.string.snackbar_undo, getGetMyGameBack)
//                    .setActionTextColor(Color.MAGENTA)
//                    .show();
//            }
//        };
//        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
//        itemTouchHelper.attachToRecyclerView(recyclerView);
//        recyclerView.addOnItemTouchListener(this);
//
//        //obviously we need Listeners for the Snackbar
//        getGetMyGameBack = v -> {
//            groupViewModel.insertGroup(tempGroup);
//            updateUI();
//        };
//
        return eventView;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

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
        mListener = null;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        eventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
    }
}
