package com.example.studentinfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.nameTextView.setText("Name: " + student.getName());
        holder.ageTextView.setText("Age: " + student.getAge());
        holder.gradeTextView.setText("Grade: " + student.getGrade());
        holder.majorTextView.setText("Major: " + student.getMajor());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView, ageTextView, gradeTextView, majorTextView;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.textViewName);
            ageTextView = itemView.findViewById(R.id.textViewAge);
            gradeTextView = itemView.findViewById(R.id.textViewGrade);
            majorTextView = itemView.findViewById(R.id.textViewMajor);
        }
    }
}
