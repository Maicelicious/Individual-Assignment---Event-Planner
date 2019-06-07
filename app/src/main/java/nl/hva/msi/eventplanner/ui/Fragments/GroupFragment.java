package nl.hva.msi.eventplanner.ui.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import nl.hva.msi.eventplanner.R;
import nl.hva.msi.eventplanner.data.event.database.entities.GroupEntity;
import nl.hva.msi.eventplanner.ui.Fragments.Viewmodel.GroupViewModel;
import nl.hva.msi.eventplanner.ui.logic.ClickListener;
import nl.hva.msi.eventplanner.ui.logic.GroupRecyclerViewAdapter;
import nl.hva.msi.eventplanner.ui.logic.RecyclerViewTouchListener;


/**
 * This class is used for the Group View where you can list all your groups.
 * In this you have the RecyclerView that lists all Groups
 */
public class GroupFragment extends Fragment implements RecyclerView.OnItemTouchListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private GroupRecyclerViewAdapter groupRecyclerViewAdapter;
    private RecyclerView recyclerView;
    private GroupViewModel groupViewModel;
    private List<GroupEntity> groups;
    private List<GroupEntity> tempGroups;
    private View.OnClickListener getGetMyGameBack;
    private GroupEntity tempGroup;


    private OnFragmentInteractionListener mListener;

    public GroupFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GroupFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GroupFragment newInstance(String param1, String param2) {
        GroupFragment fragment = new GroupFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this
        View view = inflater.inflate(R.layout.fragment_group, container, false);

        this.recyclerView = view.findViewById(R.id.recyclerViewGroup);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        groups = new LinkedList<>();
        tempGroups = new LinkedList<>();
        updateUI();

        groupViewModel = ViewModelProviders.of(this).get(GroupViewModel.class);

        groupViewModel.getAllGroups().observe(this, groupEntities -> {
            groups = groupEntities;
            updateUI();
        });

        FloatingActionButton fab = view.findViewById(R.id.group_add);
        fab.setOnClickListener(view1 -> {
            Fragment newFragment = new GroupCreateFragment();
            FragmentManager manager = getFragmentManager();
            if (manager != null) {
                manager.beginTransaction().replace(R.id.fragment_container, newFragment).commit();
            } else {
                //do smth
            }

        });

        //touchlistener for the recyclerView
        recyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(getContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                GroupEntity group = groups.get(position);
                Fragment newFragment = GroupEventListFragment.newInstance(group);
                FragmentManager manager = getFragmentManager();
                if (manager != null) {
                    manager.beginTransaction().replace(R.id.fragment_container, newFragment).commit();
                }

            }

            @Override
            public void onLongClick(View view, int position) {
                GroupEntity editGame = groups.get(position);
                Fragment newFragment = GroupEditFragment.newInstance(editGame);
                FragmentManager manager = getFragmentManager();
                if (manager != null) {
                    manager.beginTransaction().replace(R.id.fragment_container, newFragment).commit();
                }
            }
        }));

        //Swiping with a ItemTouchHelper
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                int pos = viewHolder.getAdapterPosition();

                tempGroup = groups.get(pos);
                groupViewModel.deleteGroup(groups.get(pos));
                groups.remove(pos);
                groupRecyclerViewAdapter.notifyItemRemoved(pos);

                Snackbar.make(Objects.requireNonNull(getActivity()).findViewById(android.R.id.content), tempGroup.getGroupName() + " has been deleted", Snackbar.LENGTH_LONG)
                        .setAction(R.string.snackbar_undo, getGetMyGameBack)
                        .setActionTextColor(Color.MAGENTA)
                        .show();
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        recyclerView.addOnItemTouchListener(this);

        //obviously we need Listeners for the Snackbar
        getGetMyGameBack = v -> {
            groupViewModel.insertGroup(tempGroup);
            updateUI();
        };

        return view;
    }

    private void updateUI() {
        if (groupRecyclerViewAdapter == null) {
            groupRecyclerViewAdapter = new GroupRecyclerViewAdapter(groups);
            recyclerView.setAdapter(groupRecyclerViewAdapter);
        } else {
            groupRecyclerViewAdapter.swapList(groups);
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
////    public void onAttach(Context context) {
////        super.onAttach(context);
////        if (context instanceof OnFragmentInteractionListener) {
////            mListener = (OnFragmentInteractionListener) context;
////        } else {
////            throw new RuntimeException(context.toString()
////                    + " must implement OnFragmentInteractionListener");
////        }
////    }

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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        groupViewModel = ViewModelProviders.of(this).get(GroupViewModel.class);
        // TODO: Use the ViewModel

    }
}
