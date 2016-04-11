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
		
		((Button)findViewById(R.id.low_priority)).setOnClickListener(this);
		((Button)findViewById(R.id.med_priority)).setOnClickListener(this);
		((Button)findViewById(R.id.high_priority)).setOnClickListener(this);
		
		ex = new ExcuseGenerator(this);
		
		mgr = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
		
		c = this;
	}

	@Override
	public void onClick(View v)
	{
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
		
		Handler handler = new Handler();
		handler.postDelayed(new Runnable()
		{
			@Override
			public void run()
			{
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
