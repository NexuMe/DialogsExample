package com.example.dialogsexample;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private TextView textViewDate, textViewTime;
    Button buttonDate, buttonTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDate = findViewById(R.id.buttonDate);
        textViewDate = findViewById(R.id.textViewDate);
        buttonTime = findViewById(R.id.buttonTime);
        textViewTime = findViewById(R.id.textViewTime);

        // --- AlertDialog --- начало --->
        // 1. Иницииране на диалоговия прозорец чрез неговия конструктор
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 2. Привързване на различни setters методи, свързани с характеристиките на диалога
        builder.setMessage("Да се запазят ли данните?")
                .setTitle("Заглавие")
                .setCancelable(false)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Действие на бутона "Да"
                    }
                })
                .setNegativeButton("Не", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Действие на бутона "Не"
                        // затваряне на диалога
                        dialog.cancel();
                    }
                });
        // 3. Създаване на диалога
        AlertDialog dialog = builder.create();
        dialog.show();
        // --- AlertDialog --- край ---/

        // --- DatePickerDialog --- начало --->
        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // определяне на текущата дата
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                // Тъй като номерацията на месеците започва от "0",
                                // при установяване на датата да увеличим променливата "monthOfYear" с 1.
                                textViewDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });
        // --- DatePickerDialog --- край ---/

        // --- TimePickerDialog --- начало --->
        buttonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // определяне на текущият час
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minute = cldr.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hour, int minute) {

                                textViewTime.setText(hour + ":" + minute);
                            }
                        }, hour, minute, true);
                timePickerDialog.show();
            }
        });
        // --- TimePickerDialog --- край ---/
    }


}