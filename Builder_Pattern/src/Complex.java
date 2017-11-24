public class Complex implements Cloneable {
    private int atr1;
    private int atr2;
    private int atr3;
    private int atr4;
    private int atr5;
    private int atr6;
    private int atr7;
    private int atr8;

    @Override
    public Complex clone() throws CloneNotSupportedException {
        return (Complex) super.clone();
    }

    public int getAtr1() {
        return atr1;
    }

    public int getAtr2() {
        return atr2;
    }

    public int getAtr3() {
        return atr3;
    }

    public int getAtr4() {
        return atr4;
    }

    public int getAtr5() {
        return atr5;
    }

    public int getAtr6() {
        return atr6;
    }

    public int getAtr7() {
        return atr7;
    }

    public int getAtr8() {
        return atr8;
    }

    private Complex(int atr1, int atr2, int atr3, int atr4, int atr5, int atr6, int atr7, int atr8) {
        this.atr1 = atr1;
        this.atr2 = atr2;
        this.atr3 = atr3;
        this.atr4 = atr4;
        this.atr5 = atr5;
        this.atr6 = atr6;
        this.atr7 = atr7;
        this.atr8 = atr8;
    }


    public static class Builder{
        private int btr1;
        private int btr2;
        private int btr3;
        private int btr4;
        private int btr5;
        private int btr6;
        private int btr7;
        private int btr8;


        public Builder(int btr1, int btr2) {
            this.btr1 = btr1;
            this.btr2 = btr2;
        }

        public Builder setBtr1(int btr1) {
            this.btr1 = btr1;
            return this;
        }

        public Builder setBtr2(int btr2) {
            this.btr2 = btr2;
            return this;
        }

        public Builder setBtr3(int btr3) {
           this.btr3 = btr3;
           return this;
        }

        public Builder setBtr4(int btr4) {
            this.btr4 = btr4;
            return this;
        }

        public Builder setBtr5(int btr5) {
            this.btr5 = btr5;
            return this;
        }

        public Builder setBtr6(int btr6) {
            this.btr6 = btr6;
            return this;
        }

        public Builder setBtr7(int btr7) {
            this.btr7 = btr7;
            return this;
        }

        public Builder setBtr8(int btr8) {
            this.btr8 = btr8;
            return this;
        }

        public Complex build(){
            return new Complex(btr1, btr2, btr3, btr4, btr5, btr6, btr7, btr8);
        }
    }
}
