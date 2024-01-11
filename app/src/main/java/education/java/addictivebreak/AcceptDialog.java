package education.java.addictivebreak;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AcceptDialog extends AppCompatDialogFragment {

    String email;
    DatabaseReference databaseReference;

    public AcceptDialog(String email) {
        this.email = email;
    }

    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState){
        databaseReference = FirebaseDatabase.getInstance().getReference("Account");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("What you need?")
                .setMessage("Developing a strong and resilient personality can play a crucial role in overcoming challenges, including breaking habits like watching porn. " +
                        "Here are some aspects of your personality that you can focus on to support your efforts in stopping porn consumption:\n\n\n"+
                        "• Self-Discipline.\n\n" +
                        "• Self-Awareness.\n\n" +
                        "• Emotional Regulation.\n\n" +
                        "• Resilience.\n\n" +
                        "• Mindfulness.\n\n" +
                        "• Assertiveness.\n\n" +
                        "• Goal-Oriented Mindset.\n\n" +
                        "• Positive Self-Talk.\n\n" +
                        "• Curiosity and Learning.\n\n" +
                        "• Patience, Patience, Patience.\n\n\n" +
                        "NEVER! NEVER! NEVER! WATCHING ANYMORE.")
                .setPositiveButton("start", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                        databaseReference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for(DataSnapshot ds: snapshot.getChildren()){
                                    Account account = ds.getValue(Account.class);
                                    if(account.email.equals(email)){
                                        databaseReference.child(ds.getKey()).child("starting").setValue(date);
                                    }
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {}
                        });

                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();
    }
}
