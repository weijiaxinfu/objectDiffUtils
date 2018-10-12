package diff.demo.JsonResolve;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class JsonResolveUtilsTest {

    @Test
    public void jsonResolve() {
        File file = new File("./src/main/java/diff/demo/JsonResolve/test2.xml");
        Map<String, Object> map = XMLToMap.getXML(file);
        System.out.println(map);
        String test = "[\n" +
                "            {\n" +
                "                \"avatarNeedAddedResolution\": \"http://image1.ljcdn.com/usercenter/images/uc_ehr_avatar/7e6b8778-2b49-4bf1-aa34-079746125bad.jpg\",\n" +
                "                \"participantId\": 1000000020107794,\n" +
                "                \"positionName\": \"区域总监\",\n" +
                "                \"orgName\": \"江北大区\",\n" +
                "                \"orgCode\": \"JHBK3003\",\n" +
                "                \"mobile\": \"15026001018\",\n" +
                "                \"name\": \"赵谦\",\n" +
                "                \"positionCode\": \"15208\",\n" +
                "                \"avatar\": \"http://image1.ljcdn.com/usercenter/images/uc_ehr_avatar/7e6b8778-2b49-4bf1-aa34-079746125bad.jpg.180x240.jpg?v=1\",\n" +
                "                \"usercode\": \"20107794\",\n" +
                "                \"email\": \"79349106@test.com\",\n" +
                "                \"createDate\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"avatarNeedAddedResolution\": \"\",\n" +
                "                \"participantId\": 1000000020129685,\n" +
                "                \"positionName\": \"区域经理\",\n" +
                "                \"orgName\": \"江北大区\",\n" +
                "                \"orgCode\": \"JHBK3003\",\n" +
                "                \"mobile\": \"15021362006\",\n" +
                "                \"name\": \"敬建平\",\n" +
                "                \"positionCode\": \"15210\",\n" +
                "                \"avatar\": \"\",\n" +
                "                \"usercode\": \"20129685\",\n" +
                "                \"email\": \"07019200@test.com\",\n" +
                "                \"createDate\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"avatarNeedAddedResolution\": \"http://image1.ljcdn.com/usercenter/images/uc_ehr_avatar/df0fcd9f-e43b-4091-9db7-343c0c6ee801.png\",\n" +
                "                \"participantId\": 1000000020118245,\n" +
                "                \"positionName\": \"储备区域经理\",\n" +
                "                \"orgName\": \"江北大区\",\n" +
                "                \"orgCode\": \"JHBK3003\",\n" +
                "                \"mobile\": \"15077781891\",\n" +
                "                \"name\": \"龚建辉\",\n" +
                "                \"positionCode\": \"15211\",\n" +
                "                \"avatar\": \"http://image1.ljcdn.com/usercenter/images/uc_ehr_avatar/df0fcd9f-e43b-4091-9db7-343c0c6ee801.png.189x250.png?v=1\",\n" +
                "                \"usercode\": \"20118245\",\n" +
                "                \"email\": \"83077026@test.com\",\n" +
                "                \"createDate\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"avatarNeedAddedResolution\": \"http://image1.ljcdn.com/usercenter/images/uc_ehr_avatar/3e28d192-08cf-42dd-8be6-cffada6f6a6c.jpg\",\n" +
                "                \"participantId\": 1000000020150410,\n" +
                "                \"positionName\": \"储备区域经理\",\n" +
                "                \"orgName\": \"江北大区\",\n" +
                "                \"orgCode\": \"JHBK3003\",\n" +
                "                \"mobile\": \"15079889725\",\n" +
                "                \"name\": \"张鹏\",\n" +
                "                \"positionCode\": \"15211\",\n" +
                "                \"avatar\": \"http://image1.ljcdn.com/usercenter/images/uc_ehr_avatar/3e28d192-08cf-42dd-8be6-cffada6f6a6c.jpg.413x626.jpg?v=1\",\n" +
                "                \"usercode\": \"20150410\",\n" +
                "                \"email\": \"44754744@test.com\",\n" +
                "                \"createDate\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"avatarNeedAddedResolution\": \"http://image1.ljcdn.com/usercenter/images/uc_ehr_avatar/4cb9db68-9f49-4657-ab8b-cdf17b6150d0.jpg\",\n" +
                "                \"participantId\": 1000000020178057,\n" +
                "                \"positionName\": \"储备区域经理\",\n" +
                "                \"orgName\": \"江北大区\",\n" +
                "                \"orgCode\": \"JHBK3003\",\n" +
                "                \"mobile\": \"15074482416\",\n" +
                "                \"name\": \"范先鹏\",\n" +
                "                \"positionCode\": \"15211\",\n" +
                "                \"avatar\": \"http://image1.ljcdn.com/usercenter/images/uc_ehr_avatar/4cb9db68-9f49-4657-ab8b-cdf17b6150d0.jpg.260x343.jpg?v=1\",\n" +
                "                \"usercode\": \"20178057\",\n" +
                "                \"email\": \"64320457@test.com\",\n" +
                "                \"createDate\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"avatarNeedAddedResolution\": \"http://image1.ljcdn.com/usercenter/images/uc_ehr_avatar/fe3e88f8-143d-4ee1-9e95-c743830d24b4.png\",\n" +
                "                \"participantId\": 1000000020209064,\n" +
                "                \"positionName\": \"储备区域经理\",\n" +
                "                \"orgName\": \"江北大区\",\n" +
                "                \"orgCode\": \"JHBK3003\",\n" +
                "                \"mobile\": \"15025772907\",\n" +
                "                \"name\": \"龚磊\",\n" +
                "                \"positionCode\": \"15211\",\n" +
                "                \"avatar\": \"http://image1.ljcdn.com/usercenter/images/uc_ehr_avatar/fe3e88f8-143d-4ee1-9e95-c743830d24b4.png.189x250.png?v=1\",\n" +
                "                \"usercode\": \"20209064\",\n" +
                "                \"email\": \"71233544@test.com\",\n" +
                "                \"createDate\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"avatarNeedAddedResolution\": \"http://image1.ljcdn.com/usercenter/images/uc_ehr_avatar/38418abd-2f27-4392-8d1c-71a77c505075.jpg\",\n" +
                "                \"participantId\": 1000000020229983,\n" +
                "                \"positionName\": \"储备区域经理\",\n" +
                "                \"orgName\": \"江北大区\",\n" +
                "                \"orgCode\": \"JHBK3003\",\n" +
                "                \"mobile\": \"15051166067\",\n" +
                "                \"name\": \"杜万润\",\n" +
                "                \"positionCode\": \"15211\",\n" +
                "                \"avatar\": \"http://image1.ljcdn.com/usercenter/images/uc_ehr_avatar/38418abd-2f27-4392-8d1c-71a77c505075.jpg.120x160.jpg?v=1\",\n" +
                "                \"usercode\": \"20229983\",\n" +
                "                \"email\": \"87669814@test.com\",\n" +
                "                \"createDate\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"avatarNeedAddedResolution\": \"http://image1.ljcdn.com/usercenter/images/uc_ehr_avatar/72279eeb-2b50-4aff-911d-3518e75c20fc.jpg\",\n" +
                "                \"participantId\": 1000000020297832,\n" +
                "                \"positionName\": \"储备区域经理\",\n" +
                "                \"orgName\": \"江北大区\",\n" +
                "                \"orgCode\": \"JHBK3003\",\n" +
                "                \"mobile\": \"15044494426\",\n" +
                "                \"name\": \"李潘\",\n" +
                "                \"positionCode\": \"15211\",\n" +
                "                \"avatar\": \"http://image1.ljcdn.com/usercenter/images/uc_ehr_avatar/72279eeb-2b50-4aff-911d-3518e75c20fc.jpg.189x250.jpg?v=1\",\n" +
                "                \"usercode\": \"20297832\",\n" +
                "                \"email\": \"08284322@test.com\",\n" +
                "                \"createDate\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"avatarNeedAddedResolution\": \"http://image1.ljcdn.com/usercenter/images/uc_ehr_avatar/606e6840-1776-42cf-a239-18c40b91ccad.jpg\",\n" +
                "                \"participantId\": 1000000020328407,\n" +
                "                \"positionName\": \"储备区域经理\",\n" +
                "                \"orgName\": \"江北大区\",\n" +
                "                \"orgCode\": \"JHBK3003\",\n" +
                "                \"mobile\": \"15099525781\",\n" +
                "                \"name\": \"胡建\",\n" +
                "                \"positionCode\": \"15211\",\n" +
                "                \"avatar\": \"http://image1.ljcdn.com/usercenter/images/uc_ehr_avatar/606e6840-1776-42cf-a239-18c40b91ccad.jpg.260x260.jpg?v=1\",\n" +
                "                \"usercode\": \"20328407\",\n" +
                "                \"email\": \"50110979@test.com\",\n" +
                "                \"createDate\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"avatarNeedAddedResolution\": \"http://image1.ljcdn.com/usercenter/images/uc_ehr_avatar/a7691fef-4678-4163-a417-63a64af2edac.png\",\n" +
                "                \"participantId\": 1000000020108256,\n" +
                "                \"positionName\": \"储备区域经理\",\n" +
                "                \"orgName\": \"江北大区\",\n" +
                "                \"orgCode\": \"JHBK3003\",\n" +
                "                \"mobile\": \"15094094397\",\n" +
                "                \"name\": \"郭祥\",\n" +
                "                \"positionCode\": \"15211\",\n" +
                "                \"avatar\": \"http://image1.ljcdn.com/usercenter/images/uc_ehr_avatar/a7691fef-4678-4163-a417-63a64af2edac.png.189x250.png?v=1\",\n" +
                "                \"usercode\": \"20108256\",\n" +
                "                \"email\": \"05305517@test.com\",\n" +
                "                \"createDate\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"avatarNeedAddedResolution\": \"\",\n" +
                "                \"participantId\": 1000000023030150,\n" +
                "                \"positionName\": \"储备区域经理\",\n" +
                "                \"orgName\": \"江北大区\",\n" +
                "                \"orgCode\": \"JHBK3003\",\n" +
                "                \"mobile\": \"15055017491\",\n" +
                "                \"name\": \"陈传奇\",\n" +
                "                \"positionCode\": \"15211\",\n" +
                "                \"avatar\": \"\",\n" +
                "                \"usercode\": \"23030150\",\n" +
                "                \"email\": \"24821906@test.com\",\n" +
                "                \"createDate\": null\n" +
                "            }\n" +
                "        ]";

        JSONArray  jsonArray=JSON.parseArray(test);

        Object res=JsonResolveUtils2.jsonResolve(jsonArray, map);
        System.out.println(res);

    }
}