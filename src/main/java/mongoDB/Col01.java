package mongoDB;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data
@Setter
@Getter
public class Col01 {
    private String name;
    private int age;
    private String sex;
    Col01(){}
    Col01(String name,int age,String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

}
