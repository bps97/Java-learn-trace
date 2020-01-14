package demo2;


public class Producer implements IProducer {

    private String name = "[Producer]";


    @Override
    public String getName() {
        return name;
    }






    @Override
    public void saleProduct(Float money) {

        System.out.println(getName()+" sale some...");

        System.out.println("To "+getName()+ ",sale product totally get :$ "+money+"!");
        return ;
    }
}
