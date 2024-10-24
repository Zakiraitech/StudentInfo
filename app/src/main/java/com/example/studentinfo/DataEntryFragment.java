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