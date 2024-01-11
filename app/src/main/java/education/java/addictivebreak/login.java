package education.java.addictivebreak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class login extends AppCompatActivity {
    EditText email, pass;
    Button btn;
    TextView mno;
    DatabaseReference databaseReference;
    ArrayList<Account> accountArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        mno = findViewById(R.id.mno);
        pass = findViewById(R.id.pass);
        btn = findViewById(R.id.btn);
        accountArrayList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("Account");

        mno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ints = new Intent(login.this, signup.class);
                startActivity(ints);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot ds: snapshot.getChildren()){
                            Account account = ds.getValue(Account.class);
                            if(email.getText().toString().equals(account.email)){
                                if(pass.getText().toString().equals(account.pass)){
                                    Intent ints = new Intent(login.this, MainActivity.class);
                                    ints.putExtra("email",email.getText().toString());
                                    startActivity(ints);
                                }else{
                                    Toast.makeText(login.this, "Something went wrong", Toast.LENGTH_LONG).show();
                                }
                            }else{
                                Toast.makeText(login.this, "Something went wrong", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {}
                });
            }
        });

    }
}