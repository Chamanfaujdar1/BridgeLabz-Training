public class CloningExample {

    static class Product implements Cloneable {
        int id;
        String name;

        Product(int id, String name) {
            this.id = id;
            this.name = name;
        }

        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) throws Exception {

        Product original = new Product(101, "Laptop");
        Product copy = (Product) original.clone();

        System.out.println("Original: " + original.name);
        System.out.println("Clone: " + copy.name);
    }
}
