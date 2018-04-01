import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author duyuan
 * 18/3/4-下午4:03
 */
public class MyClassLoader extends URLClassLoader {

    private Logger logger = LoggerFactory.getLogger(MyClassLoader.class);

    public MyClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public MyClassLoader(URL[] urls) {
        super(urls);
    }

    public MyClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return loadClass(name, false);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        try{
            return super.loadClass(name, resolve);
        }catch (ClassNotFoundException e){
            if(e.getMessage().contains("sun.reflect.GeneratedMethodAccessor")){
                //to be stackOverFlow
                //System.out.println(e.getMessage());
            }
            logger.info("", e);
            return this.getClass().getClassLoader().loadClass(name);
        }
    }
}
