package ucdb.angular;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/ws")
public class CrudAngularApplication extends Application{
    /**
     * Definindo os Resources
     * @return
     */
    public Set<Class<?>> getClasses(){
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(EmpresaResource.class);
        return  classes;
    }
}
