package sg.edu.rp.c346.id20043679.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText phone;
    EditText grpSize;
    DatePicker dp;
    TimePicker tp;
    CheckBox cbSmoke;
    Button submit;
    Button reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextName);
        phone = findViewById(R.id.editTextNumber);
        grpSize = findViewById(R.id.editTextGSize);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        cbSmoke = findViewById(R.id.checkBox);
        submit = findViewById(R.id.submit);
        reset = findViewById(R.id.reset);



        Calendar thisYear = Calendar.getInstance();
        int currentYear = thisYear.get(Calendar.YEAR);
        int currentMonth = thisYear.get(Calendar.MONTH);
        int currentDay = thisYear.get(Calendar.DAY_OF_MONTH);

        dp.updateDate(currentYear,currentMonth,currentDay + 1);
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);
        dp.setMinDate(System.currentTimeMillis()+ 86400000); //86400000 is 1 day in milliseconds



        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if (hourOfDay > 20){
                    tp.setCurrentHour(20);
                }

                if (hourOfDay < 8){
                    tp.setCurrentHour(8);
                }

            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = name.getText().toString();
                String strPhone = phone.getText().toString();
                String strGrpSize = grpSize.getText().toString();

                String smokeArea = "";

                if (cbSmoke.isChecked()){
                    smokeArea = "Seated at Smoking Area";
                } else {
                    smokeArea = "Seated at Non-Smoking Area";
                }

                String confirmation = String.format("[CONFIRMATION DETAILS]\nName: %s\nPhone Number: %s\nGroup Size: %s" +
                        "\nSeat: %s\nDate: %d/%d/%d\nTime: %d:%d", strName, strPhone, strGrpSize, smokeArea,dp.getDayOfMonth(),dp.getMonth()+1,dp.getYear(),tp.getCurrentHour(),tp.getCurrentMinute());

                if (strName.isEmpty() || strPhone.isEmpty() || strGrpSize.isEmpty()){
                    Toast.makeText(MainActivity.this, "There are empty fields", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(MainActivity.this, confirmation, Toast.LENGTH_SHORT).show();
                }


            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name.setText("");
                phone.setText("");
                grpSize.setText("");
                cbSmoke.setChecked(false);
                dp.updateDate(currentYear,currentMonth,currentDay + 1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
            }
        });


    }
}