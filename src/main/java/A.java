/**
 * @author duyuan
 * 18/3/19-上午11:19
 */
public class A {

    public void test() throws ClassNotFoundException {
        Class.forName("wtf", false, this.getClass().getClassLoader());
    }

    public void test2() throws ClassNotFoundException {
        Class.forName("java.lang.String");
    }

}
