public class MultipleInheritance {
    interface Phone{
        void call();
    }

    interface Camera{
        void capturePhoto();
    }

    static class Laptop implements Phone, Camera{
        public void call(){
            System.out.println("Calling from laptop");
        }

        public void capturePhoto(){
            System.out.println("Capturing photo from laptop");        
        }
    }

    public static void main(String[] args){
        Laptop laptop = new Laptop();
        laptop.call();
        laptop.capturePhoto();
    }
}
