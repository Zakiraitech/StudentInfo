package com.example.studentinfo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DataEntryFragment extends Fragment {

    private EditText editTextName, editTextAge, editTextGrade, editTextMajor;
    private Button buttonSubmit, buttonClear;
    OnDataPass dataPasser;

    public interface OnDataPass {
        void onDataPass(String name, int age, int grade, String major);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnDataPass) {
            dataPasser = (OnDataPass) context;
        } else {
            throw new RuntimeException(context.toString() + "must  implement OnDataPass");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data_entry, container, false);
        editTextName = view.findViewById(R.id.editTextName);
        editTextAge = view.findViewById(R.id.editTextAge);
        editTextGrade = view.findViewById(R.id.editTextGrade);
        editTextMajor = view.findViewById(R.id.editTextMajor);
        buttonSubmit = view.findViewById(R.id.buttonSubmit);
        buttonClear = view.findViewById(R.id.buttonClear);

        buttonSubmit.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            int age = Integer.parseInt(editTextAge.getText().toString());
            int grade = Integer.parseInt(editTextGrade.getText().toString());
            String major = editTextMajor.getText().toString();
            dataPasser.onDataPass(name, age, grade, major);
        });
        buttonClear.setOnClickListener(v -> {
            editTextName.setText("");
            editTextAge.setText("");
            editTextGrade.setText("");
            editTextMajor.setText("");
        });
        return view;
    }
}