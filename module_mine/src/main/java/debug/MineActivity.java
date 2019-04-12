package debug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sanerly.base.basic.ContainerActivity;
import com.sanerly.mine.R;
import com.sanerly.mine.ui.fragment.MineFragment;

public class MineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, ContainerActivity.class);
        intent.putExtra("fragment", MineFragment.class.getCanonicalName());
        this.startActivity(intent);
        finish();
    }
}
