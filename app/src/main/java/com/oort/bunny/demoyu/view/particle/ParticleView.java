package com.oort.bunny.demoyu.view.particle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by bunny on 2017/4/18.
 */

public class ParticleView extends View {

    private static final int DELAY = 40; // 延迟毫秒
    private static final int NUM_SNOWFLAKES = 500; // 粒子数量

    private ArrayList<Flake> arrayFla;

    public ParticleView(Context context) {
        super(context);
    }

    public ParticleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ParticleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Flake f : arrayFla) {
            f.draw(canvas);
        }
        // 隔一段时间重绘一次, 动画效果
        getHandler().postDelayed(runnable, DELAY);
    }

    // 重绘线程
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //自动刷新
            invalidate();
        }
    };

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw || h != oldh) {
            //宽高改变
            initSnow(w, h);
        }
    }

    /**
     * 加载粒子
     *
     * @param width
     * @param height
     */
    private void initSnow(int width, int height) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG); // 抗锯齿
        arrayFla = new ArrayList<>();
        for (int i = 0; i < NUM_SNOWFLAKES; i++) {
            arrayFla.add(Flake.create(width, height, paint));
        }
    }
}
