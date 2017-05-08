//
//  Grain.h
//  ParticleViewiOS
//
//  Created by bunny on 2017/5/4.
//  Copyright © 2017年 oort. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@interface Grain : NSObject

@property(nonatomic) int x;

@property(nonatomic) int y;

@property(nonatomic) UIColor *color;

@property(nonatomic) CGRect rect;

-(instancetype)init:(CGRect) rect;

-(void)draw:(CGContextRef) context;

-(void)drawLayer:(CGContextRef) context;

@end
