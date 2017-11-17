import java.util.NoSuchElementException;

public class Lista implements Iterable<Integer> {
    int[] tomb;
    int length;

    public Lista() {
        length = 0;
        this.tomb = new int[100];
    }

    public Lista(int[] tomb) {
        length = tomb.length;
        this.tomb = tomb;
    }
    public void add(int value){
        tomb[length] = value;
        length++;
    }
    public int getSize(){
        return length;
    }

    public Iterator iterator(){
        return new Iterator(this, 0);
    }

    class Iterator implements java.util.Iterator<Integer> {
        Lista peldany;
        int sp;

        public Iterator(Lista peldany, int sp) {
            this.peldany = peldany;
            this.sp = sp;
        }

        public boolean hasNext() {
              return (sp < peldany.getSize());
            }

        public Integer next() throws java.util.NoSuchElementException{
        if (hasNext()) {
            return peldany.tomb[sp++];
            } else {
                throw new java.util.NoSuchElementException("Túlindexeltél srác");
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Lista denesLista = new Lista();

        denesLista.add(1);
        denesLista.add(2);
        denesLista.add(3);

        /*Iterator iterator = denesLista.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/

        for(Integer i: denesLista){
            System.out.println(i);
        }
        denesLista.iterator();

    }
}
