package education.java.addictivebreak;

import static java.lang.String.valueOf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class healthyquiz extends AppCompatActivity {
    Button n1, a1, s1, n2, a2, s2, n3, a3, s3, n, a, s, nextbutton;
    DatabaseReference databaseReference;
    String email;
    int resultfinal = 0;
    static double r = 0;

    public void updateresult(double result){
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Toast.makeText(healthyquiz.this, email, Toast.LENGTH_SHORT).show();
                  databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot ds: snapshot.getChildren()){
                            Account account = ds.getValue(Account.class);
                            if(account.email.equals(email)){
                                databaseReference.child(ds.getKey()).child("mental").setValue(resultfinal);
                            }
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {}
                });*/

                Toast.makeText(healthyquiz.this, valueOf(result), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void btn1(Button button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button==n){
                    r=0;
                    resultfinal += r;
                }else if(button==s){
                    r=0.5;
                    resultfinal += r;
                }else if(button==a){
                    r=0.9;
                    resultfinal += r;
                }
            }
        });
    }

    public void btn2(Button button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button==n1){
                    r=0;
                    resultfinal += r;
                    Toast.makeText(healthyquiz.this, valueOf(r), Toast.LENGTH_SHORT).show();
                }else if(button==s1){
                    r=0.5;
                    resultfinal += r;
                    Toast.makeText(healthyquiz.this, valueOf(r), Toast.LENGTH_SHORT).show();
                }else if(button==a1){
                    r=0.9;
                    resultfinal += r;
                    Toast.makeText(healthyquiz.this, valueOf(r), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void btn3(Button button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button==n2){
                    r=0;
                    resultfinal += r;
                    Toast.makeText(healthyquiz.this, valueOf(r), Toast.LENGTH_SHORT).show();
                }else if(button==s2){
                    r=0.5;
                    resultfinal += r;
                    Toast.makeText(healthyquiz.this, valueOf(r), Toast.LENGTH_SHORT).show();
                }else if(button==a2){
                    r=0.9;
                    resultfinal += r;
                    Toast.makeText(healthyquiz.this, valueOf(r), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void btn4(Button button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button==n3){
                    r=0;
                    resultfinal += r;
                    Toast.makeText(healthyquiz.this, valueOf(r), Toast.LENGTH_SHORT).show();
                }else if(button==s3){
                    r=0.5;
                    resultfinal += r;
                    Toast.makeText(healthyquiz.this, valueOf(r), Toast.LENGTH_SHORT).show();
                }else if(button==a3){
                    r=0.9;
                    resultfinal += r;
                    Toast.makeText(healthyquiz.this, valueOf(r), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthyquiz);

        email=getIntent().getStringExtra("email");
        databaseReference=FirebaseDatabase.getInstance().getReference("Account");
        n1=findViewById(R.id.n1);
        n2=findViewById(R.id.n2);
        n3=findViewById(R.id.n3);
        n=findViewById(R.id.n);
        a=findViewById(R.id.a);
        a1=findViewById(R.id.a1);
        a3=findViewById(R.id.a3);
        a2=findViewById(R.id.a2);
        s=findViewById(R.id.s);
        s1=findViewById(R.id.s1);
        s2=findViewById(R.id.s2);
        s3=findViewById(R.id.s3);
        nextbutton=findViewById(R.id.nextbutton);

        btn1(a);  btn1(n);  btn1(s);
        btn2(a1); btn2(n1); btn2(s1);
        btn3(a2); btn3(n2); btn3(s2);
        btn4(a3); btn4(n3); btn4(s3);

    }
}