package com.example.arch.vaani.ocr;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
//import android.content.Intent;
//import android.view.View;
//import android.widget.Button;

public class LanguageActivity extends Activity {

		public static File imgFile;
		public Uri fileUri;
		ImageView showImg;
		private Spinner spinner1;
		public static File fileName;
		String value;
		Button button;
		@Override
		
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_lang);
			String myRef = this.getIntent().getStringExtra("name");
		    imgFile = new  File(myRef);
		   
		    /*Display Image*/
	        if(imgFile.exists()){
	        	Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
	        	BitmapFactory.Options options = new BitmapFactory.Options();
	        	options.inSampleSize = 4;
	       		ImageView showImg = (ImageView) findViewById(R.id.view_photo);
	        	showImg.setImageBitmap(myBitmap);
	        	}
	        /*Implement submit button**/
	        button = (Button)findViewById(R.id.button4);
	        button.setOnClickListener(new OnClickListener() {
	        	@Override
		        public void onClick(View v) { gotoFinalActivity();}});
		}
			
	
		 public void addListenerOnSpinnerItemSelection() {
		    	spinner1 = (Spinner) findViewById(R.id.spinner1);
		    	ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.language_arrays, android.R.layout.simple_spinner_item);
		    	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    	// Apply the adapter to the spinner
		    	spinner1.setAdapter(adapter);
		    	spinner1.setOnItemSelectedListener(new OnItemSelectedListener(){
		    		public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
		    			Toast.makeText(parent.getContext(),"OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),Toast.LENGTH_SHORT).show();
		    			//value = spinner1.getSelectedItem().toString();
				    	
		    		}
		    		  @Override
		    		  public void onNothingSelected(AdapterView<?> arg0) {
		    			// TODO Auto-generated method stub
		    		  }
		    	});
		    	
    		}
		
		 public void gotoFinalActivity(){
			 Intent first = new Intent(this, FinalActivity.class);
			 first.putExtra("name",imgFile.toString());
			 first.putExtra("choice", value);
			 startActivity(first);
		 }
}
