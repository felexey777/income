package tk.site_guru.asasecond;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class aboutApp extends ActionBarActivity {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
    }


    public void onClick(View view) {
        Intent  intent = new Intent(aboutApp.this, calculate.class);
        startActivity(intent);

    }
}