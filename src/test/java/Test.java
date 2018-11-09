import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: Hu Min
 * @Date: 2018/11/5 14:57
 * @Description:
 */
public class Test {
    @org.junit.Test
    public void f(){
        Pattern compile = Pattern.compile("^.*/favicon.ico$");
        Matcher matcher = compile.matcher("/favicon.ico");
        System.out.println(matcher.matches());

    }
}
