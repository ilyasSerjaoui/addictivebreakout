package education.java.addictivebreak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class signup extends AppCompatActivity {
    DatabaseReference databaseReference;
    EditText fullname, email, pass1, pass2, d, m, y, s, ay;
    Button btn;
    TextView btl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        databaseReference = FirebaseDatabase.getInstance().getReference("Account");
        fullname = findViewById(R.id.fullname);
        btl = findViewById(R.id.btl);
        email = findViewById(R.id.email);
        pass1 = findViewById(R.id.pass1);
        pass2 = findViewById(R.id.pass2);
        d = findViewById(R.id.d);
        m = findViewById(R.id.m);
        y = findViewById(R.id.y);
        s = findViewById(R.id.s);
        ay = findViewById(R.id.ay);
        btn = findViewById(R.id.btn);

        btl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ints = new Intent(signup.this, login.class);
                startActivity(ints);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!fullname.getText().toString().isEmpty()){
                    if(!email.getText().toString().isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
                        if(!pass1.getText().toString().isEmpty() && pass1.getText().toString().length() >= 8){
                            if(pass1.getText().toString().equals(pass2.getText().toString())){
                                if(Integer.parseInt(d.getText().toString()) <= 31 && Integer.parseInt(d.getText().toString()) >= 0){
                                    if(Integer.parseInt(m.getText().toString()) <= 12 && Integer.parseInt(m.getText().toString()) >= 0){
                                        if(Integer.parseInt(y.getText().toString()) <= 2005 && Integer.parseInt(y.getText().toString()) >= 1973){
                                            if(!s.getText().toString().isEmpty()){
                                                if(s.getText().toString().equals("male") || s.getText().toString().equals("female")){
                                                    if(Integer.parseInt(ay.getText().toString()) >= 0){
                                                        sendInfo();
                                                    }else{
                                                        Toast.makeText(signup.this, "Please, put how many years on addiction.", Toast.LENGTH_LONG).show();
                                                    }
                                                }else{
                                                    Toast.makeText(signup.this, "Please, choose your sex: male or female.", Toast.LENGTH_LONG).show();
                                                }
                                            }else{
                                                Toast.makeText(signup.this, "Please, choose your sex: male or female.", Toast.LENGTH_LONG).show();
                                            }
                                        }else{
                                            Toast.makeText(signup.this, "Please, select your birth date.", Toast.LENGTH_LONG).show();
                                        }
                                    }else{
                                        Toast.makeText(signup.this, "Please, select your birth date.", Toast.LENGTH_LONG).show();
                                    }
                                }else{
                                    Toast.makeText(signup.this, "Please, select your birth date.", Toast.LENGTH_LONG).show();
                                }
                            }else{
                                Toast.makeText(signup.this, "something went wrong on password.", Toast.LENGTH_LONG).show();
                            }
                        }else{
                            Toast.makeText(signup.this, "something went wrong on password.", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(signup.this, "something went wrong on email.", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(signup.this, "select your full name.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void sendInfo(){
        Account account = new Account(fullname.getText().toString(), email.getText().toString(),
                pass1.getText().toString(), d.getText().toString(), m.getText().toString(),
                y.getText().toString(), s.getText().toString(), ay.getText().toString(), "nofap", "", "", "", "", "");
        Intent ints = new Intent(signup.this, healthyquiz.class);
        ints.putExtra("email", email.getText().toString());
        startActivity(ints);
        databaseReference.push().setValue(account);
        fullname.setText("");
        email.setText("");
        pass1.setText("");
        pass2.setText("");
        d.setText("");
        m.setText("");
        y.setText("");
        s.setText("");
        ay.setText("");
    }
}