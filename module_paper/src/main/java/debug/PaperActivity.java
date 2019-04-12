package debug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sanerly.base.basic.ContainerActivity;
import com.sanerly.paper.ui.fragment.PaperFragment;


public class PaperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, ContainerActivity.class);
        intent.putExtra("fragment", PaperFragment.class.getCanonicalName());
        this.startActivity(intent);
        finish();
    }
}
