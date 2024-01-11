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

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.MyViewHolder> {
    Context ctx;
    ArrayList<Exercise> exerciseArrayList;

    public ExerciseAdapter(Context ctx, ArrayList<Exercise> exerciseArrayList) {
        this.ctx = ctx;
        this.exerciseArrayList = exerciseArrayList;
    }

    @NonNull
    @Override
    public ExerciseAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.routinitem, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseAdapter.MyViewHolder holder, int position) {
        Exercise exercise = exerciseArrayList.get(position);
        holder.title.setText(exercise.title);
        holder.detail.setText(exercise.detail);
        holder.d1.setText(exercise.d1);
        holder.d2.setText(exercise.d2);
        holder.d3.setText(exercise.d3);
        holder.d4.setText(exercise.d4);
        holder.d5.setText(exercise.d5);
        holder.d6.setText(exercise.d6);
        holder.d7.setText(exercise.d7);
        Picasso.get().load(exercise.image).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return exerciseArrayList.size();
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
