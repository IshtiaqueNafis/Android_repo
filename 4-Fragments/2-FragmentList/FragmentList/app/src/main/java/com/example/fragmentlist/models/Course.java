package com.example.fragmentlist.models;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class Course {
    //region *** properties ***
    private String courseName;
    private String courseImage;
    //endregion

    //region *** getter and setter ***
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }
    //endregion

    public Course(String courseName, String courseImage) {
        this.courseName = courseName;
        this.courseImage = courseImage;
    }

    //region ***getImageResourceId(Context context) --> get Image resources() ***
    @RequiresApi(api = Build.VERSION_CODES.Q)
    public int getImageResourceId(Context context){
        return context.getResources().getIdentifier(this.courseImage, "drawable", context.getPackageName());
    }
    //endregion
}

