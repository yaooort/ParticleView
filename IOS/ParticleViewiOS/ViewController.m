//
//  ViewController.m
//  ParticleViewiOS
//
//  Created by bunny on 2017/5/4.
//  Copyright © 2017年 oort. All rights reserved.
//

#import "ViewController.h"
#import "ParticleView.h"
#import "GrainLayer.h"
@interface ViewController ()

@property(nonatomic,strong) ParticleView *particleView;

@property(nonatomic,strong) GrainLayer *layer;

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    //使用View的形式
//    self.particleView = [[ParticleView alloc] initWithFrame:self.view.bounds];
//    [self.particleView setBackgroundColor:[UIColor blackColor]];
//    [self.view addSubview:self.particleView];
//    
    //使用Layer的形式 性能优
    self.layer = [[GrainLayer alloc] initWithFrame:self.view.bounds];
    [self.layer setBackgroundColor:[[UIColor blackColor] CGColor]];
    [self.view.layer addSublayer:self.layer];
}



@end
