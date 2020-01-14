package demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Agent {

    public static String name = "[Agent]";

    public static Object getAgent(){

        IProducer producer = new Producer();

        return Proxy.newProxyInstance(
                producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        Object returnValue = null;

                        Float agentPrice = (Float)args[0] * 0.8f;  //代理价格

                        if(args.length>0 && method.getName().equals("saleProduct")){


                            System.out.println(name+ " buy from "+producer.getName()+" need: $"+agentPrice+
                                    " ,so," +name+" earn: $"+((Float)args[0]-agentPrice));


                            returnValue = method.invoke(producer,agentPrice);
                        }

                        return returnValue;
                    }
                });


    }
}
