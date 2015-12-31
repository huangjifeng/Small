package net.wequick.example.small;

import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import net.wequick.small.Small;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class LaunchActivity extends AppCompatActivity {
    private View mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        mContentView = findViewById(R.id.fullscreen_content);

        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        // Remove the status and navigation bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Small.setUp(this, new net.wequick.small.Bundle.OnLoadListener() {
            @Override
            public void onStart(int bundleCount, int upgradeBundlesCount, long upgradeBundlesSize) {

            }

            @Override
            public void onProgress(int bundleIndex, String bundleName, long loadedSize, long bundleSize) {

            }

            @Override
            public void onComplete(Boolean success) {
                mContentView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Small.openUri("main", LaunchActivity.this);
                        finish();
                    }
                }, 2000);
            }
        });
    }
}
