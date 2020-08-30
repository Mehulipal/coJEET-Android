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

public class CFragment extends Fragment {
    public CFragment() {

    }
    public LinearLayout r;
    public LinearLayout s;
    public LinearLayout t;
    public LinearLayout u;
    public LinearLayout v;
    public LinearLayout w;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_c, container, false);

        r = (LinearLayout)view.findViewById(R.id.r);
        s = (LinearLayout)view.findViewById(R.id.s);
        t = (LinearLayout)view.findViewById(R.id.t);
        u = (LinearLayout)view.findViewById(R.id.u);
        v = (LinearLayout)view.findViewById(R.id.v);
        w = (LinearLayout)view.findViewById(R.id.w);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.mapmyindia.com/corona/Andaman+&+Nicobar+Islands?corona_treatment_centre")));
                //  Log.e("Hi","Bye");
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://mehuli-gov.000webhostapp.com/chat2/chat/mchat/index.php")));
                //  Log.e("Hi","Bye");
            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.mapmyindia.com/corona/Andaman+&+Nicobar+Islands?corona_testing_centre")));
                //  Log.e("Hi","Bye");
            }
        });
        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://mehuli-gov.000webhostapp.com/chat3/chat/mchat/index.php")));
                //  Log.e("Hi","Bye");
            }
        });
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://mehuli-gov.000webhostapp.com/chat4/chat/mchat/index.php")));
                //  Log.e("Hi","Bye");
            }
        });
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://mehuli-gov.000webhostapp.com/chat5/chat/mchat/index.php")));
                //  Log.e("Hi","Bye");
            }
        });
    return view;
    }

}
