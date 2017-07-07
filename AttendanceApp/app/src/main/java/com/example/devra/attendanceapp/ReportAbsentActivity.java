package com.example.devra.attendanceapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ReportAbsentActivity extends AppCompatActivity {

    private static RadioGroup radio_grp;
    private static RadioButton radio_btn;
    private static Button button_abssbm;
    Toast abs_start, abs_end, abs_reason;
    Button btn_start, btn_end;
    int year_x, month_x, day_x;
    EditText daysno;
    static final int DIALOG_ID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_absent);
        onClickListnerButtonAbs();
        showDialogStart();
        noOfDays();
    }

    public void showDialogStart(){
        btn_start = (Button)findViewById(R.id.buttonAbsentStartDate);
        btn_start.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }

    public void noOfDays(){
        daysno = (EditText)findViewById(R.id.editTextDays);
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if (id==DIALOG_ID)
            return new DatePickerDialog(this, dpickerListner, year_x, month_x, day_x);
        return null;
    }


    private DatePickerDialog.OnDateSetListener dpickerListner = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_x = year;
            month_x = monthOfYear;
            day_x = dayOfMonth;
        }
    };


    public void onClickListnerButtonAbs(){
        radio_grp = (RadioGroup)findViewById(R.id.rg_absent);
        button_abssbm = (Button)findViewById(R.id.buttonAbsentSubmit);

        button_abssbm.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        int selected_id = radio_grp.getCheckedRadioButtonId();
                        radio_btn = (RadioButton)findViewById(selected_id);
                        Toast abs_reason = Toast.makeText(ReportAbsentActivity.this,
                                radio_btn.getText().toString(),Toast.LENGTH_SHORT);

                        Intent intent3 = null, chooser = null;

                        intent3 = new Intent(Intent.ACTION_SEND);
                        intent3.setData(Uri.parse("mailto:"));
                        String[] to={"devrajbanerjee@yahoo.com","devraj.banerjee@triosstudent.com"}; //Put "To" emial IDs here
                        intent3.putExtra(Intent.EXTRA_EMAIL, to);
                        intent3.putExtra(Intent.EXTRA_SUBJECT, "Devraj is absent");
                        intent3.putExtra(Intent.EXTRA_TEXT, "Name: Devraj      ID:12345     Status: Absent    Reason: "+radio_btn.getText()+"   From: "+year_x+"/"+month_x+"/"+day_x+"    For: "+daysno.getText()+" days");
                        intent3.setType("message/rfc822");
                        chooser = Intent.createChooser(intent3, "Send email");
                        startActivity(chooser);
                    }
                }
        );
    }
}
