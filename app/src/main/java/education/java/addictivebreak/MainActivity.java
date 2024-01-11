package education.java.addictivebreak;

import static java.lang.String.valueOf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView, recyclerView1, recyclerView2, recyclerView3;
    DatabaseReference databaseReference, databaseReference1, databaseReference2, databaseReference3, databaseReference4;
    ArrayList<Inbox> inboxArrayList;
    ArrayList<Exercise> exerciseArrayList;
    ArrayList<Meditation> meditationArrayList;
    ArrayList<Healthy> healthyArrayList;
    TextView btnknows, btnroutin, btnexercise, btnmeditation, btnhealthy;
    LinearLayout knows, routinlayout, routinmenu, knowlegdelayout;
    ImageView upbtn, downbtn;
    Animation toup, todown;
    Button btnstart;
    TextView startdate, currdate;
    String email;

    public void contest(RecyclerView recyclerView){
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setHasFixedSize(true);
    }
    public void knowledge(){
        knowlegdelayout.setVisibility(View.VISIBLE);
        routinlayout.setVisibility(View.INVISIBLE);
        routinmenu.setVisibility(View.INVISIBLE);
        btnroutin.setBackground(getResources().getDrawable(R.drawable.bottomline));
        btnknows.setBackground(getResources().getDrawable(R.drawable.bottomlinemenu));
    }
    public void routine(){
        knowlegdelayout.setVisibility(View.INVISIBLE);
        routinlayout.setVisibility(View.VISIBLE);
        routinmenu.setVisibility(View.VISIBLE);
        btnknows.setBackground(getResources().getDrawable(R.drawable.bottomline));
        btnroutin.setBackground(getResources().getDrawable(R.drawable.bottomlinemenu));
    }
    public void exercise(){
        recyclerView1.setVisibility(View.VISIBLE);
        recyclerView2.setVisibility(View.INVISIBLE);
        recyclerView3.setVisibility(View.INVISIBLE);
        btnexercise.setBackground(getResources().getDrawable(R.drawable.bottomlinesmall));
        btnmeditation.setBackground(getResources().getDrawable(R.drawable.bottomline));
        btnhealthy.setBackground(getResources().getDrawable(R.drawable.bottomline));
    }
    public void meditation(){
        recyclerView1.setVisibility(View.INVISIBLE);
        recyclerView2.setVisibility(View.VISIBLE);
        recyclerView3.setVisibility(View.INVISIBLE);
        btnexercise.setBackground(getResources().getDrawable(R.drawable.bottomline));
        btnmeditation.setBackground(getResources().getDrawable(R.drawable.bottomlinesmall));
        btnhealthy.setBackground(getResources().getDrawable(R.drawable.bottomline));
    }
    public void healthy(){
        recyclerView1.setVisibility(View.INVISIBLE);
        recyclerView2.setVisibility(View.INVISIBLE);
        recyclerView3.setVisibility(View.VISIBLE);
        btnexercise.setBackground(getResources().getDrawable(R.drawable.bottomline));
        btnmeditation.setBackground(getResources().getDrawable(R.drawable.bottomline));
        btnhealthy.setBackground(getResources().getDrawable(R.drawable.bottomlinesmall));
    }

    public void openDialog(){
        AcceptDialog acceptDialog = new AcceptDialog(email);
        acceptDialog.show(getSupportFragmentManager(), "acceptdialog");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleinbox);
        recyclerView1 = findViewById(R.id.recycleexercise);
        recyclerView2 = findViewById(R.id.recyclemeditation);
        recyclerView3 = findViewById(R.id.recyclehealthy);
        upbtn = findViewById(R.id.upbtn);
        downbtn = findViewById(R.id.downbtn);
        knows = findViewById(R.id.knows);
        downbtn.setVisibility(View.INVISIBLE);
        routinlayout = findViewById(R.id.routinlayout);
        knowlegdelayout = findViewById(R.id.knowledgelayout);
        routinmenu = findViewById(R.id.routinmenu);

        btnknows = findViewById(R.id.btnknow);
        btnroutin = findViewById(R.id.btnroutine);
        btnexercise = findViewById(R.id.btnexercise);
        btnmeditation = findViewById(R.id.btnmeditation);
        btnhealthy = findViewById(R.id.btnhealthy);
        btnstart = findViewById(R.id.btnstart);
        startdate = findViewById(R.id.startdate);
        currdate = findViewById(R.id.currdate);

        btnstart.setOnClickListener(View->openDialog());

        knows.setAlpha(0);
        toup = AnimationUtils.loadAnimation(this, R.anim.layout_up);
        todown = AnimationUtils.loadAnimation(this, R.anim.layout_down);

        btnroutin.setOnClickListener(View->routine());
        btnknows.setOnClickListener(View->knowledge());

        btnexercise.setOnClickListener(View->exercise());
        btnmeditation.setOnClickListener(View->meditation());
        btnhealthy.setOnClickListener(View->healthy());

        btnroutin.setBackground(getResources().getDrawable(R.drawable.bottomline));
        btnknows.setBackground(getResources().getDrawable(R.drawable.bottomlinemenu));

        email = getIntent().getStringExtra("email");


        upbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                knows.startAnimation(toup);
                knows.setAlpha(1);
                knows.setVisibility(View.VISIBLE);
                downbtn.setVisibility(View.VISIBLE);
                upbtn.setVisibility(View.INVISIBLE);
            }
        });

        downbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                knows.setVisibility(View.INVISIBLE);
                knows.startAnimation(todown);
                knows.setAlpha(0);
                downbtn.setVisibility(View.INVISIBLE);
                upbtn.setVisibility(View.VISIBLE);
            }
        });

        healthyArrayList = new ArrayList<>();
        inboxArrayList = new ArrayList<>();
        exerciseArrayList = new ArrayList<>();
        meditationArrayList = new ArrayList<>();
        contest(recyclerView);
        contest(recyclerView1);
        contest(recyclerView2);
        contest(recyclerView3);
        databaseReference = FirebaseDatabase.getInstance().getReference("Inbox");
        databaseReference1 = FirebaseDatabase.getInstance().getReference("Exercise");
        databaseReference2 = FirebaseDatabase.getInstance().getReference("Meditation");
        databaseReference3 = FirebaseDatabase.getInstance().getReference("Healthy");
        databaseReference4 = FirebaseDatabase.getInstance().getReference("Account");
        RadarChart radarChart = findViewById(R.id.mikephil);

        ArrayList<RadarEntry> radarEntryArrayList1 = new ArrayList<>();
        radarEntryArrayList1.add(new RadarEntry(100));
        radarEntryArrayList1.add(new RadarEntry(300));
        radarEntryArrayList1.add(new RadarEntry(200));
        radarEntryArrayList1.add(new RadarEntry(150));

        RadarDataSet radarDataSet1 = new RadarDataSet(radarEntryArrayList1, "Physical");
        radarDataSet1.setColor(Color.BLACK);
        radarDataSet1.setLineWidth(2f);
        radarDataSet1.setValueTextColor(Color.BLACK);
        radarDataSet1.setValueTextSize(14f);

        //--------------------------------------------------------------------------------------------------------

        ArrayList<RadarEntry> radarEntryArrayList2 = new ArrayList<>();
        radarEntryArrayList2.add(new RadarEntry(150));
        radarEntryArrayList2.add(new RadarEntry(200));
        radarEntryArrayList2.add(new RadarEntry(300));
        radarEntryArrayList2.add(new RadarEntry(100));

        RadarDataSet radarDataSet2 = new RadarDataSet(radarEntryArrayList2, "Mental");
        radarDataSet2.setColor(Color.BLUE);
        radarDataSet2.setLineWidth(2f);
        radarDataSet2.setValueTextColor(Color.BLUE);
        radarDataSet2.setValueTextSize(14f);

        //--------------------------------------------------------------------------------------------------------

        int red = getResources().getColor(R.color.red);
        int orange = getResources().getColor(R.color.orange);

        ArrayList<RadarEntry> radarEntryArrayList3 = new ArrayList<>();
        radarEntryArrayList3.add(new RadarEntry(300));
        radarEntryArrayList3.add(new RadarEntry(150));
        radarEntryArrayList3.add(new RadarEntry(200));
        radarEntryArrayList3.add(new RadarEntry(100));

        RadarDataSet radarDataSet3 = new RadarDataSet(radarEntryArrayList3, "Spiritual");
        radarDataSet3.setColor(red);
        radarDataSet3.setLineWidth(2f);
        radarDataSet3.setValueTextColor(red);
        radarDataSet3.setValueTextSize(14f);

        //--------------------------------------------------------------------------------------------------------

        ArrayList<RadarEntry> radarEntryArrayList4 = new ArrayList<>();
        radarEntryArrayList4.add(new RadarEntry(200));
        radarEntryArrayList4.add(new RadarEntry(300));
        radarEntryArrayList4.add(new RadarEntry(150));
        radarEntryArrayList4.add(new RadarEntry(100));

        RadarDataSet radarDataSet4 = new RadarDataSet(radarEntryArrayList4, "Sexual health");
        radarDataSet4.setColor(orange);
        radarDataSet4.setLineWidth(2f);
        radarDataSet4.setValueTextColor(orange);
        radarDataSet4.setValueTextSize(14f);


        RadarData radarData = new RadarData();
        radarData.addDataSet(radarDataSet1);
        radarData.addDataSet(radarDataSet2);
        radarData.addDataSet(radarDataSet3);
        radarData.addDataSet(radarDataSet4);

        String[] labels = {"Energy", "Performance", "Ability", "Confidence"};

        XAxis xAxis1 = radarChart.getXAxis();
        xAxis1.setValueFormatter(new IndexAxisValueFormatter(labels));
        radarChart.setData(radarData);


        databaseReference4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds: snapshot.getChildren()){
                    Account account = ds.getValue(Account.class);
                    if(account.email.equals(email)){
                        if(!account.starting.isEmpty()) {
                            btnstart.setVisibility(View.INVISIBLE);
                            startdate.setVisibility(View.VISIBLE);
                            currdate.setVisibility(View.VISIBLE);
                            startdate.setText(account.starting);
                            String toyBornTime = account.starting;
                            String sDate = account.starting;
                            String eDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");

                            String startDateStr = account.starting;;
                            String endDateStr = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(new Date());

                            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

                            try {
                                // Parsing string dates to Date objects
                                Date startDate = format.parse(startDateStr);
                                Date endDate = format.parse(endDateStr);

                                // Calculating the difference in milliseconds
                                long differenceMillis = endDate.getTime() - startDate.getTime();

                                // Converting milliseconds to days
                                long differenceDays = TimeUnit.DAYS.convert(differenceMillis, TimeUnit.MILLISECONDS);

                                //System.out.println("Difference in days: " + differenceDays);
                                currdate.setText("The current day: "+ differenceDays);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds: snapshot.getChildren()){
                    Inbox inbox = ds.getValue(Inbox.class);
                    inboxArrayList.add(inbox);
                }
                InboxAdapter inboxAdapter = new InboxAdapter(MainActivity.this, inboxArrayList);
                recyclerView.setAdapter(inboxAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error){}
        });

        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds: snapshot.getChildren()){
                    Exercise exercise = ds.getValue(Exercise.class);
                    exerciseArrayList.add(exercise);
                }
                ExerciseAdapter exerciseAdapter = new ExerciseAdapter(MainActivity.this, exerciseArrayList);
                recyclerView1.setAdapter(exerciseAdapter);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds: snapshot.getChildren()){
                    Meditation meditation = ds.getValue(Meditation.class);
                    meditationArrayList.add(meditation);
                }
                MeditaionAdapter meditaionAdapter = new MeditaionAdapter(MainActivity.this, meditationArrayList);
                recyclerView2.setAdapter(meditaionAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

        databaseReference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds: snapshot.getChildren()){
                    Healthy healthy = ds.getValue(Healthy.class);
                    healthyArrayList.add(healthy);
                }
                HealthyAdapter healthyAdapter = new HealthyAdapter(MainActivity.this, healthyArrayList);
                recyclerView3.setAdapter(healthyAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });

    }
}