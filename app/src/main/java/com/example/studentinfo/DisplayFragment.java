package com.example.studentinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DisplayFragment extends Fragment {

    private RecyclerView recyclerViewStudents;
    private Button buttonBack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display, container, false);

        recyclerViewStudents = view.findViewById(R.id.recyclerViewStudents);
        buttonBack = view.findViewById(R.id.buttonBack);

        List<Student> studentList = ((MainActivity) getActivity()).getStudentList();
        StudentAdapter adapter = new StudentAdapter(studentList);
        recyclerViewStudents.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewStudents.setAdapter(adapter);
        buttonBack.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new DataEntryFragment())
                    .commit();
        });
        return view;
    }
}