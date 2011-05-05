package com.lesspainful.simpleui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button login = (Button)findViewById(R.id.login_button);
        login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View paramView) {
				MainActivity.this.startActivity(new Intent(MainActivity.this, FooActivity.class));
			}
		});
        
    }
    
    
}