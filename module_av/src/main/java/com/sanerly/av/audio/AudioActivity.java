package com.sanerly.av.audio;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.common.arouter.RouterUrl;
import com.sanerly.av.BR;
import com.sanerly.av.R;
import com.sanerly.av.audio.tester.CaptureTester;
import com.sanerly.av.audio.tester.PlayerTestter;
import com.sanerly.av.audio.tester.Tester;
import com.sanerly.av.databinding.ActivityAudioBinding;
import com.sanerly.base.basic.BaseActivity;
import com.sanerly.base.basic.BaseViewModel;
import com.sanerly.base.util.ToastUtils;

@Route(path = RouterUrl.AV.ACTIVITY_AUDIO)
public class AudioActivity extends BaseActivity<ActivityAudioBinding, BaseViewModel> {


    private String TAG = "AudioActivity";
    private Tester mTester;
    public static final String[] TEST_PROGRAM_ARRAY = {
            "录制 wav 文件",
            "播放 wav 文件",
            "OpenSL ES 录制",
            "OpenSL ES 播放",
            "音频编解码"
    };


    @Override
    protected int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_audio;
    }

    @Override
    protected int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void init() {
        super.init();
//        Tester.DEFAULT_TEST_FILE = Environment.getDataDirectory() + "/"+ this.getPackageName() + "/audio_test.wav";
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, TEST_PROGRAM_ARRAY);
        mBinding.spType.setAdapter(adapter);

        mBinding.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mBinding.spType.getSelectedItemPosition()) {
                    case 0:
                        mTester = new CaptureTester();
                        break;
                    case 1:
                        mTester = new PlayerTestter();
                        break;

                    default:
                        break;
                }
                if (mTester == null) {
                    return;
                }
                mTester.startTesting();
                ToastUtils.showShort("开始");
            }
        });

        mBinding.btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTester == null) {
                    return;
                }
                mTester.stopTesting();
                ToastUtils.showShort("结束");
            }
        });
    }


}
