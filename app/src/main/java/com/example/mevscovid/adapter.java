package com.example.mevscovid;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import com.example.mevscovid.ui.Post;
        import com.example.mevscovid.ui.PoliciesClass;

        import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {

  //  private Context context;
    private List<PoliciesClass> mPoliciesItem;


    public adapter(List<PoliciesClass> mPoliciesItem) {
       // this.context = context;
        this.mPoliciesItem = mPoliciesItem;
    }


    public static class ViewHolder extends  RecyclerView.ViewHolder {
        public TextView p_name;
        public TextView p_description;
     //   public TextView v_us;
        // public ImageView p_image_id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            p_name=(TextView)itemView.findViewById(R.id.policy_name_view);
            p_description=(TextView)itemView.findViewById(R.id.policy_description_view);
          //  v_us=(TextView)itemView.findViewById(R.id.visit_us_button);
           // p_image_id=(ImageView) itemView.findViewById(R.id.policy_image_view);


        }
    }

  /**  public void setPoliciesAdapter(ArrayList<PoliciesClass> PolicyItem)
    {
        mPoliciesItem=PolicyItem;
    }**/

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        return (new ViewHolder(v));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PoliciesClass currentPolicy = mPoliciesItem.get(position);
        holder.p_name.setText(currentPolicy.getmPolicy_name());
        holder.p_description.setText(currentPolicy.getmPolicy_description());
      //  holder.v_us.setText(currentPolicy.getmVisit_us());
        //holder.p_image_id.setImageResource(currentPolicy.getmPolicy_image_id());
    }

    /** if (mPoliciesItem != null) {
     PoliciesClass currentPolicy =mPoliciesItem.get(position);

     holder.p_name.setText(currentPolicy.getPolicy_name());
     holder.p_description.setText(currentPolicy.getPolicy_description());
     holder.v_us.setText(currentPolicy.getVisit_us());

     Glide.with(context)
     .load(currentPolicy.getPolicy_image_id())
     .thumbnail(Glide.with(context).load(R.raw.load))
     .into(holder.p_image_id);

     Log.e("image", currentPolicy.getImage());
     }S


     } else {
     holder.p_name.setText("Loading ...");
     }
     }**/

    @Override
    public int getItemCount() {
        return mPoliciesItem.size();
    }
}
