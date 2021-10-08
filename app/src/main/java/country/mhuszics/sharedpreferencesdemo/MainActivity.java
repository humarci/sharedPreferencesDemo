package country.mhuszics.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    Button b1;

    public static final String MyPreferences = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Pass = "passKey";
    public static final String Email = "emailKey";

    public String name_value;
    public String pass_value;
    public String email_value;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=(EditText) findViewById(R.id.editText);
        ed2=(EditText) findViewById(R.id.editText2);
        ed3=(EditText) findViewById(R.id.editText3);
        b1=(Button) findViewById(R.id.button);

        sharedPreferences = getSharedPreferences(MyPreferences, Context.MODE_PRIVATE);

        readValues();
        writeValues();
    }

    public void readValues(){
        name_value = sharedPreferences.getString(Name, null);
        pass_value = sharedPreferences.getString(Pass, null);
        email_value = sharedPreferences.getString(Email, null);
        if (name_value != null) {
            ed1.setText(name_value);
        }
        if (pass_value != null) {
            ed2.setText(pass_value);
        }
        if (email_value != null) {
            ed3.setText(email_value);
        }
    }

    public void writeValues(){
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_value = ed1.getText().toString();
                pass_value = ed2.getText().toString();
                email_value = ed3.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(Name, name_value);
                editor.putString(Pass, pass_value);
                editor.putString(Email, email_value);
                editor.commit();
                Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_LONG).show();
            }
        });
    }
}