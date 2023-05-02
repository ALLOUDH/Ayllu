package ay.llu.ayllu;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    ImageView logo;

    Animator animador;

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo = findViewById(R.id.imglogo);
        Animation animacion;
        animacion = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.aparecerlogo);
        logo.startAnimation(animacion);
        fadein(logo,2500);
        esperarYcerrar(3000);
    }

    private void esperarYcerrar(int tiempo) {
        handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                llamar();
            }
        },tiempo);
    }
    public void llamar(){
        Intent intent = new Intent(Splash.this, Login.class);
        startActivity(intent);
    }

    private void fadein(View view, int dur) {
        animador = ObjectAnimator.ofFloat(view, "alpha", 0, 100);
        animador.setDuration(dur);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animador);
        animatorSet.start();
    }
}