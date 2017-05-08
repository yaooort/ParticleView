package com.oort.bunny.demoyu.view.particle;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

import java.util.Random;

/**
 * Created by bunny on 2017/4/18.
 * 粒子类
 */

public class Flake {

    private final Paint mPaint; // 画笔

    private final int w_fl; //宽

    private final int h_fl; //高

    private final int speedMin = 1;//最小速度

    private final int speedMax = 50;//最大速度

    private final PointF startPoint;//起始位置

    private final ShapeColor shapeColor;//形状及颜色

    public Flake(ShapeColor shapeColor, Paint mPaint, int w_fl, int h_fl, PointF startPoint) {
        this.shapeColor = shapeColor;
        this.mPaint = mPaint;
        this.h_fl = h_fl;
        this.w_fl = w_fl;
        this.startPoint = startPoint;
    }

    private int randomColor(int alpha) {
        Random rnd = new Random();
        alpha = Math.min(Math.max(1, alpha), 255);
        return Color.argb(alpha, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    /**
     * 构造一个粒子
     *
     * @param width  当前画布的宽度
     * @param height 当前画布的高度
     * @param paint  画笔
     * @return
     */
    public static Flake create(int width, int height, Paint paint) {
        int viewW = 3;//宽
        int viewH = 3;//高
        ShapeColor.SHAPE shape = ShapeColor.SHAPE.CIRCEL;//圆形
        int startColor = Color.BLUE;//起始颜色
        int endColor = Color.RED;//结束颜色
        PointF start = new PointF(0, 0);
        PointF end = new PointF(viewW, viewH);
        ShapeColor shapeColor = new ShapeColor(startColor, endColor, start, end, shape);
        //设置抗锯齿
        paint.setAntiAlias(true);
        //设置填充色
//        paint.setShader(shapeColor.getShader());
        //设置填充
        paint.setStyle(Paint.Style.FILL); // 填充;

        PointF pointXY = new PointF();//中心点坐标
        Random random = new Random();
        pointXY.set(random.nextInt(width), random.nextInt(height));
        return new Flake(shapeColor, paint, viewW, viewH, pointXY);
    }


    public void draw(Canvas canvas) {
        Random random = new Random();
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int er = random.nextInt(2);
        float x1 = startPoint.x + (er == 0 ? -0 : +0);
        float y1 = startPoint.y - 3;
        if (y1 < -h_fl) {
            y1 = height + h_fl;
            x1 = random.nextInt(width);
        }
        if (x1 > width) {
            x1 -= 10;
        }
        if (x1 < -w_fl) {
            x1 += 10;
        }
        mPaint.setColor(randomColor(220));
//        int co = random.nextInt(3);
//        if (co == 0) {
//            mPaint.setColor(Color.YELLOW);
//        } else if (co == 1) {
//            mPaint.setColor(Color.WHITE);
//        } else if (co == 2) {
//            mPaint.setColor(Color.GREEN);
//        }
        startPoint.set(x1, y1);
        canvas.drawCircle(startPoint.x, startPoint.y, w_fl / 2, mPaint);
    }
}
