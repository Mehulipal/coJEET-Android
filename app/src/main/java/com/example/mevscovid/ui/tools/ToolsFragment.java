package com.example.mevscovid.ui.tools;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mevscovid.ApiClient;
import com.example.mevscovid.ApisClient;
import com.example.mevscovid.R;
import com.example.mevscovid.ui.JsonPlaceholderApis;
import com.example.mevscovid.ui.Post;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;
    EditText muser, memail, mmobile, mcomments;
    Button add;
    String iddata = null;
    ProgressDialog pd;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
      /*  toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);*/
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
      /*  final TextView textView = root.findViewById(R.id.text_tools);
        toolsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        //adding values; saving from form
        muser = (EditText) root.findViewById(R.id.user);
        memail = (EditText) root.findViewById(R.id.email);
        mmobile = (EditText) root.findViewById(R.id.mobile);
        mcomments = (EditText) root.findViewById(R.id.comments);

        add = (Button) root.findViewById(R.id.add);

        pd = new ProgressDialog(getContext());

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });


        return root;
    }


    //insert student
    public void insert() {
        String suser = muser.getText().toString().trim();
        String semail = memail.getText().toString().trim();
        String smobile = mmobile.getText().toString().trim();
        String scomments = mcomments.getText().toString().trim();

        JsonPlaceholderApis api = ApisClient.getApiClient().create(JsonPlaceholderApis.class);

        Call<Post> call = api.insertUser(suser, semail, smobile, scomments);
        Log.e("user",suser);
      //  Post p = new Post();

      //  Log.e("User*",p.getUser());
        call.enqueue(new Callback<Post>() {
            public void onResponse(Call<Post> call, Response<Post> response) {
                Log.e("RETRO", "response : " + response.body().toString());

                Toast.makeText(getActivity(), "Data inserted", Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onFailure(Call<Post> call, Throwable t) {

             //   Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

}