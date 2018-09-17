package name.hanyi.singleton;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

public class SingletonTest {

    Singleton instance;

    @Before
    public void setUp() {
        instance = Singleton.getInstance();
    }

    @Test
    public void getSingletonInstance() {
        Singleton anotherInstance = Singleton.getInstance();
        assertThat(anotherInstance, sameInstance(instance));
    }
}
