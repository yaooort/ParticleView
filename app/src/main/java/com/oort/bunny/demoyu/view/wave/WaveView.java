package com.oort.bunny.demoyu.view.wave;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by bunny on 2017/4/19.
 */

public class WaveView extends View {

    private static final int DELAY = 40; // 延迟毫秒

    private ArrayList<WaveLine> arrayLines;//线条

    private static final int NUM_SNOWFLAKES = 2; // 线条总数量

    public WaveView(Context context) {
        super(context);
    }

    public WaveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WaveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw || h != oldh) {
            //宽高改变
            initSnow(w, h);
        }
    }

    /**
     * @param width  当前画布的宽度
     * @param height 当前画布的高度
     */
    private void initSnow(int width, int height) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG); // 抗锯齿
        paint.setStyle(Paint.Style.FILL); // 填充;
        arrayLines = new ArrayList<>();
        for (int i = 0; i < NUM_SNOWFLAKES; i++) {
            arrayLines.add(WaveLine.create(width, height, paint));
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (WaveLine line : arrayLines) {
            line.draw(canvas);
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
}
