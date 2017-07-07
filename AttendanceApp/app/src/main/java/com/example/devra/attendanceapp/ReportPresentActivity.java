package com.example.devra.attendanceapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ReportPresentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_present);
    }

    public void process(View view) {
        Intent intent = null, chooser = null;

        if (view.getId()==R.id.buttonPresentEmail){
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to={"devrajbanerjee@yahoo.com","devraj.banerjee@triosstudent.com"}; //Put "To" emial IDs here
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Devraj is present");
            intent.putExtra(Intent.EXTRA_TEXT, "Name: Devraj      ID:12345     Status:Present");
            intent.setType("message/rfc822");
            chooser = Intent.createChooser(intent, "Send email");
            startActivity(chooser);
        }

        if (view.getId()==R.id.buttonPresentText){
            Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "4169964289", null));
            intent1.putExtra("sms_body","Name: Devraj      ID: 12345     Status: Present");
            startActivity(intent1);

        }
    }


}
