package zxykj;

import java.util.UUID;

/**
 * - （选答）系统设计题
 * 1）请分析题⽬目需求，给出你认为合理理的技术⽅方案，技术⽅方案格式可参考原公司；
 * 2）请充分通过题⽬目展现你的设计方法，设计理念。
 *  对于关键的技术选型，给出适当注解；
 *
 *  需求描述：设计一个服务，任何人调用这个服务，都返回一个unique id，不能重复；
 */
public class Test7 {
    /**
     * 1.统一封装服务的返回的结果
     * 2.使用uuid来标识
     * @param args
     */
    public static void main(String[] args) {
        Test7 service = new Test7();
        ResponseData responseData = service.service1(); //调用服务
        String unique_id = responseData.getId();
        Object result = responseData.getData();
        System.out.println(unique_id+" "+result);
    }
    public ResponseData service1(){
        Object resule  = null;
        String uuid = UUID.randomUUID().toString();
        try {
            //...
            //...
            resule = null;//service1执行后的结果
            return new ResponseData(uuid,resule);
        }catch (Exception e){
            return new ResponseData(uuid,resule);
        }
    }

    class ResponseData{
        private String id;
        private Object data;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public ResponseData() {
        }

        public ResponseData(String id, Object data) {
            this.id = id;
            this.data = data;
        }
    }
}
