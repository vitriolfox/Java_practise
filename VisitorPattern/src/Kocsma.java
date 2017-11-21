public class Kocsma implements Hely{
    @Override
    public void accept(Ember ember) {
        ember.visit(this);
    }
}
