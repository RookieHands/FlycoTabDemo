/**
 * Copyright 2017 yidong
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.mac.flycotabdemo.Utils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 文 件 名: Constant

 * 描   述：常量
 */
public class Constant {

    public static final long ONE_SECOND = 1000;
    public static final long ONE_MINUTE = ONE_SECOND * 60;
    public static final long ONE_HOUR = ONE_MINUTE * 60;
    public static final long ONE_DAY = ONE_HOUR * 24;

    public static String[] sTabTitles = {"每日干货", "分类阅读", "匠心写作", "关于"};



    public static ArrayList<String> sCategoryList = new ArrayList<String>() {
        {
            add("all");
            add("Android");
            add("瞎推荐");
            add("iOS");
            add("前端");
            add("拓展资源");
            add("App");
            add("休息视频");
            add("福利");
        }
    };

    public static boolean sCategryListChanged = false;

}
