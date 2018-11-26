class MyFirstClass {
    public static void main (String[] args) {
        MySecondClass msc = new MySecondClass(5);
        msc.setA(1, 150);
        msc.print();
    }
}
    class MySecondClass {
        private int[] a;

        public int getA(int i) {
            return a[i];
        }
        public void setA(int e, int b) {
            a[e] = b;
        }
        public MySecondClass(int c) {
            this.a = new int[c];
            for(int i = 0; i < a.length; i++) {
                a[i] = (int)(Math.random() * 10);
            }
        }
        public void print() {
            for(int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
        }
    }