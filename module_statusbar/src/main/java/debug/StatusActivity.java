package debug;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sanerly.statusbar.R;
import com.sanerly.statusbar.StatusBarActivity;

public class StatusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_activity);
    }

    public void bntOnClick1(View view) {
        Intent intent=new Intent(this, StatusBarActivity.class);
        startActivity(intent);
    }
}
