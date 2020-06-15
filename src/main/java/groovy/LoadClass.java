/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @FileName: LoadClass.java
 * @Description: 执行groovy脚本
 * @Author: wei.tang
 * @Date: 2020/6/15 9:38
 */
public class LoadClass {
    static String path = "C:/Users/lenovo/Desktop/demo1/src/main/java/groovy/demo.groovy";
    static List<Param> params = new ArrayList<>();

    static void init() {
        Param param = new Param();
        param.key = "p1";
        param.value = 5;
        params.add(param);
        Param param1 = new Param();
        param1.key = "p2";
        param1.value = "abc";
        params.add(param1);
    }

    public static void main(String[] args) throws IOException {
        init();
        GroovyShell shell = new GroovyShell(getParam(params));
        Object result = shell.evaluate(getContent(path));
        System.out.println(result);
    }

    static Binding getParam(List<Param> params) {
        Binding binding = new Binding();
        for (int i = 0; i < params.size(); i++) {
            Param param = params.get(i);
            binding.setVariable(param.key,param.value);
        }
        return binding;
    }

    static String getContent(String path) throws IOException {
        InputStream is = new FileInputStream(new File(path));
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String content;
        while (true) {
            content = reader.readLine();
            if (content == null) {
                break;
            }
            builder.append(content + "\n");
        }
        return builder.toString();
    }

}
