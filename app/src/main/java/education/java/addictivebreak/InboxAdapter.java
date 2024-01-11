package education.java.addictivebreak;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InboxAdapter extends RecyclerView.Adapter<InboxAdapter.MyViewHolder> {
    Context ctx;
    ArrayList<Inbox> inboxArrayList;

    public InboxAdapter(Context ctx, ArrayList<Inbox> inboxArrayList) {
        this.ctx = ctx;
        this.inboxArrayList = inboxArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.itemibox, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Inbox inbox = inboxArrayList.get(position);
        holder.title.setText(inbox.title);
        holder.text.setText(inbox.text);

    }

    @Override
    public int getItemCount() {
        return inboxArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title, text;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            text = itemView.findViewById(R.id.text);
        }
    }
}
