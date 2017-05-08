# ParticleView
### 星空效果
[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg)](http://www.apache.org/licenses/LICENSE-2.0)

### Android效果图
![](https://github.com/yaooort/ParticleView/tree/master/Android/img/see.gif)

> 如果需要其他类似效果修改这个方法即可高度自定义，匆匆忙忙没有封装，觉得封装意义不大

```java
   public void draw(Canvas canvas) {
        Random random = new Random();
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int spx = random.nextInt(speedMax * 2) - speedMax;
        float x1 = startPoint.x;
        float y1 = startPoint.y - 1;
        if (y1 < -h_fl) {
            y1 = height + h_fl;
            x1 = random.nextInt(width);
        }
//        if (x1 > width) {
//            x1 -= spx;
//        }
//        if (x1 < -w_fl) {
//            x1 += spx;
//        }
        int co = random.nextInt(3);
        if (co == 0) {
            mPaint.setColor(Color.YELLOW);
        } else if (co == 1) {
            mPaint.setColor(Color.WHITE);
        } else if (co == 2) {
            mPaint.setColor(Color.GREEN);
        }
        startPoint.set(x1, y1);
        canvas.drawCircle(startPoint.x, startPoint.y, w_fl / 2, mPaint);
    }
```

### ios效果图
![](https://github.com/yaooort/ParticleView/blob/master/img/see.gif)

> ios两种方式，使用layer性能好很多内存维持在14M左右，使用View内存70M

``` objective-c
#pragma mark--在Layer上绘制
-(void)drawLayer:(CGContextRef) context{
    self.y-=1;
    if(self.y<0){
        int width = self.rect.size.width;
        self.x = arc4random() % width;
        self.y = self.rect.size.height;
    }
    //1.绘制图形
    //画一个圆
//    CGContextAddArc(context, self.x, self.y, 1, 0, 2*PI, 0); //添加一个圆
    CGContextAddEllipseInRect(context, CGRectMake(self.x, self.y, 1, 1));
    int rc = arc4random_uniform(3);
    if(rc==0){
        CGContextSetFillColorWithColor(context, [UIColor blueColor].CGColor);//填充颜色
    }else if(rc==1){
        CGContextSetFillColorWithColor(context, [UIColor whiteColor].CGColor);//填充颜色
    }else if(rc==2){
        CGContextSetFillColorWithColor(context, [UIColor greenColor].CGColor);//填充颜色
    }
    //2.渲染
    CGContextFillPath(context);
}

```

