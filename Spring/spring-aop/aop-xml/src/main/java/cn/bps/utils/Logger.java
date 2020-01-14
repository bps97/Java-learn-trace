package cn.bps.utils;


import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 日志工具类
 */
public class Logger {


    /**
     * 用于打印日志，计划在切入点方法执行之前执行
     */
    public void beforeAdvice(){
        System.out.println("Logger类:这是一个前置通知,日志系统正在打开");
    }

    public void returningAdvice(){
        System.out.println("Logger类:这是一个后置通知，日志系统正常关闭");
    }

    public void throwingAdvice(){
        System.out.println("Logger类:这是一个异常通知，检测到一个异常，打印日志");
    }

    public void finalAdvice(){
        System.out.println("Logger类:这是一个最终通知，日志最终关闭了");
    }



    /*环绕通知相当于各种通知结合，可以手动控制增强方法何时执行*/

    /* 配置了环绕通知 切入点方法没有 执行 二通知方法执行了(如果没ProceedingJoinPoint) */
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        Object returnValue = null;
        try {
            Object[] args = proceedingJoinPoint.getArgs();
            System.out.println("Logger类：这是一个环绕通知");  //相当于前置通知
            returnValue = proceedingJoinPoint.proceed(); /*明确调用切入点方法*/
            return returnValue;
        } catch (Throwable throwable) {
            throw  new RuntimeException(throwable);
        } finally {
            ;
        }

    }

}
