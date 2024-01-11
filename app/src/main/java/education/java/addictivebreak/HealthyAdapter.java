package education.java.addictivebreak;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HealthyAdapter extends RecyclerView.Adapter<HealthyAdapter.MyViewHolder> {
    Context ctx;
    ArrayList<Healthy> healthyArrayList;

    public HealthyAdapter(Context ctx, ArrayList<Healthy> healthyArrayList) {
        this.ctx = ctx;
        this.healthyArrayList = healthyArrayList;
    }

    @NonNull
    @Override
    public HealthyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.routinitem, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HealthyAdapter.MyViewHolder holder, int position) {
        Healthy healthy = healthyArrayList.get(position);
        holder.title.setText(healthy.title);
        holder.detail.setText(healthy.detail);
        holder.d1.setText(healthy.d1);
        holder.d2.setText(healthy.d2);
        holder.d3.setText(healthy.d3);
        holder.d4.setText(healthy.d4);
        holder.d5.setText(healthy.d5);
        holder.d6.setText(healthy.d6);
        holder.d7.setText(healthy.d7);
        Picasso.get().load(healthy.image).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return healthyArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, detail, d1, d2, d3, d4, d5, d6, d7;
        ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            detail = itemView.findViewById(R.id.detail);
            d1 = itemView.findViewById(R.id.d1);
            d2 = itemView.findViewById(R.id.d2);
            d3 = itemView.findViewById(R.id.d3);
            d4 = itemView.findViewById(R.id.d4);
            d5 = itemView.findViewById(R.id.d5);
            d6 = itemView.findViewById(R.id.d6);
            d7 = itemView.findViewById(R.id.d7);
            img = itemView.findViewById(R.id.img);
        }
    }
}
