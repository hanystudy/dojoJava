package name.hanyi.singleton;

public class Singleton {

    private Singleton() {}

    private static class LazySingletonHolder {
        public static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return LazySingletonHolder.instance;
    }
}
