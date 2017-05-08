//
//  Grain.m
//  ParticleViewiOS
//
//  Created by bunny on 2017/5/4.
//  Copyright © 2017年 oort. All rights reserved.
//

#import "Grain.h"
#define PI 3.14159265358979323846
#define RGBColor(r, g, b) [UIColor colorWithRed:(r)/255.0 green:(g)/255.0 blue:(b)/255.0 alpha:1]

#define RGBAColor(r, g, b ,a) [UIColor colorWithRed:(r)/255.0 green:(g)/255.0 blue:(b)/255.0 alpha:a]

#define RandColor RGBColor(arc4random_uniform(255), arc4random_uniform(255), arc4random_uniform(255))
@implementation Grain

-(instancetype)init:(CGRect) rect
{
    if(self=[super init]){
        self.rect = rect;
        int width = self.rect.size.width;
        int height = self.rect.size.height;
        self.x= arc4random() % width;
        self.y= arc4random() % height;
        self.color = RandColor;
    }
    return self;
}
#pragma mark--在View上绘制
-(void)draw:(CGContextRef) context{
    self.y-=1;
    if(self.y<0){
        int width = self.rect.size.width;
        self.x = arc4random() % width;
        self.y = self.rect.size.height;
    }
    // x ,y ,半径
    CGContextAddArc(context, self.x, self.y, 1, 0, 2*PI, 0); //添加一个圆
    int rc = arc4random_uniform(3);
    if(rc==0){
        CGContextSetFillColorWithColor(context, [UIColor blueColor].CGColor);//填充颜色
    }else if(rc==1){
        CGContextSetFillColorWithColor(context, [UIColor whiteColor].CGColor);//填充颜色
    }else if(rc==2){
        CGContextSetFillColorWithColor(context, [UIColor greenColor].CGColor);//填充颜色
    }
    //kCGPathFill填充非零绕数规则,kCGPathEOFill表示用奇偶规则,kCGPathStroke路径,kCGPathFillStroke路径填充,kCGPathEOFillStroke表示描线，不是填充
    CGContextDrawPath(context, kCGPathFillStroke); //绘制路径加填充
    //2.渲染
//    CGContextFillPath(context);
}



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


@end
