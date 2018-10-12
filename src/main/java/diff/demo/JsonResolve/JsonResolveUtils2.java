package diff.demo.JsonResolve;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.jayway.jsonpath.JsonPath;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsonResolveUtils2 {

    public static Object jsonResolve(JSONArray dataSource, Map<String, Object> params) {

        JSONArray resArray=new JSONArray();
        for (Object array : dataSource) {
            JSONObject  jsonObject=new JSONObject();
            Iterator<Map.Entry<String, Object>> it = params.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> item = it.next();
                Object temp = JSONPath.eval(array, item.getKey());
                jsonObject.put(item.getKey().substring(item.getKey().lastIndexOf(".") + 1, item.getKey().length()),temp);
            }
            resArray.add(jsonObject);
        }

        return resArray;
    }

}
