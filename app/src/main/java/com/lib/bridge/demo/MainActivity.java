package com.lib.bridge.demo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lib.bridge.core.LibResponse;
import com.lib.bridge.core.LibResponseHandler;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
    }

    public void onClickHandler(View view) {
        switch (view.getId()) {
            case R.id.btn_get_view:
                getView();
                break;
            case R.id.btn_get_data:
                getData();
                break;
        }
    }

    private void getView() {
        View view = DemoMessage.getView(this);
        if (view != null) {
            LinearLayout contentLayout = (LinearLayout) findViewById(R.id.content);
            contentLayout.addView(view);
        }
    }

    private void getData() {

        DemoMessage.getData(new LibResponseHandler() {
            @Override
            public void onHandler(LibResponse libResponse) {
                if (libResponse != null && libResponse.getStatusCode() == 0) {
                    try {
                        final String data = (String) libResponse.getData();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                TextView textView = (TextView) findViewById(R.id.tv_get_data);
                                textView.setText(data);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }


}
