package com.example.lenovo.bbqu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import com.example.lenovo.bbqu.R;

public class Move extends AppCompatActivity implements GestureDetector.OnGestureListener{
    private ViewFlipper viewFlipper2;
    private  GestureDetector gd;
    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if(e2.getX()-e1.getX()<0)//从右像左滑
        {
            if (viewFlipper2.getDisplayedChild() == 3) {
                Intent intent = new Intent(Move.this, LoginActivity.class);
                startActivity(intent);

            } else {

                Animation anin = AnimationUtils.loadAnimation(this, R.anim.removeleftin);
                viewFlipper2.setInAnimation(anin);
                Animation anout = AnimationUtils.loadAnimation(this, R.anim.removeleftout);
                viewFlipper2.setInAnimation(anout);
                viewFlipper2.showNext();
            }
        }
        else//从左向右
        {
            Animation anin1 = AnimationUtils.loadAnimation(this,R.anim.removerightin);
            viewFlipper2.setInAnimation(anin1);
            Animation anout1 = AnimationUtils.loadAnimation(this, R.anim.removerightout);
            viewFlipper2.setInAnimation(anout1);
            viewFlipper2.showPrevious();


        }






        return false;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);
        viewFlipper2=(ViewFlipper)findViewById(R.id.viewFlipper2);
        gd=new GestureDetector(this,this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gd.onTouchEvent(event);
    }
}
