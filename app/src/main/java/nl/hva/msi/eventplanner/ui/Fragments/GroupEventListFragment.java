package nl.hva.msi.eventplanner.ui.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nl.hva.msi.eventplanner.R;
import nl.hva.msi.eventplanner.ui.Fragments.Viewmodel.GroupEventListViewModel;

public class GroupEventListFragment extends Fragment {

    private GroupEventListViewModel mViewModel;

    public static GroupEventListFragment newInstance() {
        return new GroupEventListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.group_event_list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GroupEventListViewModel.class);
        // TODO: Use the ViewModel
    }

}
