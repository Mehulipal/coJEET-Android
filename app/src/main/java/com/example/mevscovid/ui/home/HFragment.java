package com.example.mevscovid.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mevscovid.R;
import com.example.mevscovid.ui.slideshow.SlideshowFragment;
import com.example.mevscovid.ui.slideshow.SlideshowFragment2;

public class HFragment extends Fragment {
    public HFragment() {

    }

    public LinearLayout e;
    public LinearLayout f;
    public LinearLayout g;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_h, container, false);

        e = (LinearLayout)view.findViewById(R.id.e);
        f = (LinearLayout)view.findViewById(R.id.f);
        g = (LinearLayout)view.findViewById(R.id.g);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://mygov.in/task/join-war-against-covid-19-register-volunteer/")));
                //  Log.e("Hi","Bye");
            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://pmcares.gov.in/")));
                //  Log.e("Hi","Bye");
            }
        });
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SlideshowFragment2();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(getId(), fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                //  Log.e("Hi","Bye");
            }
        });
        return view;
    }

}