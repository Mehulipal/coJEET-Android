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
import com.example.mevscovid.ui.slideshow.SlideshowFragment3;
import com.example.mevscovid.ui.slideshow.SlideshowFragment4;
import com.example.mevscovid.ui.slideshow.SlideshowFragment5;

public class NFragment extends Fragment {
    public NFragment() {

    }

    public LinearLayout h;
    public LinearLayout i;
    public LinearLayout j;
    public LinearLayout k;
    public LinearLayout l;
    public LinearLayout m;
    public LinearLayout n;
    public LinearLayout o;
    public LinearLayout p;
    public LinearLayout q;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_n, container, false);

        h = (LinearLayout)view.findViewById(R.id.h);
        i = (LinearLayout)view.findViewById(R.id.i);
        j = (LinearLayout)view.findViewById(R.id.j);
        k = (LinearLayout)view.findViewById(R.id.k);
        l = (LinearLayout)view.findViewById(R.id.l);
        m = (LinearLayout)view.findViewById(R.id.m);
        n = (LinearLayout)view.findViewById(R.id.n);
        o = (LinearLayout)view.findViewById(R.id.o);
        p = (LinearLayout)view.findViewById(R.id.p);
        q = (LinearLayout)view.findViewById(R.id.q);

        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://swayam.gov.in/NPTEL")));
                //  Log.e("Hi","Bye");
            }
        });
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SlideshowFragment3();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(getId(), fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                //  Log.e("Hi","Bye");
            }
        });
        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://mehuli-gov.000webhostapp.com/chat/chat/mchat/index.php")));
                //  Log.e("Hi","Bye");
            }
        });
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SlideshowFragment4();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(getId(), fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                //  Log.e("Hi","Bye");
            }
        });
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://mehuli-gov.000webhostapp.com/coronvavirushelplinenumber.pdf")));
                //  Log.e("Hi","Bye");
            }
        });
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.mapmyindia.com/corona/Andaman+&+Nicobar+Islands?containment_zone_gradient")));
                //  Log.e("Hi","Bye");
            }
        });
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new HomeFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(getId(), fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                //  Log.e("Hi","Bye");
            }
        });
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://serviceonline.gov.in/epass/")));
                //  Log.e("Hi","Bye");
            }
        });
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://serviceonline.gov.in/epass/")));
                //  Log.e("Hi","Bye");
            }
        });

        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new SlideshowFragment5();
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