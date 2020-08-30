package com.example.mevscovid.ui.slideshow;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mevscovid.R;

import com.example.mevscovid.ui.MemberList;
import com.example.mevscovid.ui.Members;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment4 extends Fragment {


    private SlideshowViewModel slideshowViewModel;

    EditText name;
    Spinner genres;
    Button add;
    DatabaseReference databaseMembers;

    ListView listViewMembers;
    List<Members> memberlist;
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //View view = inflater.inflate(R.layout.fragment_home, container, false);
        //  slideshowViewModel =
        //        ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow4, container, false);

        databaseMembers = FirebaseDatabase.getInstance().getReference("Members");

        name = (EditText) root.findViewById(R.id.editText);
        genres = (Spinner)root.findViewById(R.id.spinner2);
        add = (Button)root.findViewById(R.id.button2);
        listViewMembers = (ListView)root.findViewById(R.id.ListViewMembers);
        memberlist = new ArrayList<>();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(".PoliciesFragment","Worked fine before????????????????????!!!!!!!!!!");
                addMember();
            }
        });

        listViewMembers.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Members membe = memberlist.get(position);
                String identity = membe.getMId();
                Log.e("hello",identity);
                showUpdateDialog(membe.getMId(), membe.getMname());
                return false;
            }
        });


        return root;
    }


    @Override
    public void onStart()
    {
        super.onStart();

        databaseMembers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                memberlist.clear();

                for (DataSnapshot memberSnapshot: dataSnapshot.getChildren()){
                    Members memb = memberSnapshot.getValue(Members.class);

                    memberlist.add(memb);
                }

                //   MemberList adapter = new MemberList(SlideshowFragment.this,memberlist);
                listViewMembers.setAdapter(new MemberList(getActivity(), memberlist));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void showUpdateDialog(final String memId, String memName){

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_dialog,null);
        dialogBuilder.setView(dialogView);

        final EditText editName = (EditText)dialogView.findViewById(R.id.update);
        final Button editButton = (Button)dialogView.findViewById(R.id.buUpdate);
        final Spinner editSpin = (Spinner)dialogView.findViewById(R.id.spin);
        dialogBuilder.setTitle("Updating Member "+memName);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(".PoliciesFragment","Worked fine before????????????????????");
                String name = editName.getText().toString().trim();
                String genre = editSpin.getSelectedItem().toString();

                if(TextUtils.isEmpty(name)){
                    editName.setError("Name required");
                    return;
                }
                updateMember(memId,name,genre);
                alertDialog.dismiss();
            }
        });



    }

    private boolean updateMember(String id, String name, String genre)
    {
        Log.d(".PoliciesFragment","Worked fine before!!!!!!!!!!");
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Members").child(id);
        Members member1 = new Members(id,name,genre);
        databaseReference.setValue(member1);
        //  mDatabase.child("users").child(userId).setValue(user);
        Toast.makeText(getActivity(),"Members Updated Successfully", Toast.LENGTH_SHORT).show();
        return true;

    }


    private void addMember(){

        String Name = name.getText().toString().trim();
        String Genre = genres.getSelectedItem().toString();

        if(!TextUtils.isEmpty(Name)) {
            Log.e(".PoliciesFragment","Worked fine before@@@@@@@");

            String id = databaseMembers.push().getKey();
            Members member = new Members(id, Name, Genre);
            databaseMembers.child(id).setValue(member);
            Toast.makeText(getContext(),"Member added",Toast.LENGTH_SHORT).show();
            String identity = member.getMId();
            Log.e("hello",identity);
            //          pass_id(identity);

        }else{
            Toast.makeText(getContext(),"Enter your name",Toast.LENGTH_SHORT).show();
        }
    }


}