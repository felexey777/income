package tk.site_guru.asasecond;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;


public class Animate extends ActionBarActivity {
        String manth_S;
    float manth_salary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate);
        manth_S = getIntent().getExtras().getString("manth");
        try{
            manth_salary = Float.parseFloat(manth_S);

        }catch(NumberFormatException e){

        }
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        float height = displaymetrics.heightPixels;
        float heightY =  manth_salary / 90000 * height;
        final ImageView viewArrow = (ImageView)findViewById(R.id.arrow);
        TranslateAnimation tr = new TranslateAnimation(0,0,0, heightY * -1);
        tr.setDuration(5000);
        //tr.setFillAfter(false);
        ScaleAnimation sc = new ScaleAnimation(1.0f,4.0f,1.0f,1.0f,100.9f,0.0f);
        sc.setDuration(2500);
        //sc.setFillAfter(false);
        AnimationSet as = new AnimationSet(false);
        as.addAnimation(tr);
        as.addAnimation(sc);
        as.setFillAfter(true);
        viewArrow.startAnimation(as);
        anim();


       // final Animation shakeanimation = AnimationUtils.loadAnimation(this, R.anim.scale_point);
       // viewArrow.startAnimation(shakeanimation);
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
            Intent  intent1 = new Intent(this, aboutAuthers.class);
            startActivity(intent1);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void onClick1(View view) {
        Intent intent = new Intent(Animate.this, calculate.class);
        startActivity(intent);
    }
    public void anim(){
         final ImageView shakeCat = (ImageView) findViewById(R.id.fly);
         final Animation shakeanimation = AnimationUtils.loadAnimation(this, R.anim.shake_cat);
        shakeCat.startAnimation(shakeanimation);
         final ImageView viwFire = (ImageView)findViewById(R.id.raketta);
         final Animation shakeFire = AnimationUtils.loadAnimation(this,R.anim.shake_fire);
         viwFire.startAnimation(shakeFire);

    }
}
