package org.saurabhsood.stringapp.stringapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class GuesserActivity extends ActionBarActivity {

    public String stringToBeGuessed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guesser);

        //Get Intent
        Intent intent = getIntent();
        //Get Message
        String message = intent.getStringExtra(MainActivity.STRING_MESSAGE);
        //Get Text View
        this.stringToBeGuessed = this.morph(message);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(this.stringToBeGuessed);
    }

    private String morph(String message) {
        char a[] = message.toCharArray();
        for(int i = 0; i < a.length / 2; i++) {
            char temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }
        String str = new String(a);
        return str;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.guesser, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
