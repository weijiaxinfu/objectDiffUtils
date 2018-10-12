package diff.demo.JsonResolve;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.jayway.jsonpath.JsonPath;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsonResolveUtils {

    public static String jsonResolve(JSONArray dataSource, Map<String, Object> params) {
        Map<String, Object> rootMap = new HashMap<>();
        Map<String, Object> childMap = new HashMap<>();

        Iterator<Map.Entry<String, Object>> it = params.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> item = it.next();
//            Object temp = JSONPath.eval(dataSource, item.getKey());
            Object temp=JsonPath.read(dataSource,item.getKey());
            //JSONPath.set(dataSource,"$.store.number",999);
            childMap.put(item.getKey().substring(item.getKey().lastIndexOf(".") + 1, item.getKey().length()), temp);
            //res.put(item.getKey(), temp);
        }
        rootMap.put("data", childMap);

        return JSONObject.toJSONString(rootMap);
    }

}
