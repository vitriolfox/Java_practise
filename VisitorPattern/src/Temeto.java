public class Temeto implements Hely{
    @Override
    public void accept(Ember ember) {
        ember.visit(this);
    }
}
