package nl.hva.msi.eventplanner.ui.Fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import nl.hva.msi.eventplanner.R;
import nl.hva.msi.eventplanner.data.event.database.entities.GroupEntity;

public class GroupCreateFragment extends Fragment {

    private GroupCreateViewModel groupCreateViewModel;

    public static GroupCreateFragment newInstance() {
        return new GroupCreateFragment();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.group_create_listitem, container, false);

        Button save = view.findViewById(R.id.saveButton);
        Button cancel = view.findViewById(R.id.cancelButton);
        groupCreateViewModel = ViewModelProviders.of(this).get(GroupCreateViewModel.class);

        EditText groupEditText = view.findViewById(R.id.groupNameInput);

        save.setOnClickListener(view1 -> {
            GroupFragment newFragment = null;
            if (getFragmentManager() != null) {
                newFragment = new GroupFragment();
            }
            if (newFragment != null) {
                FragmentManager manager = getFragmentManager();
                if (manager != null) {
                    GroupEntity groupEntity = new GroupEntity();

                    String groupName = groupEditText.getText().toString();
                    groupEntity.setGroupName(groupName);
                    groupCreateViewModel.insertGroup(groupEntity);
                    manager.beginTransaction().replace(R.id.fragment_container, newFragment).commit();

                } else {
                    //TODO: Error handling
                }
            }
        });


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        groupCreateViewModel = ViewModelProviders.of(this).get(GroupCreateViewModel.class);
        // TODO: Use the ViewModel
    }

}
