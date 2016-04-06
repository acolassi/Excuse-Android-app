package com.example.excuseapp;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener
{
	ExcuseGenerator ex;
	
	NotificationManager mgr;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.excuseviewer);
		
		((Button)findViewById(R.id.low_priority)).setOnClickListener(this);
		((Button)findViewById(R.id.med_priority)).setOnClickListener(this);
		((Button)findViewById(R.id.high_priority)).setOnClickListener(this);
		
		ex = new ExcuseGenerator(this);
		
		mgr = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
	}

	@Override
	public void onClick(View v)
	{
		String excuse = null;
		switch(v.getId())
		{
		case R.id.low_priority:
			excuse = ex.getExcuse(3);
			break;
		case R.id.med_priority:
			excuse = ex.getExcuse(2);
			break;
		case R.id.high_priority:
			excuse = ex.getExcuse(1);
			break;
		}
		
		
		Notification alert = new NotificationCompat.Builder(this)
		.setContentTitle("Alert")
		.setContentText("Hello")
		.build();
		
		mgr.notify(32, alert);
	}
}
