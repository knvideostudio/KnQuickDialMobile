package knp.profile.knquickdial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class mysettings extends Activity 
{

	private static final String KN_APP = "knp.profile.knquickdial";
	private static final String KN_APP_MN = "knp.profile.knquickdial.MainActivity";
		
	@Override
	public void onCreate(Bundle savedInstanceState)
	 {
		
	        super.onCreate(savedInstanceState);
	        this.setContentView(R.layout.mysettings);
	      
	        String sFile = "knQuickData.txt";
	        String[] rdArr = null;
	
			TextView txtError2 = (TextView) findViewById(R.id.txtError);
			
			File myfile = new File(Environment.getExternalStorageDirectory().getPath(), sFile);
			if (myfile.exists()) 
			{
				rdArr = ReadFile(sFile, txtError2);
				
				EditText phone1 = (EditText) findViewById(R.id.ed1a);
	    		EditText name1 = (EditText) findViewById(R.id.ed1b);
	    		LoadData(phone1, name1, rdArr[0]);
	    		
	    		EditText phone2 = (EditText) findViewById(R.id.ed2a);
	    		EditText name2 = (EditText) findViewById(R.id.ed2b);
	    		LoadData(phone2, name2, rdArr[1]);
	    		
	    		EditText phone3 = (EditText) findViewById(R.id.ed3a);
	    		EditText name3 = (EditText) findViewById(R.id.ed3b);
	    		LoadData(phone3, name3, rdArr[2]);
	    		
	    		EditText phone4 = (EditText) findViewById(R.id.ed4a);
	    		EditText name4 = (EditText) findViewById(R.id.ed4b);
	    		LoadData(phone4, name4, rdArr[3]);
	    		
	    		EditText phone5 = (EditText) findViewById(R.id.ed5a);
	    		EditText name5 = (EditText) findViewById(R.id.ed5b);
	    		LoadData(phone5, name5, rdArr[4]);
	    		
	    		EditText phone6 = (EditText) findViewById(R.id.ed6a);
	    		EditText name6 = (EditText) findViewById(R.id.ed6b);
	    		LoadData(phone6, name6, rdArr[5]);
	    		
	    		EditText phone7 = (EditText) findViewById(R.id.ed7a);
	    		EditText name7 = (EditText) findViewById(R.id.ed7b);
	    		LoadData(phone7, name7, rdArr[6]);
	    		
	    		EditText phone8 = (EditText) findViewById(R.id.ed8a);
	    		EditText name8 = (EditText) findViewById(R.id.ed8b);
	    		LoadData(phone8, name8, rdArr[7]);
	    		
	    		EditText phone9 = (EditText) findViewById(R.id.ed9a);
	    		EditText name9 = (EditText) findViewById(R.id.ed9b);
	    		LoadData(phone9, name9, rdArr[8]);
	    		
	    		EditText phone10 = (EditText) findViewById(R.id.ed10a);
	    		EditText name10 = (EditText) findViewById(R.id.ed10b);
	    		LoadData(phone10, name10, rdArr[9]);
			}
	      
	        // button save
	        final Button btSave;        
	        btSave = (Button) findViewById(R.id.btnSave);
	        btSave.setOnClickListener(saveData);
 
	        final Button btLoad;
	        btLoad = (Button) findViewById(R.id.btnLoad);
	        btLoad.setOnClickListener(mainListener);
	        
	 }
	
	    private OnClickListener mainListener = new OnClickListener() 
	    {        
	    	public void onClick(View v) 
	    	{           
	    		Intent i = new Intent();
	     		i.setClassName(KN_APP, KN_APP_MN);
	    		startActivity(i);
	    	}    
	   };
	
	private void LoadData(EditText phone, EditText name, String sData)
	{
		String[] splArr = null;
		
		try
		{
		if (sData.length() > 3)
		{
			splArr = sData.split("\\|", 0);
			if (splArr.length > 0)
			{
				phone.setText(splArr[0]);
				name.setText(splArr[1]);
			}
		}
		}
		catch (Exception e)
		{
	  		Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
	   	  
		}
	}
	
	private String[] ReadFile(String sFile, TextView txtError2) {

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
 	     	
 	    	myFile = new File(Environment.getExternalStorageDirectory().getPath(), sFile);
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

	private String ValidateData(EditText phone, EditText name)
	{
		String temp;
		String ph;
		String nm;

		ph = phone.getText().toString().trim();
		nm = name.getText().toString().trim();
		
		if (ph.length() != 0) // empty string
		{
		if (ph.length() <= 9) // phone
		{
			phone.setError( "the phone should be 10 digits" );
			phone.requestFocus();
			
		}
		else
		{
			if (nm.length() <= 2) // string
			{
				name.setError( "the name should be 3 letters" );
				name.requestFocus();
			}
			
		}
		}
		
		temp = ph + "|" + nm;
		return (temp);
	}
	
	private OnClickListener saveData = new OnClickListener() 
    {        
    	public void onClick(View v) 
    	{       
  
    		String myArr[] = new String[10];
    		String myText;
    		StringBuilder contents = new StringBuilder();
    		
    		TextView txtError2 = (TextView) findViewById(R.id.txtError);
    		
    		EditText phone1 = (EditText) findViewById(R.id.ed1a);
    		EditText name1 = (EditText) findViewById(R.id.ed1b);
    		EditText phone2 = (EditText) findViewById(R.id.ed2a);
    		EditText name2 = (EditText) findViewById(R.id.ed2b);
    		EditText phone3 = (EditText) findViewById(R.id.ed3a);
    		EditText name3 = (EditText) findViewById(R.id.ed3b);
    		
    		EditText phone4 = (EditText) findViewById(R.id.ed4a);
    		EditText name4 = (EditText) findViewById(R.id.ed4b);
    		EditText phone5 = (EditText) findViewById(R.id.ed5a);
    		EditText name5 = (EditText) findViewById(R.id.ed5b);
    		
    		EditText phone6 = (EditText) findViewById(R.id.ed6a);
    		EditText name6 = (EditText) findViewById(R.id.ed6b);
    		EditText phone7 = (EditText) findViewById(R.id.ed7a);
    		EditText name7 = (EditText) findViewById(R.id.ed7b);
    		EditText phone8 = (EditText) findViewById(R.id.ed8a);
    		EditText name8 = (EditText) findViewById(R.id.ed8b);
    		EditText phone9 = (EditText) findViewById(R.id.ed9a);
    		EditText name9 = (EditText) findViewById(R.id.ed9b);
    		EditText phone10 = (EditText) findViewById(R.id.ed10a);
    		EditText name10 = (EditText) findViewById(R.id.ed10b);
    		
    		myText = ValidateData(phone1, name1);
    		
    		if (myText.length() >= 14)
    		{
    			myArr[0] = myText;
    		}
    		else
    		{
    			myArr[0] = "";
    		}
    		
    		
    		myText = ValidateData(phone2, name2);
    		if (myText.length() >= 14)
    		{
    			myArr[1] = myText;
    		}
    		else
    		{
    			myArr[1] = "";
    		}
    		
    		myText = ValidateData(phone3, name3);
    		if (myText.length() >= 14)
    		{
    			myArr[2] = myText;
    		}
    		else
    		{
    			myArr[2] = "";
    		}
    		
    		
    		myText = ValidateData(phone4, name4);
    		if (myText.length() >= 14)
    		{
    			myArr[3] = myText;
    		}
    		else
    		{
    			myArr[3] = "";
    		}
    		
    		
    		myText = ValidateData(phone5, name5);
    		if (myText.length() >= 14)
    		{
    			myArr[4] = myText;
    		}
    		else
    		{
    			myArr[4] = "";
    		}
    		
    		
    		myText = ValidateData(phone6, name6);
    		if (myText.length() >= 14)
    		{
    			myArr[5] = myText;
    		}
    		else
    		{
    			myArr[5] = "";
    		}

    		
    		myText = ValidateData(phone7, name7);
    		if (myText.length() >= 14)
    		{
    			myArr[6] = myText;
    		}
    		else
    		{
    			myArr[6] = "";
    		}
    		
    		myText = ValidateData(phone8, name8);
    		if (myText.length() >= 14)
    		{
    			myArr[7] = myText;
    		}
    		else
    		{
    			myArr[7] = "";
    		}
    		
    		myText = ValidateData(phone9, name9);
    		if (myText.length() >= 14)
    		{
    			myArr[8] = myText;
    		}
    		else
    		{
    			myArr[8] = "";
    		}
    		
    		myText = ValidateData(phone10, name10);
    		if (myText.length() >= 14)
    		{
    			myArr[9] = myText;
    		}
    		else
    		{
    			myArr[9] = "";
    		}
    	
    		try
        	{
    			for (int i = 0; i < myArr.length; i++) 
    		   	{
    				if (myArr[i].length() > 3)
    				{
    					contents.append(myArr[i]).append('\n');
    				}
    		   	}
   			
    			
        	}
    		catch (Exception e) 
        	{
        		Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        	} 
    	
    		if (contents.length() > 12)
    		{
      			WriteFile(contents.toString(), txtError2);
    			Toast.makeText(getBaseContext(), "Data is saved succesfully!", Toast.LENGTH_SHORT).show();
    		}
    		
    	}  // end main
    	
    	   	 
    	private void WriteFile(String strText, TextView display)
    	  {
    	    	String errMessage = "";
    	   
    	       	File file = new File(Environment.getExternalStorageDirectory(), "knQuickData.txt");
    	    	FileOutputStream fos;

    	    	byte[] data = new String(strText).getBytes();

    	    	try 
    	    	{
    	    	    fos = new FileOutputStream(file);
    	    	    fos.write(data);
    	    	    fos.flush();
    	    	    fos.close();
    	    	}
    	    	catch (FileNotFoundException e)
    	    	{
    	    	    // handle exception
    	    		errMessage = e.getMessage();
    	    		display.setText(errMessage);
    	    	} 
    	    	catch (IOException e) 
    	    	{
    	    	    // handle exception
    	    		errMessage = e.getMessage();
    	    		display.setText(errMessage);
    	    	}
    	    }
    	   
    };
	
	 
}
