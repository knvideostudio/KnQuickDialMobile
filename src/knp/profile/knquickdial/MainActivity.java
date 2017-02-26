package knp.profile.knquickdial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String KN_APP = "knp.profile.knquickdial";
	private static final String KN_APP_SETT = "knp.profile.knquickdial.mysettings";
	private static final String sFile = "knQuickData.txt";

	static final String KN_PROMO = "http://www.youtube.com/watch?v=Oi4ewu0AL2U";
	static final String KN_WEBUI = "http://www.youtube.com/watch?v=73OUw88B9V0";
	static final String KN_REG_USER = "http://www.knmobileapps.com/Order30DaysTrial.aspx";
	
	WebView myWebView;
	
	String myPhone1;
	String myPhone2;
	String myPhone3;
	String myPhone4;
	String myPhone5;
	String myPhone6;
	String myPhone7;
	String myPhone8;
	String myPhone9;
	String myPhone10;
	
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// video powerful mobile
        ImageButton btnWebIntro = (ImageButton)findViewById(R.id.imgWebIntro); 
        btnWebIntro.setOnClickListener(startPowerfulWeb); 
        
        ImageButton btnWebAppInt = (ImageButton)findViewById(R.id.imgWebAppInt); 
        btnWebAppInt.setOnClickListener(startWebUI); 
        
        ImageButton btnAppBuild = (ImageButton)findViewById(R.id.imgAppBuild); 
        btnAppBuild.setOnClickListener(startTrialWeb); 
		
		String[] rdArr = null;
		String[] splArr = null;
		
		TextView txtMain = (TextView) findViewById(R.id.txtMain1);
		
		File myfile = new File(Environment.getExternalStorageDirectory().getPath(), sFile);
		if (!myfile.exists()) {
			txtMain.setText("Add the phones and names in the app settings page.");
			return;
		}
		else
		{
			txtMain.setText("You might dial the people now by pressing the buttons bellow.");
		}
		// main data
		
		rdArr = ReadFile(sFile, txtMain);
				
		TextView txt1 = (TextView) findViewById(R.id.txtName1);
		TextView txt2 = (TextView) findViewById(R.id.txtName2);
		TextView txt3 = (TextView) findViewById(R.id.txtName3);
		TextView txt4 = (TextView) findViewById(R.id.txtName4);
		TextView txt5 = (TextView) findViewById(R.id.txtName5);
		TextView txt6 = (TextView) findViewById(R.id.txtName6);
		TextView txt7 = (TextView) findViewById(R.id.txtName7);
		TextView txt8 = (TextView) findViewById(R.id.txtName8);
		TextView txt9 = (TextView) findViewById(R.id.txtName9);
		TextView txt10 = (TextView) findViewById(R.id.txtName10);
		
		Button btn1 = (Button)findViewById(R.id.btnPh1);
		Button btn2 = (Button)findViewById(R.id.btnPh2); 
		Button btn3 = (Button)findViewById(R.id.btnPh3);
		Button btn4 = (Button)findViewById(R.id.btnPh4);
		Button btn5 = (Button)findViewById(R.id.btnPh5);
		Button btn6 = (Button)findViewById(R.id.btnPh6);
		Button btn7 = (Button)findViewById(R.id.btnPh7);
		Button btn8 = (Button)findViewById(R.id.btnPh8);
		Button btn9 = (Button)findViewById(R.id.btnPh9);
		Button btn10 = (Button)findViewById(R.id.btnPh10);
		

		// Phone 1
		try
		{
		if (rdArr[0].length() > 3)
		{
			splArr = rdArr[0].split("\\|", 0);
			if (splArr.length > 0)
			{
				//Toast.makeText(getBaseContext(), splArr[0], Toast.LENGTH_SHORT).show();
				
				txt1.setText(splArr[1]);
				myPhone1 = "tel:" + splArr[0];
				//Toast.makeText(getBaseContext(), splArr[1], Toast.LENGTH_SHORT).show();
				//Toast.makeText(getBaseContext(), myPhone1, Toast.LENGTH_SHORT).show();
				btn1.setOnClickListener(startPhone);
				btn1.getBackground().setColorFilter(Color.parseColor("#1470F8"), Mode.MULTIPLY);
				//0xFF00FF00
				//Color.parseColor("#00ff00"
			}
			
		}
		}
		catch (Exception e)
		{
		//	Toast.makeText(getBaseContext(), "ERR 1: " + e.getMessage(), Toast.LENGTH_SHORT).show();
		}
		
		// phone 2
		if (rdArr[1].length() > 3)
		{
			splArr = rdArr[1].split("\\|", 0);
			if (splArr.length > 0)
			{
				txt2.setText(splArr[1]);
				myPhone2 = "tel:" + splArr[0];
				btn2.setOnClickListener(startPhone2);
				btn2.getBackground().setColorFilter(Color.parseColor("#1470F8"), Mode.MULTIPLY);
			}
			
		}
		
		// phone 3
		try
		{
		if (rdArr[2].length() > 3)
		{
			splArr = rdArr[2].split("\\|", 0);
			if (splArr.length > 0)
			{
				txt3.setText(splArr[1]);
				myPhone3 = "tel:" + splArr[0];
				btn3.setOnClickListener(startPhone3);
				btn3.getBackground().setColorFilter(Color.parseColor("#1470F8"), Mode.MULTIPLY);
				
			}
			
		}
		}
		catch (Exception e)
		{
			//Toast.makeText(getBaseContext(), "ERR 2: " + e.getMessage(), Toast.LENGTH_SHORT).show();
			
		}
		
		// phone 4
		try
		{
		if (rdArr[3].length() > 3)
		{
			splArr = rdArr[3].split("\\|", 0);
			if (splArr.length > 0)
			{
				txt4.setText(splArr[1]);
				myPhone4 = "tel:" + splArr[0];
				btn4.setOnClickListener(startPhone4);
				btn4.getBackground().setColorFilter(Color.parseColor("#1470F8"), Mode.MULTIPLY);
			}
	
		}
		}
		catch (Exception e)
		{
			//Toast.makeText(getBaseContext(), "ERR 4: " + e.getMessage(), Toast.LENGTH_SHORT).show();
 		}


		// phone 5
		try
		{
		if (rdArr[4].length() > 3)
		{
			splArr = rdArr[4].split("\\|", 0);
			if (splArr.length > 0)
			{
				txt5.setText(splArr[1]);
				myPhone5 = "tel:" + splArr[0];
				btn5.setOnClickListener(startPhone5);
				btn5.getBackground().setColorFilter(Color.parseColor("#1470F8"), Mode.MULTIPLY);
			}
			}
		}
		catch (Exception e)
		{
			//Toast.makeText(getBaseContext(), "ERR 5: " + e.getMessage(), Toast.LENGTH_SHORT).show();
 		}
		
		// phone 6
		try
		{
		if (rdArr[5].length() > 3)
		{
			splArr = rdArr[5].split("\\|", 0);
			if (splArr.length > 0)
			{
				txt6.setText(splArr[1]);
				myPhone6 = "tel:" + splArr[0];
				btn6.setOnClickListener(startPhone6);
				btn6.getBackground().setColorFilter(Color.parseColor("#1470F8"), Mode.MULTIPLY);
			}
			}
		}
		catch (Exception e)
		{
		//	Toast.makeText(getBaseContext(), "ERR 6: " + e.getMessage(), Toast.LENGTH_SHORT).show();
 		}
		
		
		// phone 7
		try
		{
		if (rdArr[6].length() > 3)
		{
			splArr = rdArr[6].split("\\|", 0);
			if (splArr.length > 0)
			{
				txt7.setText(splArr[1]);
				myPhone7 = "tel:" + splArr[0];
				btn7.setOnClickListener(startPhone7);
				btn7.getBackground().setColorFilter(Color.parseColor("#1470F8"), Mode.MULTIPLY);
			}
			}
		}
		catch (Exception e)
		{
			//Toast.makeText(getBaseContext(), "ERR 7: " + e.getMessage(), Toast.LENGTH_SHORT).show();
 		}
		
		// phone 8
		try
		{
		if (rdArr[7].length() > 3)
		{
			splArr = rdArr[7].split("\\|", 0);
			if (splArr.length > 0)
			{
				txt8.setText(splArr[1]);
				myPhone8 = "tel:" + splArr[0];
				btn8.setOnClickListener(startPhone8);
				btn8.getBackground().setColorFilter(Color.parseColor("#1470F8"), Mode.MULTIPLY);
			}
			}
		}
		catch (Exception e)
		{
			//Toast.makeText(getBaseContext(), "ERR 5: " + e.getMessage(), Toast.LENGTH_SHORT).show();
 		}
		
		// phone 9
		try
		{
		if (rdArr[8].length() > 3)
		{
			splArr = rdArr[8].split("\\|", 0);
			if (splArr.length > 0)
			{
				txt9.setText(splArr[1]);
				myPhone9 = "tel:" + splArr[0];
				btn9.setOnClickListener(startPhone9);
				btn9.getBackground().setColorFilter(Color.parseColor("#1470F8"), Mode.MULTIPLY);
			}
			}
		}
		catch (Exception e)
		{
			//Toast.makeText(getBaseContext(), "ERR 9: " + e.getMessage(), Toast.LENGTH_SHORT).show();
 		}
		
		// phone 10
		try
		{
		if (rdArr[9].length() > 3)
		{
			splArr = rdArr[9].split("\\|", 0);
			if (splArr.length > 0)
			{
				txt10.setText(splArr[1]);
				myPhone10 = "tel:" + splArr[0];
				btn10.setOnClickListener(startPhone10);
				btn10.getBackground().setColorFilter(Color.parseColor("#1470F8"), Mode.MULTIPLY);
			}
			}
		}
		catch (Exception e)
		{
			// Toast.makeText(getBaseContext(), "ERR 10: " + e.getMessage(), Toast.LENGTH_SHORT).show();
 		}
		
		
		try
		{
		myWebView = (WebView) findViewById(R.id.myWebTrack);
		myWebView.getSettings().setJavaScriptEnabled(true);
		myWebView.getSettings().setAppCacheEnabled(false);
		myWebView.setInitialScale(1);
		myWebView.loadDataWithBaseURL("http://www.knvideostudio.com/mapimgview.aspx", "", "text/html", "UTF-8", null);
		
		}
		catch (Exception e)
		{
	
		}

	}
	
	
	 private OnClickListener startPowerfulWeb = new OnClickListener() 
	    {        
	    	public void onClick(View v) 
	    	{           
	    		openWebURL(KN_PROMO);
	    	}    
 	};
 	
 	private OnClickListener startWebUI = new OnClickListener() 
    {        
    	public void onClick(View v) 
    	{           
    		openWebURL(KN_WEBUI);
    	}    
    }; 
    
    private OnClickListener startTrialWeb = new OnClickListener() 
    {        
    	public void onClick(View v) 
    	{           
    		openWebURL(KN_REG_USER);
    	}    
    };
    
    private void openWebURL( String inURL ) 
    {     
    	Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse( inURL ) );      
    	startActivity( browse ); 
    } 

	
		
    private OnClickListener startPhone = new OnClickListener() 
    {        
    	public void onClick(View v) 
    	{           
    		CallPhoneNow();
    	}    
    };
    
    private OnClickListener startPhone2 = new OnClickListener() 
    {        
    	public void onClick(View v) 
    	{           
        	Intent callIntent = new Intent(Intent.ACTION_CALL); 
        	try
    		{
        		callIntent.setData(Uri.parse(myPhone2));     
        		startActivity(callIntent); 
    		}
        	catch (Exception e)
    		{
    			Toast.makeText(getBaseContext(), "ERR Call 2: " + e.getMessage(), Toast.LENGTH_SHORT).show();
     		}
    	}    
    };
    
    private OnClickListener startPhone3 = new OnClickListener() 
    {        
    	public void onClick(View v) 
    	{           
        	Intent callIntent = new Intent(Intent.ACTION_CALL); 
        	try
        	{
        	callIntent.setData(Uri.parse(myPhone3));     
        	startActivity(callIntent); 
        	}
        	catch (Exception e)
    		{
    			Toast.makeText(getBaseContext(), "ERR Call 3: " + e.getMessage(), Toast.LENGTH_SHORT).show();
     		}
    	}    
    };
    
    private OnClickListener startPhone4 = new OnClickListener() 
    {        
    	public void onClick(View v) 
    	{           
        	Intent callIntent = new Intent(Intent.ACTION_CALL); 
        	try
        	{
        	callIntent.setData(Uri.parse(myPhone4));     
        	startActivity(callIntent); 
        	}
        	catch (Exception e)
    		{
    			Toast.makeText(getBaseContext(), "ERR Call 4: " + e.getMessage(), Toast.LENGTH_SHORT).show();
     		}
    	}    
    };
    
    private OnClickListener startPhone5 = new OnClickListener() 
    {        
    	public void onClick(View v) 
    	{           
        	Intent callIntent = new Intent(Intent.ACTION_CALL);   
        	try
        	{
        	callIntent.setData(Uri.parse(myPhone5));     
        	startActivity(callIntent); 
        	}
        	catch (Exception e)
    		{
    			Toast.makeText(getBaseContext(), "ERR Call 5: " + e.getMessage(), Toast.LENGTH_SHORT).show();
     		}
    	}    
    };
    
    private OnClickListener startPhone6 = new OnClickListener() 
    {        
    	public void onClick(View v) 
    	{           
        	Intent callIntent = new Intent(Intent.ACTION_CALL);  
        	try
        	{
        	callIntent.setData(Uri.parse(myPhone6));     
        	startActivity(callIntent); 
        	}
        	catch (Exception e)
    		{
    			Toast.makeText(getBaseContext(), "ERR Call 6: " + e.getMessage(), Toast.LENGTH_SHORT).show();
     		}
    	}    
    };
    
    private OnClickListener startPhone7 = new OnClickListener() 
    {        
    	public void onClick(View v) 
    	{           
        	Intent callIntent = new Intent(Intent.ACTION_CALL); 
        	try
        	{
        	callIntent.setData(Uri.parse(myPhone7));     
        	startActivity(callIntent); 
        	}
        	catch (Exception e)
    		{
    			Toast.makeText(getBaseContext(), "ERR Call 7: " + e.getMessage(), Toast.LENGTH_SHORT).show();
     		}
    	}    
    };
    
    private OnClickListener startPhone8 = new OnClickListener() 
    {        
    	public void onClick(View v) 
    	{           
        	Intent callIntent = new Intent(Intent.ACTION_CALL); 
        	try
        	{
        	callIntent.setData(Uri.parse(myPhone8));     
        	startActivity(callIntent); 
        	}
        	catch (Exception e)
    		{
    			Toast.makeText(getBaseContext(), "ERR Call 8: " + e.getMessage(), Toast.LENGTH_SHORT).show();
     		}
    	}    
    };
    
    private OnClickListener startPhone9 = new OnClickListener() 
    {        
    	public void onClick(View v) 
    	{           
        	Intent callIntent = new Intent(Intent.ACTION_CALL);  
        	try
        	{
        	callIntent.setData(Uri.parse(myPhone9));     
        	startActivity(callIntent); 
        	}
        	catch (Exception e)
    		{
    			Toast.makeText(getBaseContext(), "ERR Call 9: " + e.getMessage(), Toast.LENGTH_SHORT).show();
     		}
    	}    
    };
    
    private OnClickListener startPhone10 = new OnClickListener() 
    {        
    	public void onClick(View v) 
    	{           
        	Intent callIntent = new Intent(Intent.ACTION_CALL);   
        	try
        	{
        	callIntent.setData(Uri.parse(myPhone10));     
        	startActivity(callIntent); 
        	}
        	catch (Exception e)
    		{
    			Toast.makeText(getBaseContext(), "ERR Call 10: " + e.getMessage(), Toast.LENGTH_SHORT).show();
     		}
    	}    
    };
    
    private void CallPhoneNow() 
    {     
    	Intent callIntent = new Intent(Intent.ACTION_CALL);  
    	try
    	{
    	callIntent.setData(Uri.parse(myPhone1));     
    	startActivity(callIntent); 
    	}
    	catch (Exception e)
		{
			Toast.makeText(getBaseContext(), "ERR Call 1: " + e.getMessage(), Toast.LENGTH_SHORT).show();
 		}
    }

	   private String[] ReadFile(String strFile, TextView display)
	    {
		   File myFile;
		   FileInputStream fIn;
		   BufferedReader myReader;
		   int i = 0;
		   String aDataRow;
		   String myArr[] = new String[11];
		   
		   myArr[0] = "";
		   myArr[1] = "";
		   myArr[2] = "";
		   myArr[3] = "";
		   myArr[4] = "";
		   myArr[5] = "";
		   myArr[6] = "";
		   myArr[7] = "";
		   myArr[8] = "";
		   myArr[9] = "";
		   
		   try 
	    	{
	     	
	    	myFile = new File(Environment.getExternalStorageDirectory().getPath(), strFile);
			fIn = new FileInputStream(myFile);
			myReader = new BufferedReader(new InputStreamReader(fIn));
				    	
			while ((aDataRow = myReader.readLine()) != null) 
			{
				myArr[i] = aDataRow;
				i = i + 1;
			}
			
			myReader.close();
			
	    	} 
	    	catch (Exception e) 
	    	{
	    		Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
	    	}
		   
		   return myArr;
	    }
	  
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.menu_settings:
        	startMySettings();
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
    private void startMySettings()
    {
		Intent i = new Intent();
		i.setClassName(KN_APP, KN_APP_SETT);
    	startActivity(i);
    }
}
