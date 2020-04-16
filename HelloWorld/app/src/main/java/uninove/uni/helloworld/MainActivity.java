package uninove.uni.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickButton(View view) {

        // Instâncio e inicializo uma variável do tipo EditText
        EditText editText = (EditText) findViewById(R.id.editText);

        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Toast.makeText(this, "Olá", Toast.LENGTH_LONG).show();

        //Toast.makeText(this, "Olá " + editText.getText(), Toast.LENGTH_LONG).getGravity(Gravity.);
        Log.i("Info: ", "Botão pressionado");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
