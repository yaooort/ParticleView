package com.oort.bunny.demoyu.view.wave;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;

import java.util.Random;

/**
 * Created by bunny on 2017/4/19.
 */

public class WaveLine {
    //起始点
    private PointF startPoint;
    //结束点
    private PointF endPoint;
    //控制点
    private PointF assistPoint1, assistPoint2;
    //线条颜色
    private int lineColor;
    //填充颜色
    private int contentColor;
    //画笔
    private Paint paint;
    //线条
    private Path path;
    //画笔宽度
    private int paintWidth;
    //画布宽度
    private int canvasWidth;
    //画布高度
    private int canvasHeight;
    //随机
    private Random random;


    private WaveLine() {
        super();
    }

    public WaveLine(Paint paint, int canvasWidth, int canvasHeight) {
        this.random = new Random();
        this.paint = paint;
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
    }

    //生成随机数
    public int random(int max) {
        return random.nextInt(max);
    }


    public int getPaintWidth() {
        return paintWidth;
    }

    public void setPaintWidth(int paintWidth) {
        paint.setStrokeWidth(paintWidth);
        this.paintWidth = paintWidth;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Path getPath() {
        return path;
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public void setCanvasWidth(int canvasWidth) {
        this.canvasWidth = canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    public void setCanvasHeight(int canvasHeight) {
        this.canvasHeight = canvasHeight;
    }


    public PointF getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(PointF startPoint) {
        this.startPoint = startPoint;
    }

    public PointF getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(PointF endPoint) {
        this.endPoint = endPoint;
    }

    public PointF getAssistPoint1() {
        return assistPoint1;
    }

    public void setAssistPoint1(PointF assistPoint1) {
        this.assistPoint1 = assistPoint1;
    }

    public PointF getAssistPoint2() {
        return assistPoint2;
    }

    public void setAssistPoint2(PointF assistPoint2) {
        this.assistPoint2 = assistPoint2;
    }

    public int getLineColor() {
        return lineColor;
    }

    public void setLineColor(int lineColor) {
        paint.setColor(lineColor);
        this.lineColor = lineColor;
    }

    public int getContentColor() {
        return contentColor;
    }

    public void setContentColor(int contentColor) {
        //paint.setColor(contentColor);
        this.contentColor = contentColor;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    private int randomColor(int alpha) {
        Random rnd = new Random();
        alpha = Math.min(Math.max(1, alpha), 255);
        return Color.argb(alpha, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    /**
     * 构造一条线
     *
     * @param width  当前画布的宽度
     * @param height 当前画布的高度
     * @param paint  画笔
     * @return
     */
    public static WaveLine create(int width, int height, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        WaveLine wave = new WaveLine(paint, width, height);
        wave.setPath(new Path());
        //起点
        PointF startPoint = new PointF(0, height);
        wave.setStartPoint(startPoint);
        //结束点
        PointF endPoint = new PointF(width, height);
        wave.setEndPoint(endPoint);
        //控制点一
        PointF assistPoint1 = new PointF(wave.random(width), height - wave.random(500));
        wave.setAssistPoint1(assistPoint1);
        //控制点二
        PointF assistPoint2 = new PointF(wave.random(width), height - wave.random(500));
        wave.setAssistPoint2(assistPoint2);
        //线条颜色
        wave.setLineColor(wave.randomColor(50));
        //填充颜色
        wave.setContentColor(wave.randomColor(50));
        //画笔宽度
        wave.setPaintWidth(5);
        return wave;
    }

    /**
     * 画画吧，少年
     *
     * @param canvas
     */
    public void draw(Canvas canvas) {
        startPoint = new PointF(0, startPoint.y - 2);
        setStartPoint(startPoint);
        endPoint = new PointF(canvasWidth, endPoint.y - 2);
        setEndPoint(endPoint);
        if (assistPoint1.x > (canvasWidth / 3 * 2)) {
            assistPoint1 = new PointF(0, assistPoint1.y - 2);
            setAssistPoint1(assistPoint1);
        } else {
            assistPoint1 = new PointF(assistPoint1.x + 50, assistPoint1.y - 2);
            setAssistPoint1(assistPoint1);
        }
        if(assistPoint2.x>(canvasWidth / 3 * 2)){
            assistPoint2 = new PointF(0, assistPoint2.y - 2);
            setAssistPoint2(assistPoint2);
        }else {
            assistPoint2 = new PointF(assistPoint2.x + 50, assistPoint2.y - 2);
            setAssistPoint2(assistPoint2);
        }

        path.reset();
        //起点
        path.moveTo(startPoint.x, startPoint.y);
        //mPath
        path.cubicTo(assistPoint1.x, assistPoint1.y, assistPoint2.x, assistPoint2.y, endPoint.x, endPoint.y);
        //画path
        canvas.drawPath(path, paint);
    }
}
