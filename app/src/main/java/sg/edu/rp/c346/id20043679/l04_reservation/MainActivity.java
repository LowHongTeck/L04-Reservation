package sg.edu.rp.c346.id20043679.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = name.getText().toString();


            }
        });


    }
}