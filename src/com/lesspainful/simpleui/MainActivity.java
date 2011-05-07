package com.lesspainful.simpleui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	ProgressDialog dialog;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button login = (Button) findViewById(R.id.login_button);
		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View paramView) {
				if(userInputValidates()) {
					startFoo();	
				} 
				
			}
		});

		Button loginSlow = (Button) findViewById(R.id.login_button_slow);
		loginSlow.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View paramView) {
				if(userInputValidates()) {
					dialog = ProgressDialog.show(MainActivity.this, "", "Logging in. Please wait...", true);
					new Wait().execute(null);
				}
			}
		});

	}

	private void startFoo() {
		MainActivity.this.startActivity(new Intent(MainActivity.this,
				FooActivity.class));
	}

	private boolean userInputValidates() {
		TextView errorText = (TextView) findViewById(R.id.error_text);
		
		EditText username = (EditText) findViewById(R.id.username_edittext);
		String submittedUsername = username.getText().toString();
		
		if(!submittedUsername.equals("jonas")) {
			errorText.setText("Unknown username");
			return false;
		}
		
		EditText password = (EditText) findViewById(R.id.password_edittext);
		String submittedPassword = password.getText().toString();
		
		if(!submittedPassword.equals("password")) {
			errorText.setText("Wrong password");
			return false;
		}
		
		return true;
	}
	
	class Wait extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		protected void onPostExecute(Void result) {
			dialog.dismiss();
			startFoo();

		}

	}

}