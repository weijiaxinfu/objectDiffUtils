//package diff.demo.myDiff;
//
//import com.alibaba.fastjson.JSON;
//import java.lang.reflect.Field;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//public class ObjectDiffUtils {
//    /**
//     * 单个对象的所有键值
//     *
//     * @param obj
//     * @return Map<String ,Object> map
//     */
//    private static Map<String, Object> getKeyAndValue(Object obj) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        // 得到类对象
//        Class userCla = (Class) obj.getClass();
//        /* 得到类中的所有属性集合 */
//        Field[] fs = userCla.getDeclaredFields();
//        for (int i = 0; i < fs.length; i++) {
//            Field f = fs[i];
//            f.setAccessible(true); // 设置些属性是可以访问的
//            Object val = new Object();
//            try {
//                val = f.get(obj);
//                // 得到此属性的值
//                map.put(f.getName(), val);// 设置键值
//            } catch (IllegalArgumentException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//        return map;
//    }
//
//    /**
//     * diff全部属性
//     *
//     * @param before
//     * @param after
//     * @return
//     */
//    private static String objectDiff(Object before, Object after) {
//        Map<String, Object> beforeMap = getKeyAndValue(before);
//        Map<String, Object> afterMap = getKeyAndValue(after);
//        Iterator<Map.Entry<String, Object>> iterator = afterMap.entrySet().iterator();
//        StringBuilder res = new StringBuilder();
//        while (iterator.hasNext()) {
//            Map.Entry<String, Object> entry = iterator.next();
//            if (!entry.getValue().equals(beforeMap.get(entry.getKey()))) {
//                res.append("changed " + entry.getKey() + " from " + JSON.toJSONString(beforeMap.get(entry.getKey())) + " to " + JSON.toJSONString(entry.getValue()) + " ; ");
//            }
//        }
//        return res.toString();
//    }
//
//    /**
//     * 只diff指定的属性
//     *
//     * @param before
//     * @param after
//     * @param propertys
//     * @return
//     */
//    private static String objectDiffContain(Object before, Object after, List<String> propertys) {
//        Map<String, Object> beforeMap = getKeyAndValue(before);
//        Map<String, Object> afterMap = getKeyAndValue(after);
//        Iterator<Map.Entry<String, Object>> iterator = afterMap.entrySet().iterator();
//        StringBuilder res = new StringBuilder();
//        while (iterator.hasNext()) {
//            Map.Entry<String, Object> entry = iterator.next();
//            if (propertys.contains(entry.getKey()) && !entry.getValue().equals(beforeMap.get(entry.getKey()))) {
//                res.append("changed " + entry.getKey() + " from " + JSON.toJSONString(beforeMap.get(entry.getKey())) + " to " + JSON.toJSONString(entry.getValue()) + " ; ");
//            }
//        }
//        return res.toString();
//    }
//
//
//    /**
//     * 排除某些属性的diff
//     *
//     * @param before
//     * @param after
//     * @param excludes
//     * @return
//     */
//    private static String objectDiffExclude(Object before, Object after, List<String> excludes) {
//        Map<String, Object> beforeMap = getKeyAndValue(before);
//        Map<String, Object> afterMap = getKeyAndValue(after);
//        Iterator<Map.Entry<String, Object>> iterator = afterMap.entrySet().iterator();
//        StringBuilder res = new StringBuilder();
//        while (iterator.hasNext()) {
//            Map.Entry<String, Object> entry = iterator.next();
//            if (!excludes.contains(entry.getKey()) && !entry.getValue().equals(beforeMap.get(entry.getKey()))) {
//                res.append("changed " + entry.getKey() + " from " + JSON.toJSONString(beforeMap.get(entry.getKey())) + " to " + JSON.toJSONString(entry.getValue()) + " ; ");
//            }
//        }
//        return res.toString();
//    }
//
//    /**
//     *
//     * @param before  操作前的对象
//     * @param after   操作后的对象
//     * @param propertys  指定需要diff的属性
//     * @param excludes   不需要diff的属性
//     * @param showChanges 是否输出整体改变
//     * @return
//     */
//    public static String objectDiff(Object before, Object after, List<String> propertys, List<String> excludes, boolean showChanges) {
//        String res = null;
//        if ((propertys == null || propertys.size() == 0) && (excludes == null || excludes.size() == 0)) {
//            res = objectDiff(before, after);
//        } else if ((propertys == null || propertys.size() == 0)) {
//            res = objectDiffExclude(before, after, excludes);
//        } else {
//            res = objectDiffContain(before, after, propertys);
//        }
//        if (res == null || res.equals("")) {
//            res = "no change !";
//        } else {
//            if (showChanges) {
//                res += "changed  from " + JSON.toJSONString(before) + " to " + JSON.toJSONString(after) + " ; ";
//            }
//        }
//        return res;
//
//    }
//
//
//}
