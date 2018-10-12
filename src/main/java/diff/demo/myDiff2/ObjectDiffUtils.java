package diff.demo.myDiff2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.String;
import java.lang.Object;




public class ObjectDiffUtils {

    private static Node getKeyAndValue(Object obj, Node root) {

        // 得到类对象
        Class model = (Class) obj.getClass();
        int flag = 0;//默认类上未加Diff  or  NotDiff注解
        //递归获取父类的的属性，排除Object类的影响
        while (model != null && !model.getName().toLowerCase().equals("java.lang.object")) {
            //判断类上是否标注了Diff or NotDiff注解
            if (model.getAnnotation(Diff.class) != null) {
                flag = 1;//类上有Diff注解
            } else if (model.getAnnotation(NotDiff.class) != null) {
                flag = 2;//类上有NotDiff注解
            }
            /* 得到类中的所有属性集合 */
            getPropertyTree(model, flag, obj, root);
            //获取父类
            model = model.getSuperclass();
        }
        return root;
    }

    private static void getPropertyTree(Class model, int flag, Object obj, Node root) {
        Field[] fs = model.getDeclaredFields();
        switch (flag) {
            case 0:
                for (int i = 0; i < fs.length; i++) {
                    Field f = fs[i];
                    if (f.getAnnotation(Diff.class) != null) {//注解了Diff的属性加入Tree
                        buildNode(f, root, obj);
                    }
                }
                //return root;
            case 1:
                for (int i = 0; i < fs.length; i++) {
                    Field f = fs[i];
                    if (f.getAnnotation(NotDiff.class) == null) {//未加NotDiff的属性加入map
                        buildNode(f, root, obj);
                    }
                }
                //return root;

            case 2:
                for (int i = 0; i < fs.length; i++) {
                    Field f = fs[i];
                    if (f.getAnnotation(Diff.class) != null) {//注解了Diff的属性放入map
                        buildNode(f, root, obj);

                    }
                }
                //return root;
        }
        //return root;
    }

    private static void buildNode(Field f, Node root, Object obj) {
        f.setAccessible(true); // 设置属性是可以访问的
        Object val = new Object();
        Type type = f.getGenericType();
        try {
            val = f.get(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String nodeName = "";
        if (root != null && root.getName() != null) {
            nodeName = root.getName() + ".";
        }
        nodeName += f.getName();
        if (val != null && !isBaseObject(type)) {

            Node childNode = new Node(nodeName, val, true);
            root.addChildNode(childNode);
            getKeyAndValue(val, childNode);
        } else {
            Node childNode = new Node(nodeName, val, false);
            root.addChildNode(childNode);
        }
    }


    /**
     * 判断当前属性是否是基本类型
     *
     * @param type
     * @return
     */
    private static boolean isBaseObject(Type type) {
        String name = type.getTypeName().toLowerCase();
        return name.startsWith("java.lang") || name.startsWith("java.util") || ((!name.startsWith("java.lang")) && (!name.startsWith("java.util")));
    }


    /**
     * @param before
     * @param after
     * @return
     */
    public static String objectDiff(Object before, Object after) {
        boolean showChanges = false;
        return objectDiff(before, after, showChanges);
    }

    /**
     * @param before      操作前的对象
     * @param after       操作后的对象
     * @param showChanges 是否输出整体改变
     * @return
     */
    public static String objectDiff(Object before, Object after, boolean showChanges) {
        Node beforeRoot = new Node(before.getClass().getSimpleName(), "/", true);
        Node afterRoot = new Node(after.getClass().getSimpleName(), "/", true);
        Node beforeNode = getKeyAndValue(before, beforeRoot);
        Node afterNode = getKeyAndValue(after, afterRoot);

        StringBuilder res = new StringBuilder();
        diffNodeTree(beforeNode, afterNode, res);

        JSONObject json=new JSONObject();
        diffNodeTree2(beforeNode,afterNode,json);

        if (showChanges) {
            res.append("All Change :" + JSON.toJSONString(before) + " -> " + JSON.toJSONString(after) + " ; ");
        }

        return res.toString();
    }


    public static void diffNodeTree(Node<Object> beforeNode, Node<Object> afterNode, StringBuilder res) {
        if ((beforeNode != null && beforeNode.getChildNodes() != null)
                && (afterNode != null && afterNode.getChildNodes() != null)) {
            for (int i = 0, j = 0; i < beforeNode.getChildNodes().size() && j < afterNode.getChildNodes().size(); i++, j++) {
                Node<Object> childBefore = beforeNode.getChildNodes().get(i);
                Node<Object> childAfter = afterNode.getChildNodes().get(j);

                if ((childBefore.isFlag() == true && childAfter.isFlag() == true)
                        && (childBefore.getChildNodes() != null && childAfter.getChildNodes() != null)) {
                    diffNodeTree(childBefore, childAfter, res);
                } else if (childBefore.isFlag() != childAfter.isFlag()
                        || (childBefore.isFlag() == false && childAfter.isFlag() == false)
                        || childBefore.getChildNodes() == null
                        || childAfter.getChildNodes() == null) {

                    if (!(childBefore.getNodeEntity() == null ? childAfter.getNodeEntity() == null : childBefore.getNodeEntity().equals(childAfter.getNodeEntity()))) {
                        res.append(childBefore.getName() + ": " + JSON.toJSONString(childBefore.getNodeEntity()) + " -> " + JSON.toJSONString(childAfter.getNodeEntity()) + " ; ");
                    }
                }
            }

        }
    }

    /*优化diff返回格式*/
    public static void diffNodeTree2(Node<Object> beforeNode, Node<Object> afterNode, JSONObject json) {
        if ((beforeNode != null && beforeNode.getChildNodes() != null)
                && (afterNode != null && afterNode.getChildNodes() != null)) {
            for (int i = 0, j = 0; i < beforeNode.getChildNodes().size() && j < afterNode.getChildNodes().size(); i++, j++) {
                Node<Object> childBefore = beforeNode.getChildNodes().get(i);
                Node<Object> childAfter = afterNode.getChildNodes().get(j);

                if ((childBefore.isFlag() == true && childAfter.isFlag() == true)
                        && (childBefore.getChildNodes() != null && childAfter.getChildNodes() != null)) {
                    diffNodeTree2(childBefore, childAfter, json);
                } else if (childBefore.isFlag() != childAfter.isFlag()
                        || (childBefore.isFlag() == false && childAfter.isFlag() == false)
                        || childBefore.getChildNodes() == null
                        || childAfter.getChildNodes() == null) {

                    if (!(childBefore.getNodeEntity() == null ? childAfter.getNodeEntity() == null : childBefore.getNodeEntity().equals(childAfter.getNodeEntity()))) {
                        buildObject(json,childBefore,childAfter);//构建Object
                        //res.append(childBefore.getName() + ": " + JSON.toJSONString(childBefore.getNodeEntity()) + " -> " + JSON.toJSONString(childAfter.getNodeEntity()) + " ; ");
                    }
                }
            }

        }
    }

    private static void buildObject(JSONObject json, Node<Object> childBefore, Node<Object> childAfter) {
        String[]  properties=childBefore.getName().split(".");
    }


}