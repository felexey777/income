package tk.site_guru.asasecond;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Alex on 21.05.2015.
 */
public class aboutAuthers extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_authers);
    }


public void onClick1(View w){

    Intent intent = new Intent(aboutAuthers.this, calculate.class);
    startActivity(intent);
}
}
