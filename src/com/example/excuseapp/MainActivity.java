package com.example.excuseapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.excuseviewer);
		
		((Button)findViewById(R.id.low_priority)).setOnClickListener(this);
		((Button)findViewById(R.id.med_priority)).setOnClickListener(this);
		((Button)findViewById(R.id.high_priority)).setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
		switch(v.getId())
		{
		case R.id.low_priority:
			Toast.makeText(this, "Low Priority Excuse", Toast.LENGTH_SHORT).show();
			break;
		case R.id.med_priority:
			Toast.makeText(this, "Medium Priority Excuse", Toast.LENGTH_SHORT).show();
			break;
		case R.id.high_priority:
			Toast.makeText(this, "High Priority Excuse", Toast.LENGTH_SHORT).show();
			break;
		}
		
	}
}
