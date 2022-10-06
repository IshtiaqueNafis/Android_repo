package com.example.fragmentlist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.fragmentlist.Fragments.CallBacks;
import com.example.fragmentlist.Fragments.CourseListFragment;
import com.example.fragmentlist.models.Course;

public class MainActivity extends AppCompatActivity implements CallBacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.myContainer);

        if (fragment == null) {
            fragment = new CourseListFragment();
            fm.beginTransaction().add(R.id.myContainer, fragment).commit();
        }

    }

    @Override
    public void onItemSelected(Course course, int position) {
        Toast.makeText(this, "hello", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, CourseDetailActivity.class);
        intent.putExtra("course_id", position);
        startActivity(intent);

    }


}