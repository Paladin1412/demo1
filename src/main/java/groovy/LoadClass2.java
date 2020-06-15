/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package groovy;

import com.alibaba.fastjson.JSON;
import groovy.lang.Binding;
import groovy.lang.GroovyObject;
import groovy.util.GroovyScriptEngine;
import org.codehaus.groovy.jsr223.GroovyScriptEngineImpl;

import javax.script.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @FileName: LoadClass2.java
 * @Description: LoadClass2.java类说明
 * @Author: wei.tang
 * @Date: 2020/6/15 17:24
 */
public class LoadClass2 {
    static String path = "C:\\Users\\lenovo\\Desktop\\demo1\\src\\main\\java\\fengkongyingqing\\groovy\\Test3.groovy";

    public static void main(String[] args) throws Exception {
//        testGroovy3();
        ssss();
    }

    static void ssss() throws Exception {
        //准备参数，前端传入
        Map<String, Object> mapParam = new HashMap<>();
        mapParam.put("p1", LoadClass.source);
        //Groovy脚本入参
        Map<String, Object> map = new HashMap<>();
        map.put("ctx", mapParam);

        Bindings bindings = new SimpleBindings();
        bindings.putAll(map);

        GroovyScriptEngineImpl groovyScriptEngine = (GroovyScriptEngineImpl) new ScriptEngineManager().getEngineByName("groovy");

        //获取脚本内容，内存中获取
        String content = getContent(path);
        CompiledScript compile = groovyScriptEngine.compile(content);

        //执行脚本
        Object eval = compile.eval(bindings);
        System.out.println(eval);
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









    public static void testGroovy3() {
        try {
            Ctx ctx = new Ctx();
            ctx.p1 = 2;
            ctx.p2 = "hello";
            GroovyScriptEngine groovyScriptEngine = new GroovyScriptEngine("groovy");
//            ScriptEngine groovy = new ScriptEngineManager().getEngineByName("groovy");
            Class scriptClass = groovyScriptEngine.loadScriptByName("C:\\Users\\lenovo\\Desktop\\demo1\\src\\main\\java\\groovy\\hello2.groovy");
            GroovyObject scriptInstance = (GroovyObject) scriptClass.newInstance();
            Object ret = scriptInstance.invokeMethod("helloWithParam", new Object[]{ctx});
            System.out.println("testGroovy2:" + ret);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception e=" + e.toString());
        }
    }
}
