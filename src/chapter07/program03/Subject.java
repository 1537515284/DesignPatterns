package chapter07.program03;

/**
 * Subject类，定义了 RealSubject和 Proxy的共用接口，这样就在任何使用 RealSubject的地方都可以使用 Proxy。
 */
public interface Subject {
    void request();
}
