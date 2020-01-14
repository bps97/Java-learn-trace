import cn.bps.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AOPTest {

    public static void main(String[] args) {

        testGeneralAdvice();
//        testAroundAdvice();


    }

    private static void testGeneralAdvice() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"bean.xml"});

        IAccountService service = (IAccountService) context.getBean("accountService");

        service.saveAccount();
    }


    public static void testAroundAdvice(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        IAccountService service = (IAccountService) context.getBean("accountService");

        service.updateAccount(1);
        //        service.updateAccount(1);
        //        service.removeAccount();
    }
}
