package diff.demo.myDiff2;

import diff.demo.Person;
import diff.demo.Store;
import diff.demo.StoreInfoDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class ObjectDiffUtilsTest {

    @Test
    public void objectDiff() {
        StoreInfoDTO storeInfoDTO = new StoreInfoDTO();
        storeInfoDTO.setBrandName("BEIKE");
        storeInfoDTO.setAreaCode("123456");

        Person person=new Person();
        person.setUserName("张xixi");
        storeInfoDTO.setPerson(person);


        StoreInfoDTO storeInfoDTO1 = new StoreInfoDTO();
        storeInfoDTO1.setBrandName("DEYOU");
        storeInfoDTO1.setStoreAddress("北京");
        storeInfoDTO1.setAreaCode("1234567");
        Person person1=new Person();
        person1.setUserName("hahaha");
//        person1.setPerson(person1);
        storeInfoDTO1.setPerson(person1);


        String res = ObjectDiffUtils.objectDiff(storeInfoDTO, storeInfoDTO1,true);
        System.out.println(res);

    }
}