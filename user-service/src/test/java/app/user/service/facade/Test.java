package app.user.service.facade;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(Config.class)
public class Test {
    @Autowired
    String string;
    @org.junit.jupiter.api.Test
    public void test(){
        System.out.println(string);
    }
}
