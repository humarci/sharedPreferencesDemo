# Shared Preferences Demo app

## Step 1:

Create the UI Layout and set some variables:
`string.xml`:
```XML
<resources>
    <string name="app_name">Shared Preferences Demo</string>
    <string name="tv_text">Shared Preferences</string>
    <string name="tv2_text">Demo</string>
</resources>
```

`activity_main.xml`:
```XML
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:tools="http://schemas.android.com/tools"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:text="@string/tv_text"
        android:textSize="35dp" />

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/textView"
        android:layout_centerHorizontal="true"
        android:text="@string/tv2_text"
        android:textColor="@color/purple_200"
        android:textSize="35dp" />

    <EditText
        android:id="@+id/editText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/textView2"
        android:layout_alignParentStart="true"
        android:layout_alignParentLeft="true"
        android:layout_alignParentEnd="true"
        android:layout_alignParentRight="true"
        android:layout_marginTop="67dp"
        android:hint="Name field" />

    <EditText
        android:id="@+id/editText2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/editText"
        android:layout_alignParentStart="true"
        android:layout_alignParentLeft="true"
        android:layout_alignParentEnd="true"
        android:layout_alignParentRight="true"
        android:hint="Pass field" />

    <EditText
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/editText3"
        android:layout_below="@id/editText2"
        android:layout_alignParentStart="true"
        android:layout_alignParentLeft="true"
        android:layout_alignParentEnd="true"
        android:layout_alignParentRight="true"
        android:hint="E-mail field" />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Save"
        android:id="@+id/button"
        android:layout_below="@id/editText3"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="50dp" />


</RelativeLayout>
```

## Step 2:
Modify the `MainActivity.java` file, creating the write possibility:
```JAVA
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

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_value = ed1.getText().toString();
                String pass_value = ed2.getText().toString();
                String email_value = ed3.getText().toString();

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
```