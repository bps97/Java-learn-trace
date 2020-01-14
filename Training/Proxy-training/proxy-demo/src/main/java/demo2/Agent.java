package demo2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

public class Agent {

    public static String name = "[Agent]";

    public static Object getAgent(){

        IProducer producer = new Producer();

        return Enhancer.create(producer.getClass(),
                new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                        Object returnValue = null;

                        Float agentPrice = (Float)objects[0] * 0.7f;  //代理价格

                        if(objects.length>0 && "saleProduct".equals(method.getName())){


                            System.out.println(name+ " buy from "+producer.getName()+" need: $"+agentPrice+
                                    " ,so," +name+" earn: $"+((Float)objects[0]-agentPrice));


                            returnValue = method.invoke(producer,agentPrice);
                        }

                        return returnValue;

                    }
                });


    }
}
