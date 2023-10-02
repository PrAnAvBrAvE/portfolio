package com.darkness.eventmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import com.darkness.eventmanager.adapter.MyAdapter;
import com.darkness.eventmanager.databasehelper.DbHelper;
import com.darkness.eventmanager.model.Event;
import com.darkness.eventmanager.receiver.AlarmReceiver;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class EventDisplayerActivity extends AppCompatActivity implements OnEventClickListener{

    Button setDateTime,setEvent;
    RecyclerView mRecyclerView;
    MyAdapter myAdapter;
    ArrayList<Event>events;
    DbHelper dbHelper;
    RelativeLayout setAlarmLayout;
    FloatingActionButton addEvent;
    EditText titleEdit,dateEdit,timeEdit;
    Calendar calendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_displayer);
        calendar = Calendar.getInstance();
        

        
        setAlarmLayout = findViewById(R.id.setAlarm);

        timeEdit = findViewById(R.id.timeText);
        titleEdit = findViewById(R.id.titleText);
        dateEdit = findViewById(R.id.dateText);

        dbHelper = new DbHelper(this);

        events = new ArrayList<>();

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this,events,this);
        mRecyclerView.setAdapter(myAdapter);

        setDateTime = findViewById(R.id.setDT);
        setEvent = findViewById(R.id.btnAdd);

        setDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(EventDisplayerActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, final int month, int dayOfMonth) {
                        dateEdit.setText(dayOfMonth+":"+month+":"+year);
                        calendar.set(year,month,dayOfMonth);
                        TimePickerDialog timePickerDialog = new TimePickerDialog(EventDisplayerActivity.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                timeEdit.setText(hourOfDay+":"+minute);
                                calendar.set(Calendar.MINUTE,minute);
                                calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                                setEvent.setEnabled(true);
                            }
                        },0,0,false);
                        timePickerDialog.show();
                    }
                },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),1);
                datePickerDialog.show();
            }

        });

        addEvent = findViewById(R.id.addEvent);
        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setAlarmLayout.getVisibility() == View.GONE){
                    setAlarmLayout.setVisibility(View.VISIBLE);
                    addEvent.hide();
                }
            }
        });


        setEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(titleEdit.getText().toString().isEmpty()||titleEdit.getText().toString().equals("")){
                    Toast.makeText(EventDisplayerActivity.this, "Enter Title of Event !", Toast.LENGTH_SHORT).show();
                }else {
                    saveNewEvent();
                    setAlarmLayout.setVisibility(View.GONE);
                    addEvent.show();
                }
            }
        });

        fillRecyclerView();

    }

    private void saveNewEvent() {
        AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService(ALARM_SERVICE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault());
        Intent intent = new Intent(EventDisplayerActivity.this, AlarmReceiver.class);
        intent.setType("myalarm://"+dateFormat.format(calendar.getTimeInMillis()));
        intent.putExtra("title",titleEdit.getText().toString());
        intent.putExtra("date",dateFormat.format(calendar.getTimeInMillis()));
        int rc = (int)System.currentTimeMillis()/100;
        PendingIntent pendingIntent = PendingIntent.getBroadcast(EventDisplayerActivity.this,rc,intent,PendingIntent.FLAG_ONE_SHOT);
        assert alarmManager != null;
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
        dbHelper.insertNewEvent(titleEdit.getText().toString(),String.valueOf(calendar.getTimeInMillis()),dateFormat.format(calendar.getTimeInMillis()),rc);
        fillRecyclerView();
        Toast.makeText(this, "Event Added !\n"+dateFormat.format(calendar.getTimeInMillis()), Toast.LENGTH_SHORT).show();
    }



    private void fillRecyclerView() {
        events.clear();
        Cursor allEvents = dbHelper.getAllEvents();
        if(allEvents != null){
            if(allEvents.moveToFirst()){
                do{
                    Event event = new Event();
                    String title,time,readable;
                    int id,rc;
                    title = allEvents.getString(allEvents.getColumnIndex(DbHelper.EVENT_COLUMN_TITLE));
                    time = allEvents.getString(allEvents.getColumnIndex(DbHelper.EVENT_COLUMN_TIME));
                    readable = allEvents.getString(allEvents.getColumnIndex(DbHelper.EVENT_COLUMN_READABLE_DATE));
                    id = allEvents.getInt(allEvents.getColumnIndex(DbHelper.EVENT_COLUMN_ID));
                    rc = allEvents.getInt(allEvents.getColumnIndex(DbHelper.EVENT_COLUMN_REQUEST_CODE));
                    event.setTitle(title);
                    event.setId(id);
                    event.setTime(time);
                    event.setReadable_date(readable);
                    event.setRc(rc);
                    events.add(event);
                }while (allEvents.moveToNext());
                myAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onClickListener(int position) {
        Intent intent = new Intent(EventDisplayerActivity.this, AlarmReceiver.class);
        intent.setType("myalarm://"+events.get(position).getReadable_date());
        boolean isAvail = (PendingIntent.getBroadcast(EventDisplayerActivity.this,0,intent,PendingIntent.FLAG_NO_CREATE) != null);
        if(isAvail){
            AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
            assert alarmManager != null;
            alarmManager.cancel( PendingIntent.getBroadcast(EventDisplayerActivity.this,0,intent,0));
            dbHelper.deleteEvent(events.get(position).getReadable_date());
            Toast.makeText(this, "Event Deleted Successfully !", Toast.LENGTH_SHORT).show();
            events.clear();
            fillRecyclerView();
        }



    }
}
