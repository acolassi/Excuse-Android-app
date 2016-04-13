package com.example.excuseapp;

import java.util.Random;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.util.Log;
import android.widget.Toast;

/**
 * ExcuseGenerator
 * 
 * Generates Excuses based on strings.xml
 * @author aaron
 *
 */
public class ExcuseGenerator
{
	private static Random r = new Random();
	private Context context;
	
	public ExcuseGenerator(Context c)
	{
		this.context = c;
	}
	
	/**
	 * 
	 * @param priority a constant 1, 2, or 3; 1 being highest priority excuse, 3 being lowest
	 * @return the excuse string
	 */
	
	public String getExcuse(int priority)
	{
		String output = null;
		Resources res = context.getResources();
		String[] tmp = null;
		try
		{
			switch(priority)
			{
			case 1:
				tmp = res.getStringArray(R.array.excuses_names_high);
				output = tmp[r.nextInt(tmp.length-1)];
				break;
			case 2:
				tmp = res.getStringArray(R.array.excuses_names_med);
				output = tmp[r.nextInt(tmp.length-1)];
				break;
			case 3:
				tmp = res.getStringArray(R.array.excuses_names_low);
				output = tmp[r.nextInt(tmp.length-1)];
				break;
			default:
				output = "Err...no excuses?";
			}
		}
		catch(NotFoundException e)
		{
			Toast.makeText(context, "Not found.", Toast.LENGTH_SHORT).show();;
		}
		return output;
	}

}
