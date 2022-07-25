package chapter07.program03;

/**
 * 代理模式：为其他对象提供一种代理以控制对这个对象的访问。
 * 代理模式就是在访问对象时引入一定程度的间接性，因为这种间接性，可以附加多种用途。
 */
public class Client {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}
