package swe.practice1104;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void gess(View view)
    {
        Intent in = new Intent(this,Main2Activity.class);
        startActivity(in);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        final GestureDetector gestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {
            public void onLongPress(MotionEvent e) {
                Toast.makeText(getApplicationContext(),"LongPressed",Toast.LENGTH_SHORT).show();
            }
        });
        View myView = findViewById(R.id.button);
        myView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });
    }

    public boolean onTouchEvent(MotionEvent event){

        int action = MotionEventCompat.getActionMasked(event);

        switch(action) {
            case (MotionEvent.ACTION_DOWN) :
                Toast.makeText(getApplicationContext(),"Action was DOWN",Toast.LENGTH_SHORT).show();
                return true;
            /*
            case (MotionEvent.ACTION_MOVE) :

                Toast.makeText(getApplicationContext(),"Action was MOVE",Toast.LENGTH_SHORT).show();
                return true;
            */
            case (MotionEvent.ACTION_UP) :

                Toast.makeText(getApplicationContext(),"Action was UP",Toast.LENGTH_SHORT).show();
                return true;
            case (MotionEvent.ACTION_CANCEL) :

                Toast.makeText(getApplicationContext(),"Action was CANCEL",Toast.LENGTH_SHORT).show();
                return true;
            case (MotionEvent.ACTION_OUTSIDE) :

                Toast.makeText(getApplicationContext(),"Movement occurred outside bounds " +
                        "of current screen element",Toast.LENGTH_SHORT).show();
                return true;
            default :
                return super.onTouchEvent(event);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.opt1) {
            Toast.makeText(getApplicationContext(),"search",Toast.LENGTH_SHORT).show();
        }
        else  if (id == R.id.opt2) {
            Toast.makeText(getApplicationContext(),"activate",Toast.LENGTH_SHORT).show();
        }
        else  if (id == R.id.opt3) {
            Toast.makeText(getApplicationContext(),"destroy",Toast.LENGTH_SHORT).show();
        }
        else  if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(),"Logout",Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
