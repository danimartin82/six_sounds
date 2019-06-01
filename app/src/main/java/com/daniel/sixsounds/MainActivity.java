package com.daniel.sixsounds;

import android.content.res.Configuration;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    private static final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /* ADVERTISEMENT */
        /******************************************************************************************/
        MobileAds.initialize(this, "ca-app-pub-3498967338559704~2479878516");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        /* SOUND ENGINE */
        /******************************************************************************************/
        final SoundPool soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        final int[] audio_list = {R.raw.applause, R.raw.boo, R.raw.laugh, R.raw.kids, R.raw.hmmmm, R.raw.fail};
        final int []soundId={0,0,0,0,0,0};

        for (int i=0;i<6;i++) {
            soundId[i]= soundPool.load(this,audio_list[i], 1);
        }

        /* BUTTONS */
        /******************************************************************************************/

        final ImageView imageView_laugh = (ImageView)findViewById(R.id.imageView_laugh);
        final ImageView imageView_yeah = (ImageView)findViewById(R.id.imageView_yeah);
        final ImageView imageView_applause = (ImageView)findViewById(R.id.imageView_applause);
        final ImageView imageView_boo = (ImageView)findViewById(R.id.imageView_boo);
        final ImageView imageView_fail = (ImageView)findViewById(R.id.imageView_fail);
        final ImageView imageView_hmm = (ImageView)findViewById(R.id.imageView_hmm);

        /* imageView_laugh */

        imageView_laugh.setScaleType(ImageView.ScaleType.CENTER);
        imageView_laugh.setAdjustViewBounds(true);
        imageView_laugh.setImageResource(R.drawable.laugh);
        imageView_laugh.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){
                v.startAnimation(buttonClick);
                soundPool.autoPause();
                soundPool.play(soundId[2], 1, 1, 0, 0, 1);
            }
        });

        /* imageView_yeah */

        imageView_yeah.setScaleType(ImageView.ScaleType.CENTER);
        imageView_yeah.setAdjustViewBounds(true);
        imageView_yeah.setImageResource(R.drawable.kids);
        imageView_yeah.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){
                v.startAnimation(buttonClick);
                soundPool.autoPause();
                soundPool.play(soundId[3], 1, 1, 0, 0, 1);
            }
        });

        /* imageView_applause */

        imageView_applause.setScaleType(ImageView.ScaleType.CENTER);
        imageView_applause.setAdjustViewBounds(true);
        imageView_applause.setImageResource(R.drawable.applause);
        imageView_applause.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){
                v.startAnimation(buttonClick);
                soundPool.autoPause();
                soundPool.play(soundId[0], 1, 1, 0, 0, 1);
            }
        });
        /* imageView_boo */

        imageView_boo.setScaleType(ImageView.ScaleType.CENTER);
        imageView_boo.setAdjustViewBounds(true);
        imageView_boo.setImageResource(R.drawable.boo);
        imageView_boo.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){
                v.startAnimation(buttonClick);
                soundPool.autoPause();
                soundPool.play(soundId[1], 1, 1, 0, 0, 1);
            }
        });
        /* imageView_fail */

        imageView_fail.setScaleType(ImageView.ScaleType.CENTER);
        imageView_fail.setAdjustViewBounds(true);
        imageView_fail.setImageResource(R.drawable.fail);
        imageView_fail.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){
                v.startAnimation(buttonClick);
                soundPool.autoPause();
                soundPool.play(soundId[5], 1, 1, 0, 0, 1);
            }
        });
        /* imageView_hmm */

        imageView_hmm.setScaleType(ImageView.ScaleType.CENTER);
        imageView_hmm.setAdjustViewBounds(true);
        imageView_hmm.setImageResource(R.drawable.hmm);
        imageView_hmm.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){
                v.startAnimation(buttonClick);
                soundPool.autoPause();
                soundPool.play(soundId[4], 1, 1, 0, 0, 1);
            }
        });


    }

    /* DETECT A CHANGE IN ORIENTATION */
    /******************************************************************************************/
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        checkOrientation(newConfig);
    }


    /* BUTTONS ANIMATION */
    /******************************************************************************************/
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.5F);



    /* MODIFIY LAYOUT WHEN CHANGE ORIENTATION */
    /******************************************************************************************/
    private void checkOrientation(Configuration newConfig){
        // Checks the orientation of the screen

        final ImageView imageView_laugh = (ImageView)findViewById(R.id.imageView_laugh);
        final ImageView imageView_yeah = (ImageView)findViewById(R.id.imageView_yeah);
        final ImageView imageView_applause = (ImageView)findViewById(R.id.imageView_applause);
        final ImageView imageView_boo = (ImageView)findViewById(R.id.imageView_boo);
        final ImageView imageView_fail = (ImageView)findViewById(R.id.imageView_fail);
        final ImageView imageView_hmm = (ImageView)findViewById(R.id.imageView_hmm);

        final TextView textView_applause = (TextView)findViewById(R.id.text_applause);
        final TextView textView_boo = (TextView)findViewById(R.id.text_boo);
        final TextView textView_fail = (TextView)findViewById(R.id.text_fail);
        final TextView textView_hmm = (TextView)findViewById(R.id.text_hmm);
        final TextView textView_yeah = (TextView)findViewById(R.id.text_yeah);
        final TextView textView_laugh = (TextView)findViewById(R.id.text_laugh);

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {

            int pad_b=this.getResources().getDimensionPixelSize(R.dimen.buttom_padding_v);
            int pad_t=this.getResources().getDimensionPixelSize(R.dimen.dark_padding_v);

            imageView_laugh.setPadding(pad_b,pad_b,pad_b,pad_b);
            imageView_yeah.setPadding(pad_b,pad_b,pad_b,pad_b);
            imageView_applause.setPadding(pad_b,pad_b,pad_b,pad_b);
            imageView_boo.setPadding(pad_b,pad_b,pad_b,pad_b);
            imageView_fail.setPadding(pad_b,pad_b,pad_b,pad_b);
            imageView_hmm.setPadding(pad_b,pad_b,pad_b,pad_b);

            textView_laugh.setPadding(pad_t,pad_t,pad_t,pad_t);
            textView_yeah.setPadding(pad_t,pad_t,pad_t,pad_t);
            textView_applause.setPadding(pad_t,pad_t,pad_t,pad_t);
            textView_boo.setPadding(pad_t,pad_t,pad_t,pad_t);
            textView_fail.setPadding(pad_t,pad_t,pad_t,pad_t);
            textView_hmm.setPadding(pad_t,pad_t,pad_t,pad_t);

        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){


            int pad_b=this.getResources().getDimensionPixelSize(R.dimen.buttom_padding_h);
            int pad_t=this.getResources().getDimensionPixelSize(R.dimen.dark_padding_h);

            imageView_laugh.setPadding(pad_b,pad_b,pad_b,pad_b);
            imageView_yeah.setPadding(pad_b,pad_b,pad_b,pad_b);
            imageView_applause.setPadding(pad_b,pad_b,pad_b,pad_b);
            imageView_boo.setPadding(pad_b,pad_b,pad_b,pad_b);
            imageView_fail.setPadding(pad_b,pad_b,pad_b,pad_b);
            imageView_hmm.setPadding(pad_b,pad_b,pad_b,pad_b);

            textView_laugh.setPadding(pad_t,pad_t,pad_t,pad_t);
            textView_yeah.setPadding(pad_t,pad_t,pad_t,pad_t);
            textView_applause.setPadding(pad_t,pad_t,pad_t,pad_t);
            textView_boo.setPadding(pad_t,pad_t,pad_t,pad_t);
            textView_fail.setPadding(pad_t,pad_t,pad_t,pad_t);
            textView_hmm.setPadding(pad_t,pad_t,pad_t,pad_t);

        }
    }

}