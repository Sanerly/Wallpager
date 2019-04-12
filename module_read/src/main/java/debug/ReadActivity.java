package debug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sanerly.base.basic.ContainerActivity;
import com.sanerly.read.ui.fragment.ReadFragment;

public class ReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, ContainerActivity.class);
        intent.putExtra("fragment", ReadFragment.class.getCanonicalName());
        this.startActivity(intent);
        finish();
    }
}
