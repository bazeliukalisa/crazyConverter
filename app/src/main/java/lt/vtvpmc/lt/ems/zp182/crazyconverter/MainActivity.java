package lt.vtvpmc.lt.ems.zp182.crazyconverter;

import android.content.Context;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    private EditText inputNumberField;
    private Button convertId;
    private Button resetId;
    private TextView kilometre00;
    private TextView centimetre00;
    private TextView mile00;
    private TextView yard00;
    private TextView foot00;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumberField = (EditText) findViewById(R.id.inputNumberField);
        convertId = (Button) findViewById(R.id.convertId);
        resetId = (Button) findViewById(R.id.resetId);
        kilometre00 = (TextView) findViewById(R.id.kilometre00);
        centimetre00 = (TextView) findViewById(R.id.centimetre00);
        mile00 = (TextView) findViewById(R.id.mile00);
        yard00 = (TextView) findViewById(R.id.yard00);
        foot00 = (TextView) findViewById(R.id.foot00);

        convertId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double userInputValue;

                try {
                    userInputValue = Double.parseDouble(inputNumberField.getText().toString());
                } catch (Exception ex) {
                    userInputValue = 0;
                    Context context = getApplicationContext();
                    CharSequence text = "Įvesk skaičių!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                if (userInputValue > 0) {

                    DecimalFormat df = new DecimalFormat("##.##");

                    kilometre00.setText(String.valueOf(df.format(userInputValue / 100000)));
                    centimetre00.setText(String.valueOf(df.format(userInputValue)));
                    mile00.setText(String.valueOf(df.format(userInputValue / 160934.4)));
                    yard00.setText(String.valueOf(df.format(userInputValue / 91.44)));
                    foot00.setText(String.valueOf(df.format(userInputValue / 30.48)));

                }

            }
        });

        resetId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumberField.setText(null);

                kilometre00.setText(R.string.kilometre0);
                centimetre00.setText(R.string.kilometre0);
                mile00.setText(R.string.kilometre0);
                yard00.setText(R.string.kilometre0);
                foot00.setText(R.string.kilometre0);
            }
        });

    }
}

