package com.example.studentinfo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DataEntryFragment.OnDataPass {

    private List<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new DataEntryFragment());
            transaction.commit();
        }
    }
    @Override
    public void onDataPass(String name, int age, int grade, String major) {
        studentList.add(new Student(name, age, grade, major));
        DisplayFragment displayFragment = new DisplayFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("studentList", new ArrayList<>(studentList));
        displayFragment.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, displayFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public List<Student> getStudentList() {
        return studentList;
    }
}
