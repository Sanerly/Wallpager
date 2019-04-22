package debug;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sanerly.base.util.StatusBarUtils;
import com.sanerly.statusbar.R;
import com.sanerly.statusbar.StatusBarActivity;

public class StatusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_activity);
    }

    @Override
    protected void onResume() {
        super.onResume();
        StatusBarUtils.setColor(this, getResources().getColor(R.color.black));
    }

    public void bntOnClick1(View view) {
        Intent intent=new Intent(this, StatusBarActivity.class);
        startActivity(intent);
    }
}
