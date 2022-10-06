package com.example.fragmentlist.data;

import com.example.fragmentlist.models.Course;

import java.util.ArrayList;

public class CourseData {
    private final String[] courseNames = {
            "First Courses",
            "Second Courses",
            "Third Courses",
            "Fourth Courses",
            "Fifth Courses",
            "Sixth Courses",
            "Seventh Courses",
    };

    public ArrayList<Course> courseList(){
        ArrayList<Course> list = new ArrayList<>();
        for (String courseName : courseNames) {
            Course course = new Course(courseName, courseName.replace(" ", ""));
            list.add(course);
        }
        return list;
    }

}
