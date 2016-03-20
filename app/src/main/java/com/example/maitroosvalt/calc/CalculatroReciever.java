package com.example.maitroosvalt.calc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculatroReciever extends BroadcastReceiver {
    Calculator calc = new Calculator();

    public CalculatroReciever() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        String button = extras.getString("button");
        String screen = extras.getString("screen");

        switch (button) {
            case "=":
                Float test = OnEquals(screen);
                extras.putString("screen_val", Float.toString(test));
                setResultExtras(extras);

                break;
            default:
                onOperator(button, screen);
                extras.putString("screen_val", "");
                setResultExtras(extras);

                break;
        }
    }

    public Float OnEquals(String value) {
        calc.setY(Float.parseFloat(value));

        float total = calc.calc(calc.getOperator());

        calc.setY(null);
        calc.setX(null);
        calc.setOperator(null);

        return total;
    }

    public void onOperator(String operator, String value) {
        calc.setOperator(operator);

        calc.setX(Float.parseFloat(value));
    }
}
