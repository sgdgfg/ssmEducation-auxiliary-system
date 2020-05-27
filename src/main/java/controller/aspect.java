package controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class aspect {
    @Pointcut("execution(* mapper.*.*(..))")
    //定义一个返回值为void、方法体为空的方法来命名切入点
    private void myPointCut(){

    }

    @Before("myPointCut()")
    public void aspect1(JoinPoint joinpoint){
        System.out.println("前置通知："+joinpoint);
        System.out.println("被植入增强处理的目标方法为："+joinpoint.getSignature().getName());
    }
    @Before("args(mapper.inUser)")
    public void aspect2(JoinPoint joinpoint){
        System.out.println("前置通知11："+joinpoint);
        System.out.println("被植入增强处理的目标方法为："+joinpoint.getSignature().getName());
    }

}
