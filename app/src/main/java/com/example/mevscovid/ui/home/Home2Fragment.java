package com.example.mevscovid.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.mevscovid.ApiClient;
import com.example.mevscovid.ui.JsonPlaceholderApi2;
import com.example.mevscovid.ui.PoliciesClass;
import com.example.mevscovid.R;


import android.util.Log;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mevscovid.adapter;
import com.example.mevscovid.ui.JsonPlaceholderApi;
import com.example.mevscovid.ui.Post;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home2Fragment extends Fragment {
    public Home2Fragment() {
    }
    /**private TextView mtext;
     private TextView mText1;
     private com.example.mevscovid.adapter adapter;
     **/

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private adapter adapter;
    private List<PoliciesClass> posts;
    private JsonPlaceholderApi2 apiInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rec);
        layoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setHasFixedSize(true);
        apiInterface = ApiClient.getApiClient().create(JsonPlaceholderApi2.class);

        Log.e(".PoliciesFragment","Worked fine before");
        /**   final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rec);
         Log.e(".PoliciesFragment","Worked now??????????????????????");
         mtext = (TextView) view.findViewById(R.id.policy_name_view);
         mText1 = (TextView) view.findViewById(R.id.policy_description_view);
         recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));

         Retrofit ret=new Retrofit.Builder()
         .baseUrl("https://jsonplaceholder.typicode.com/")
         .addConverterFactory(GsonConverterFactory.create())
         .build();
         JsonPlaceholderApi json1=ret.create(JsonPlaceholderApi.class);**/

        Call<List<PoliciesClass>> call=apiInterface.getposts();
        call.enqueue(new Callback<List<PoliciesClass>>() {
            @Override
            public void onResponse(Call<List<PoliciesClass>> call, Response<List<PoliciesClass>> response) {
                /** if(!response.isSuccessful()){
                 mtext.setText("Code:"+response.code());
                 return;
                 }**/
                posts = response.body();
                Log.d("TAG","Response = "+posts.toString());
                adapter = new adapter(posts);
                recyclerView.setAdapter(adapter);
                // recyclerView.setAdapter(new adapter(HomeFragment.this, posts1.((PoliciesClass)getActivity()).startChronometer();));

                /**for(Post post2:posts1){
                 String content="";
                 content+="Title:"+post2.getTitle();
                 mtext.append(content);
                 String content1="";
                 content1+="Text:"+post2.getText();
                 mText1.append(content1);
                 }**/

            }

            @Override
            public void onFailure(Call<List<PoliciesClass>> call, Throwable t) {
                //            mtext.setText(t.getMessage());
            }
        });



        //  populateData();

        return view;
    }

    /**  private void populateData() {

     ArrayList<PoliciesClass> PolicyItems = new ArrayList<>();
     PolicyItems.add(new PoliciesClass("Policy Name 1","Policy Description 1","Visit US 1"));
     PolicyItems.add(new PoliciesClass("Policy Name 2","Policy Description 2","Visit US 2"));
     PolicyItems.add(new PoliciesClass("Policy Name 3","Policy Description 3","Visit US 3"));
     PolicyItems.add(new PoliciesClass("Policy Name 4","Policy Description 4","Visit US 4"));
     PolicyItems.add(new PoliciesClass("Policy Name 5","Policy Description 5","Visit US 5"));
     PolicyItems.add(new PoliciesClass("Policy Name 6","Policy Description 6","Visit US 6"));

     adapter.setPoliciesAdapter(PolicyItems);

     }
     **/
}



/**
 public class Activity extends AppCompatActivity {
 private TextView mtext;
 @Override

 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 mtext = findViewById(R.id.textview);

 Retrofit ret=new Retrofit.Builder()
 .baseUrl("https://jsonplaceholder.typicode.com/")
 .addConverterFactory(GsonConverterFactory.create())
 .build();
 JsonPlaceholderApi json1=ret.create(JsonPlaceholderApi.class);
 Call<List<Post>> call=json1.getposts();
 call.enqueue(new Callback<List<Post>>() {
 @Override
 public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
 if(!response.isSuccessful()){
 mtext.setText("Code:"+response.code());
 return;
 }
 List<Post> posts1=response.body();
 for(Post post2:posts1){
 String content="";
 content+="ID:"+post2.getId()+"\n";
 content+="User ID:"+post2.getUserId()+"\n";
 content+="Title:"+post2.getTitle()+"\n";
 content+="Text:"+post2.getText()+"\n";
 mtext.append(content);
 }
 }

 @Override
 public void onFailure(Call<List<Post>> call, Throwable t) {
 mtext.setText(t.getMessage());
 }
 });
 }
 }
 **/


/**
 public class MainActivity extends AppCompatActivity {

 private RecyclerView recyclerView;
 private RecyclerView.LayoutManager layoutManager;
 private RecyclerAdapter recyclerAdapter;
 private List<Contact> contacts;
 private ApiInterface apiInterface;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);

 recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
 layoutManager = new LinearLayoutManager(this);
 recyclerView.setLayoutManager(layoutManager);
 recyclerView.setHasFixedSize(true);

 apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

 Call<List<Contact>> call = apiInterface.getContacts();
 call.enqueue(new Callback<List<Contact>>() {
 @Override
 public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
 contacts = response.body();
 recyclerAdapter = new RecyclerAdapter(contacts);
 recyclerView.setAdapter(recyclerAdapter);
 }

 @Override
 public void onFailure(Call<List<Contact>> call, Throwable t) {

 }
 });
 }
 }**/