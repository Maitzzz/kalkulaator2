package com.example.maitroosvalt.calc;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Struct;

public class MainActivity extends AppCompatActivity {
    Calculator calc = new Calculator();
    private static String TEST_TEST = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void OnClick(View v) {
        Button button = (Button)v;

        String str = button.getText().toString();

        EditText screen = (EditText)findViewById(R.id.editText);

        screen.setText(screen.getText() + str);
    }

    public void setScreen(String value) {
        EditText screen = (EditText)findViewById(R.id.editText);

        screen.setText(value);
    }

    public void OnDelete(View v) {
        EditText screen = (EditText)findViewById(R.id.editText);
        screen.setText("");
    }

    public void broadcastIntent(View view)
    {
        Button button = (Button)view;
        String str = button.getText().toString();

        EditText screen = (EditText)findViewById(R.id.editText);
        String scr = screen.getText().toString();

        Intent intent = new Intent();
        intent.setAction("com.calculator.CALCULATOR");
        intent.putExtra("button", str);
        intent.putExtra("screen", scr);
        sendOrderedBroadcast(intent, null, new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent2) {
                Bundle results = getResultExtras(true);
                Integer ints = results.getInt("screen_val", -1);

                String srt = results.getString("screen_val");
                setScreen(results.getString("screen_val"));
            }
        }, null, Activity.RESULT_OK, null, null);
        //Intent, String, BroadcastReceiver, Handler, int, String, Bundle)}
    }

}
