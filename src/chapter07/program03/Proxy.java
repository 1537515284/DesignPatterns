package chapter07.program03;

/**
 * Proxy类，保存一个引用使得代理可以访问实体，并提供一个与 Subject的接口相同的接口，这样代理就可以用来代替实体
 */
public class Proxy implements Subject{

    private RealSubject realSubject;

    @Override
    public void request() {
        if(realSubject == null)
            realSubject = new RealSubject();
        System.out.println("前面干点其他的---");
        realSubject.request();
        System.out.println("结束了在干点啥...");
    }
}
