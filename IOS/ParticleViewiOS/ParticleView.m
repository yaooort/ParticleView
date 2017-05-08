//
//  ParticleView.m
//  ParticleViewiOS
//
//  Created by bunny on 2017/5/4.
//  Copyright © 2017年 oort. All rights reserved.
//

#import "ParticleView.h"
#import "Grain.h"

@interface ParticleView()

@property(nonatomic,strong) NSMutableArray *array;

@end

@implementation ParticleView

-(instancetype)initWithFrame:(CGRect)frame
{
    if(self=[super initWithFrame:frame]){
        self.array = [NSMutableArray array];
        for(int i=0;i<500;i++){
            Grain *g = [[Grain alloc] init:frame];
            [self.array addObject:g];
            NSTimer *timer = [NSTimer scheduledTimerWithTimeInterval:0.04 target:self
                                                            selector:@selector(start) userInfo:nil repeats:true];
        }
        
    }
    return self;
}

/*
 Only override drawRect: if you perform custom drawing.
 An empty implementation adversely affects performance during animation.
 */
- (void)drawRect:(CGRect)rect {
    //获得处理的上下文
    CGContextRef
    context = UIGraphicsGetCurrentContext();
    CGContextClearRect(context,rect);
    for (Grain *g in self.array) {
        [g draw:context];
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
