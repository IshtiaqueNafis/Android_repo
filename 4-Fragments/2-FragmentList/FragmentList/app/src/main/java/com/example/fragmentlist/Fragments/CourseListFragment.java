package com.example.fragmentlist.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.example.fragmentlist.R;
import com.example.fragmentlist.adapter.CourseArrayAdapter;
import com.example.fragmentlist.data.CourseData;
import com.example.fragmentlist.models.Course;

import java.util.List;

public class CourseListFragment extends ListFragment {

    List<Course> courses = new CourseData().courseList();
    private CallBacks activity;

    public CourseListFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CourseArrayAdapter adapter = new CourseArrayAdapter(requireActivity(),
                R.layout.course_list_item, courses);  // set course adapter

        setListAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.courselist_fragment, container, false);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        Course course = courses.get(position);
        this.activity.onItemSelected(course,position);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.activity = (CallBacks) context; // attach call back
    }
}
