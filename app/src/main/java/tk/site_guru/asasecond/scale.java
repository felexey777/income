package tk.site_guru.asasecond;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class scale extends ActionBarActivity {
    String manth_S= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);

        String daysS="";
        String hours = "";
        manth_S = getIntent().getExtras().getString("manth");
        daysS = getIntent().getExtras().getString("days");
        hours = getIntent().getExtras().getString("hours");
        float manth_salary = 0;
        float days = 0;
        float hoursS = 0;
        try{
            manth_salary = Integer.parseInt(manth_S);
            days = Integer.parseInt(daysS);
            hoursS = Integer.parseInt(hours);
        }catch(NumberFormatException e){

        }

        float year_salary = manth_salary * 12;
        float week_salary = manth_salary / 4;
        float day_salary = manth_salary / days;
        float hour_salary= manth_salary / (days * hoursS);
        float a = manth_salary*100;
        float minute_salary = a / (days* hoursS * 60);
        float second_salary = a / (days * hoursS * 3600);






        TextView infoTextViewYS = (TextView)findViewById(R.id.YS);
        infoTextViewYS.setText( getString(R.string.Year_salary)+ " " + year_salary + " " + getString(R.string.grn));
        TextView infoTextViewMS = (TextView)findViewById(R.id.Manth_Salary);
        infoTextViewMS.setText(getString(R.string.Manth_salary) + " "+ manth_salary + " " + getString(R.string.grn));
        TextView infoTextViewWS = (TextView)findViewById(R.id.Week_salary);
        infoTextViewWS.setText(getString(R.string.Week_salary) + " "+ week_salary + " " + getString(R.string.grn));
        TextView infoTextViewDS = (TextView)findViewById(R.id.Days_salary);
        infoTextViewDS.setText(getString(R.string.Day_salary) + " " + day_salary + " " + getString(R.string.grn));
        TextView infoTextViewHS = (TextView)findViewById(R.id.Hour_salary);
        infoTextViewHS.setText(getString(R.string.Hour_salary)+ " "+ hour_salary + " " + getString(R.string.grn));
        TextView infoTextViewMnS = (TextView)findViewById(R.id.Minute_salary);
        infoTextViewMnS.setText(getString(R.string.Minute_salary)+ " "+ minute_salary + " " + getString(R.string.kop));
        TextView infoTextViewSS = (TextView)findViewById(R.id.Second_salary);
        infoTextViewSS.setText(getString(R.string.Second_salary)+ " "+ second_salary + " " + getString(R.string.kop) );
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
            Intent  intent = new Intent(this, aboutApp.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.scrollView) {
            Intent  intent1 = new Intent(this, aboutAuthers.class);
            startActivity(intent1);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        TextView manth = (TextView)findViewById(R.id.Manth_Salary);
        Intent intent = new Intent(scale.this, recommendations.class);
        intent.putExtra("manth", manth_S);
        startActivity(intent);
    }
}
