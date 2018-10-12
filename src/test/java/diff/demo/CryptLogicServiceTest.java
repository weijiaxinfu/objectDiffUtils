package diff.demo;

import org.junit.Test;



public class CryptLogicServiceTest {


    CryptLogicService cryptLogicService = new CryptLogicService();

    @Test
    public void decryptPhone() {
        System.out.println(cryptLogicService.encryptPhone("13028125168"));
    }

    @Test
    public void encryptPhone() {
        System.out.println(cryptLogicService.decryptPhone("653BD4F8BC3B7BD782997868B1766A5D"));
    }
}