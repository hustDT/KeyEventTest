package com.example.dt.keyeventtest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;


public class MainActivity extends ActionBarActivity {



    /********************************************/
    private static final String TAG="KEYEvent";

    private ImageView mImage;
    private TextView mAlphavalueText;
    private int mAlhpavalue;
    /*******************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImage=(ImageView)findViewById(R.id.imageView);
        mAlphavalueText=(TextView)findViewById(R.id.textView);
        mAlhpavalue = 100;
        mImage.setAlpha(mAlhpavalue);
        mAlphavalueText.setText("Alpha= "+mAlhpavalue*100/0xff+"%");

    }
/**********************************************************/
    public boolean onKeyDown(int keyCode,KeyEvent msg)
    {
        Log.v(TAG,"onKeyDown:keyCode= "+keyCode);
        Log.v(TAG,"onKeyDown:String= "+msg.toString());

        switch(keyCode)
        {
            case KeyEvent.KEYCODE_VOLUME_UP:
                mAlhpavalue+=20;
                break;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                  mAlhpavalue-=20;
                  break;
            default:
                break;
        }

        if(mAlhpavalue>=65535)mAlhpavalue=65535;
        if(mAlhpavalue<=0x0)mAlhpavalue=0x0;
        mImage.setAlpha(mAlhpavalue);
        mAlphavalueText.setText("Alpha= "+mAlhpavalue*100/0xff+"%");

        return super.onKeyDown(keyCode,msg);

    }


/***********************************************************/

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
