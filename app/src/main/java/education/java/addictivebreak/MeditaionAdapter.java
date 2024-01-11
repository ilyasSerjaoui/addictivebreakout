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

public class MeditaionAdapter extends RecyclerView.Adapter<MeditaionAdapter.MyViewHolder> {
    Context ctx;
    ArrayList<Meditation> meditationArrayList;
    public MeditaionAdapter(Context ctx, ArrayList<Meditation> meditationArrayList) {
        this.ctx = ctx;
        this.meditationArrayList = meditationArrayList;
    }

    @NonNull
    @Override
    public MeditaionAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.routinitem, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MeditaionAdapter.MyViewHolder holder, int position) {
        Meditation meditation = meditationArrayList.get(position);
        holder.title.setText(meditation.title);
        holder.detail.setText(meditation.detail);
        holder.d1.setText(meditation.d1);
        holder.d2.setText(meditation.d2);
        holder.d3.setText(meditation.d3);
        holder.d4.setText(meditation.d4);
        holder.d5.setText(meditation.d5);
        holder.d6.setText(meditation.d6);
        holder.d7.setText(meditation.d7);
        Picasso.get().load(meditation.image).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return meditationArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
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
