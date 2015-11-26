package tk.site_guru.asasecond;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class   recommendations extends ActionBarActivity {
    Integer roomString;
    Integer baksString;
    TextView infoTextViewMS;
    long  manth_salary;
    String  manth_S;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);
         manth_S = getIntent().getExtras().getString("manth");

        try{
           manth_salary = Integer.parseInt(manth_S);

        }catch(NumberFormatException e){

        }
        //cours of $ 30 ;price of the apartment 50 000
        long m = 125000 / manth_salary;

         infoTextViewMS = (TextView)findViewById(R.id.recomend);

        infoTextViewMS.setText(getString(R.string.recommendations) + " " + m +" "  + getString(R.string.yers));
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
        //final Button shakeButton = (Button) findViewById(R.id.button4);
        //final Animation shakeanimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        //shakeButton.startAnimation(shakeanimation);
        Intent intent = new Intent(recommendations.this, Animate.class);
        intent.putExtra("manth", manth_S);
        startActivity(intent);
    }

    public void onClick_ref(View view) {
        EditText room = (EditText)findViewById(R.id.room);
        EditText baks = (EditText)findViewById(R.id.baks);
        try{
            roomString = Integer.parseInt(room.getText().toString());
            baksString = Integer.parseInt(baks.getText().toString());

        }catch(NumberFormatException e){

        }
        if(roomString==null){
            roomString= 50000;
        }
        if (baksString==null){
            baksString = 30;
        }
        long a = roomString * baksString / 12 / manth_salary;
        infoTextViewMS.setText(getString(R.string.recommendations) + " " + a + " " + getString(R.string.yers));
        Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.reboot_tost), Toast.LENGTH_SHORT);
        toast.show();

    }
}
