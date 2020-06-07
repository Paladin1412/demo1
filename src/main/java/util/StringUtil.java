package util;

import com.google.common.base.Preconditions;
import org.springframework.scheduling.annotation.Async;

public class StringUtil {

    public static void main(String[] args) {
        String user_null = null;
        /**
         <dependency>
             <groupId>com.google.guava</groupId>
             <artifactId>guava</artifactId>
             <version>20.0</version>
         </dependency>
         */
        Preconditions.checkNotNull(user_null,"user is null");
    }
}
