package com.example.devra.attendanceapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ReportLateActivity extends AppCompatActivity {

    private static RadioGroup radio_g;
    private static RadioButton radio_b;
    private static Button button_sbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_late);
        onClickListnerButtonLate();
    }

    public void onClickListnerButtonLate(){
        radio_g = (RadioGroup)findViewById(R.id.rgLate);
        button_sbm = (Button)findViewById(R.id.buttonLateSubmit);

        button_sbm.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        int selected_id = radio_g.getCheckedRadioButtonId();
                        radio_b = (RadioButton)findViewById(selected_id);
                        Toast late_message = Toast.makeText(ReportLateActivity.this,
                                radio_b.getText().toString(),Toast.LENGTH_SHORT);

                        Intent intent2 = null, chooser = null;

                        intent2 = new Intent(Intent.ACTION_SEND);
                        intent2.setData(Uri.parse("mailto:"));
                        String[] to={"devrajbanerjee@yahoo.com","devraj.banerjee@triosstudent.com"}; //Put "To" emial IDs here
                        intent2.putExtra(Intent.EXTRA_EMAIL, to);
                        intent2.putExtra(Intent.EXTRA_SUBJECT, "Devraj is late");
                        intent2.putExtra(Intent.EXTRA_TEXT, "Name: Devraj      ID:12345     Status: Late    Reason: "+radio_b.getText());
                        intent2.setType("message/rfc822");
                        chooser = Intent.createChooser(intent2, "Send email");
                        startActivity(chooser);
                    }
                }
        );
    }
}
