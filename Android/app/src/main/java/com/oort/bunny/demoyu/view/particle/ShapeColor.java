package com.oort.bunny.demoyu.view.particle;

import android.graphics.LinearGradient;
import android.graphics.PointF;
import android.graphics.Shader;

/**
 * Created by bunny on 2017/4/18.
 * 颜色和形状
 */

public class ShapeColor {

    private Shader shader;//渐变色

    private SHAPE shape;

    public void setShader(Shader shader) {
        this.shader = shader;
    }

    public Shader getShader() {
        return shader;
    }

    public void setShape(SHAPE shape) {
        this.shape = shape;
    }

    public SHAPE getShape() {
        return shape;
    }

    /**
     * 传入开始颜色，结束颜色，形状
     *  @param startColor
     * @param endColor
     * @param end
     * @param shape
     */
    public ShapeColor(int startColor, int endColor, PointF start, PointF end, SHAPE shape) {
        this.shape = shape;
        shader = new LinearGradient(start.x, start.y, end.x, end.y, startColor, endColor, Shader.TileMode.REPEAT);
    }

    /**
     * 形状枚举
     */
    public enum SHAPE {
        CIRCEL,//圆形
        SQUARE,//方形
        IMAGE,//图片
        TRIANGLE,//三角形
    }

}

