# ParticleView
### 星空效果
[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg)](http://www.apache.org/licenses/LICENSE-2.0)

### 效果图
![](https://github.com/yaooort/ParticleView/blob/master/img/see.gif =100x100)

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
