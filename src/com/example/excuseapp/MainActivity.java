package com.example.excuseapp;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener
{
	ExcuseGenerator ex;
	NotificationManager mgr;
	Context c;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.excuseviewer);
		
		// Set click handlers
		((Button)findViewById(R.id.low_priority)).setOnClickListener(this);
		((Button)findViewById(R.id.med_priority)).setOnClickListener(this);
		((Button)findViewById(R.id.high_priority)).setOnClickListener(this);
		
		// Instantiate new ExcuseGenerator
		ex = new ExcuseGenerator(this);
		
		// Get handle to NotificationManager
		mgr = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
		
		// Get handle to Context
		c = this;
	}

	@Override
	public void onClick(View v)
	{
		// Check which button was pressed and generate excuse according to priority
		final String excuse;
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
		default:
			excuse = null;
		}
		
		// Delay notification by 5 minutes (300,000ms)
		Handler handler = new Handler();
		handler.postDelayed(new Runnable()
		{
			@Override
			public void run()
			{
				// Build notification
				Notification alert = new NotificationCompat.Builder(c)
						.setContentTitle("Alert")
						.setContentText(excuse)
						.setSmallIcon(android.R.drawable.ic_dialog_alert)
						.setSound(Uri.parse("android.resource://com.example.excuseapp/raw/kimpossible"))
						.setPriority(Notification.PRIORITY_HIGH)
						.build();
						
						mgr.notify(32, alert);
			}
		}, 300000);
	}
}
