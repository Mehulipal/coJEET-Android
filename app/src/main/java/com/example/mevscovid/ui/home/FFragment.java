package com.example.mevscovid.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.mevscovid.R;

public class FFragment extends Fragment {
    public FFragment() {

    }
    public LinearLayout x;
    public LinearLayout y;
    public LinearLayout z;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_f, container, false);

        x = (LinearLayout)view.findViewById(R.id.x);
        y = (LinearLayout)view.findViewById(R.id.y);
        z = (LinearLayout)view.findViewById(R.id.z);

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www2.illinois.gov/sites/sfm/CurrentFocus/Pages/COVID-19-First-Responders-Guidance.aspx")));
                //  Log.e("Hi","Bye");
            }
        });
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://niti.gov.in/healthcovid/volunteer_covid.php")));
                //  Log.e("Hi","Bye");
            }
        });
        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cdc.gov/coronavirus/2019-ncov/community/critical-workers/implementing-safety-practices.html")));
                //  Log.e("Hi","Bye");
            }
        });
        return view;
    }

}