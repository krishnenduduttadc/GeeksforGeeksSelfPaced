
package JavaPrac;

public class Danti {

    int x, y, z;

    Danti() {

    }

    Danti(int a, int b, int c) {
        x = a;
        y = b;
        z = c;
    }

    Danti(int a, int b) {
        x = a;
        y = b;
        z = a + b;
    }

    int cubeVol() {
        int volume = x * y * z;
        return volume;
    }
    
    int cubeSum() {
        int volume = x + y + z;
        return volume;
    }

    public static void main(String[] args) {
        
        Danti obj1 = new Danti();
        System.out.println(obj1.cubeVol());
        System.out.println(obj1.cubeSum());
        System.out.println("--------------------");

        
        Danti obj2 = new Danti(5, 4, 2);
        System.out.println(obj2.cubeVol());
        System.out.println(obj2.cubeSum());
        System.out.println("--------------------");

        
        Danti obj3 = new Danti(4, 2);
        System.out.println(obj3.cubeVol());
        System.out.println(obj3.cubeSum());
    }

}
