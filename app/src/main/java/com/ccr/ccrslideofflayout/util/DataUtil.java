package com.ccr.ccrslideofflayout.util;

import com.ccr.ccrslideofflayout.model.IndexModel;
import com.ccr.ccrslideofflayout.model.NormalModel;
import com.ccr.ccrslideofflayout.widget.CharacterParser;
import com.ccr.ccrslideofflayout.widget.PinyinComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataUtil {
    private DataUtil() {
    }

    public static List<NormalModel> loadNormalModelDatas() {
        List<NormalModel> datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (i % 4 == 0) {
                datas.add(new NormalModel("标题" + i, "我是短的描述" + i));
            } else {
                datas.add(new NormalModel("标题" + i, "我是很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长的描述" + i));
            }
        }
        return datas;
    }

    public static List<IndexModel> loadIndexModelData() {
        List<IndexModel> data = new ArrayList<>();
        data.add(new IndexModel("安阳"));
        data.add(new IndexModel("鞍山"));
        data.add(new IndexModel("保定"));
        data.add(new IndexModel("包头"));
        data.add(new IndexModel("北京"));
        data.add(new IndexModel("河北"));
        data.add(new IndexModel("北海"));
        data.add(new IndexModel("安庆"));
        data.add(new IndexModel("伊春"));
        data.add(new IndexModel("宝鸡"));
        data.add(new IndexModel("本兮"));
        data.add(new IndexModel("滨州"));
        data.add(new IndexModel("常州"));
        data.add(new IndexModel("常德"));
        data.add(new IndexModel("常熟"));
        data.add(new IndexModel("枣庄"));
        data.add(new IndexModel("内江"));
        data.add(new IndexModel("阿坝州"));
        data.add(new IndexModel("丽水"));
        data.add(new IndexModel("成都"));
        data.add(new IndexModel("承德"));
        data.add(new IndexModel("沧州"));
        data.add(new IndexModel("重庆"));
        data.add(new IndexModel("东莞"));
        data.add(new IndexModel("扬州"));
        data.add(new IndexModel("甘南州"));
        data.add(new IndexModel("大庆"));
        data.add(new IndexModel("佛山"));
        data.add(new IndexModel("广州"));
        data.add(new IndexModel("合肥"));
        data.add(new IndexModel("海口"));
        data.add(new IndexModel("济南"));
        data.add(new IndexModel("兰州"));
        data.add(new IndexModel("南京"));
        data.add(new IndexModel("泉州"));
        data.add(new IndexModel("荣成"));
        data.add(new IndexModel("三亚"));
        data.add(new IndexModel("上海"));
        data.add(new IndexModel("汕头"));
        data.add(new IndexModel("天津"));
        data.add(new IndexModel("武汉"));
        data.add(new IndexModel("厦门"));
        data.add(new IndexModel("宜宾"));
        data.add(new IndexModel("张家界"));
        data.add(new IndexModel("自贡"));


        PinyinComparator pinyinComparator = new PinyinComparator();
        CharacterParser characterParser = CharacterParser.getInstance();
        for (IndexModel indexModel : data) {
            indexModel.topc = characterParser.getSelling(indexModel.name).substring(0, 1).toUpperCase();
            if (indexModel.name.equals("重庆")) {
                indexModel.topc = "C";
            }
        }
        Collections.sort(data, pinyinComparator);
        return data;
    }
}
