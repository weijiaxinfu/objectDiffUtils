package diff.demo;

import com.alibaba.fastjson.JSON;
import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;
import de.danielbechler.diff.node.Visit;

public class ObjectDiffUtils {

    public static String ObjectDiff(Object before, Object after) {

        DiffNode diff = ObjectDifferBuilder.buildDefault().compare(after, before);

        StringBuffer res = new StringBuffer();

        diff.visit(new DiffNode.Visitor() {
            public void node(DiffNode node, Visit visit) {
                final Object baseValue = node.canonicalGet(before);
                final Object workingValue = node.canonicalGet(after);
                final String message = node.getPath() + " changed from " +
                        JSON.toJSONString(baseValue) + " to " + JSON.toJSONString(workingValue);
                res.append(message + ";");
            }
        });
        return res.toString();
    }
}
