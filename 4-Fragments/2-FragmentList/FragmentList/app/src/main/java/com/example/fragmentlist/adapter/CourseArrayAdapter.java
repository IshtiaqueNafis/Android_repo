package com.example.fragmentlist.adapter;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.example.fragmentlist.R;
import com.example.fragmentlist.models.Course;
import java.util.List;

public class CourseArrayAdapter extends ArrayAdapter<Course> {

    private final Context context;
    private final List<Course> courses;

    public CourseArrayAdapter(@NonNull Context context, int resource, @NonNull List<Course> courses) {
        super(context, resource, courses);
        this.context = context;
        this.courses = courses;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Course course = courses.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE); // inflater service is nedded here.
        View view = inflater.inflate(R.layout.course_list_item, null);
        ImageView imageView =  view.findViewById(R.id.detailCourseImageId);
        imageView.setImageResource(course.getImageResourceId(context));
        TextView textView = view.findViewById(R.id.courseNameId);
        textView.setText(course.getCourseName());

        return view;
    }
}
