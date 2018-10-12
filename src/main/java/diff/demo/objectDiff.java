package diff.demo;


import java.util.ArrayList;
import java.util.List;


public class objectDiff {
    public static void main(String[] args) {

        Person person3 = new Person();
        person3.setAddress("北京2");
        person3.setAge(26);
        person3.setUserName("longjingwen3");

        Person person4 = new Person();
        person4.setAddress("北京8");
        person4.setAge(26);
        person4.setUserName("longjingwen3");

        Person person5 = new Person();
        person5.setAddress("北京8");
        person5.setAge(26);
        person5.setUserName("longjingwen5");

        person3.setPerson(person5);


        Person person1 = new Person();
        person1.setAddress("北京");
        person1.setAge(26);
        person1.setUserName("longjingwen");
        person1.setPerson(person3);

        Person person2 = new Person();
        person2.setAddress("北京xi");
        person2.setAge(28);
        person2.setUserName("longjingwen");
        person2.setPerson(person3);

        StoreInfoDTO storeInfoDTO = new StoreInfoDTO();
//        storeInfoDTO.setStoreAddress("北京");

        StoreInfoDTO storeInfoDTO1 = new StoreInfoDTO();
//        storeInfoDTO1.setStoreAddress("上海");

//        DiffNode diff = ObjectDifferBuilder.buildDefault().compare(person2, person1);
//
//        StringBuffer res = new StringBuffer();
//
//        diff.visit(new DiffNode.Visitor() {
//            public void node(DiffNode node, Visit visit) {
//                final Object baseValue = node.canonicalGet(person1);
//                final Object workingValue = node.canonicalGet(person2);
//
//                final String message = node.getPath() + " changed from " +
//                        JSON.toJSONString(baseValue) + " to " + JSON.toJSONString(workingValue);
//                res.append(message + ";");
//
////                if (node.hasChildren()) {
////                    node.visitChildren(this);
////                    visit.dontGoDeeper();
////                }
//            }
//        });
        String res = ObjectDiffUtils.ObjectDiff(storeInfoDTO, storeInfoDTO1);
//        List<String> list = new ArrayList<>();
//        list.add("age");
//        String res =ObjectDiffUtils.objectDiff(person1, person2, list, null, false);

        System.out.println(res);

    }

}
