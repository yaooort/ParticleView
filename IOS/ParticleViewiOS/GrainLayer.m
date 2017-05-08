//
//  GrainLayer.m
//  ParticleViewiOS
//
//  Created by bunny on 2017/5/8.
//  Copyright © 2017年 oort. All rights reserved.
//

#import "GrainLayer.h"
#import "Grain.h"
@interface GrainLayer()

@property(nonatomic,strong) NSMutableArray *array;

@end

@implementation GrainLayer

-(instancetype)initWithFrame:(CGRect)frame
{
    if(self=[super init]){
        self.array = [NSMutableArray array];
        self.frame = frame;
        self.bounds = frame;
        for(int i=0;i<500;i++){
            Grain *g = [[Grain alloc] init:self.frame];
            [self.array addObject:g];
            NSTimer *timer = [NSTimer scheduledTimerWithTimeInterval:0.1 target:self
                                                            selector:@selector(start) userInfo:nil repeats:true];
        }
    }
    return self;
}






#pragma mark 绘制
- (void)drawInContext:(CGContextRef)ctx {
    //获得处理的上下文
    CGContextClearRect(ctx,self.frame);
    for (Grain *g in self.array) {
        [g drawLayer:ctx];
    }

}
#pragma mark--重绘
-(void)start{
    dispatch_queue_t mainQueue = dispatch_get_main_queue();
    dispatch_async(mainQueue,^{
        [self setNeedsDisplay];
    });
}
@end
