import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * @author duyuan
 * 18/3/3-上午8:46
 */
public class Main {

    static File t = new File(System.getProperty("user.dir")+"/test-1.0-SNAPSHOT.jar");

    public static void main(String[] args) throws Exception {
        MyClassLoader classLoader = new MyClassLoader(new URL[]{t.toURI().toURL()}, null);
        int count = 0;
        while(true) {
            try {
                Class a = Class.forName("A", false, classLoader);
                Method m = a.getMethod("test");
                m.invoke(a.newInstance());
            }catch (InvocationTargetException err){
                System.out.println(err.getCause());
            }catch (Exception ignore){}
            finally {
                System.out.println(count++);
            }
        }
    }

}
