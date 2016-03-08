package com.example.maitroosvalt.calc;

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

public class MainActivity extends AppCompatActivity {
    Calculator calc = new Calculator();

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

    public void OnOperator(View v) {
        Button button = (Button)v;

        String operator = button.getText().toString();

        EditText screen = (EditText)findViewById(R.id.editText);

        calc.setOperator(operator);

        calc.setX(Float.parseFloat(screen.getText().toString()));
        screen.setText("");
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

    public void OnEquals(View v) {
        EditText screen = (EditText)findViewById(R.id.editText);

        calc.setY(Float.parseFloat(screen.getText().toString()));

        float total = calc.calc(calc.getOperator());

        setScreen(Float.toString(total));

        calc.setX(null);
        calc.setY(null);
        calc.setOperator(null);
    }
}
