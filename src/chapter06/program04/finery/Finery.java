package chapter06.program04.finery;

import chapter06.program04.Person;

public class Finery extends Person {

    protected Person component;

    /**
     * 打扮
     */
    public void decorate(Person component){
        this.component = component;
    }

    @Override
    public void show() {
        if(component != null){
            component.show();
        }
    }
}
