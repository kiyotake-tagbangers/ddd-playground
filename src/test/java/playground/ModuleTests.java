package playground;

import org.junit.jupiter.api.Test;
import org.moduliths.model.Modules;

/**
 * @author KIYOTA, Takeshi
 */
class ModuleTests {

    @Test
    void verify(){
        Modules.of(Playground.class).verify();
    }
}
