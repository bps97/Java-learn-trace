package demo1;


/**
 * 基于JDK的代理模式，通过实现同一接口，
 * 对于代理类而言，代理类在被代理类业务执行前拦截了被代理业务，然后操作。
 * 对于客户而言，使用接口进行业务。
 */
public class Client {

    public String name = "[Client]";

    public static void main(String[] args) {

        new Client().buySomeFromAgent(100f);

    }

    /**
     * 客户从厂家处直接买
     * @param money
     */

    public void buySomeFromProducer(Float money){

        System.out.println(name+" have some money : $"+money +" , then He buy some");

        IProducer store = new Producer();

        store.saleProduct(money);

        return;

    }

    /**
     *  客户从代理商处买
     * @param money
     */

    public void buySomeFromAgent(Float money){

        System.out.println(name+" have some money : $"+money +" , then He buy some");

        IProducer agent = (IProducer)Agent.getAgent();

        agent.saleProduct(money);

        return;
    }

}
