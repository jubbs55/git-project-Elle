public class Tester {
    public static void main(String[] args) {
        Git.initiate();
        HashAndAdd.addToIndex("hello.txt");
        HashAndAdd.addToIndex("jabba.txt");
        HashAndAdd.addToIndex("copy.txt");
    }
}
