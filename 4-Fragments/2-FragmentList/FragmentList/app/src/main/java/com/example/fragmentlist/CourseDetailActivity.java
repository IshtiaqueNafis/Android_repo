package com.example.fragmentlist;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.fragmentlist.Fragments.CourseDetailFragment;
import com.example.fragmentlist.data.CourseData;
import com.example.fragmentlist.models.Course;

public class CourseDetailActivity extends AppCompatActivity {
    Course course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        if (savedInstanceState == null) {
            Bundle extra = getIntent().getExtras();
            int position = extra.getInt("course_id");
            course = new CourseData().courseList().get(position);

            Toast.makeText(this, "position" + position, Toast.LENGTH_LONG).show();
            CourseDetailFragment fragment = new CourseDetailFragment();
            fragment.setArguments(extra);
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().add(R.id.detailContainer, fragment).commit();
        }
    }
}