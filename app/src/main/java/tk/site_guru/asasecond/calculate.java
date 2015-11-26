package tk.site_guru.asasecond;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class calculate extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculate, menu);


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
            Intent intent = new Intent(this, aboutApp.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.scrollView) {
            Intent intent1 = new Intent(this, aboutAuthers.class);
            startActivity(intent1);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void onClick(View view) {


        EditText manth_salary = (EditText) findViewById(R.id.manth_salary);
        EditText days = (EditText) findViewById(R.id.day);
        EditText hours = (EditText) findViewById(R.id.hours);

        if (manth_salary.getText().toString().equals("0") | days.getText().toString().equals("0") | hours.getText().toString().equals("0")) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    getString(R.string.zero), Toast.LENGTH_SHORT);
            toast.show();

        } else if (manth_salary.getText().toString().equals("") | days.getText().toString().equals("") | hours.getText().toString().equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    getString(R.string.toast), Toast.LENGTH_SHORT);
            toast.show();
        } else {

            Intent intent = new Intent(calculate.this, scale.class);

            intent.putExtra("manth", manth_salary.getText().toString());
            intent.putExtra("days", days.getText().toString());
            intent.putExtra("hours", hours.getText().toString());

            startActivity(intent);
        }


    }
}
