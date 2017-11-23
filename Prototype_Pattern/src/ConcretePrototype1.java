public class ConcretePrototype1 implements Cloneable,Prototype{

    @Override
    public Prototype clone(Prototype prototype) {
        return new Prototype(Prototype this);
        }
    }
}
