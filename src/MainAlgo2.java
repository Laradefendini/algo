public class MainAlgo2 {

    public static void main(String[] args) {

        System.out.println("-------------------   p = 0.1   -------------------");
        for(int i=0; i<10; i++){
            System.out.println("p = 0 q = 0." + i + " --> " + new Moyenne(100, 0.1, (float)i/10, true).getAverage());
        }

        System.out.println("-------------------   p = 0.2   -------------------");
        for(int i=0; i<10; i++){
            System.out.println("p = 0 q = 0." + i + " --> " + new Moyenne(100, 0.2, (float)i/10, true).getAverage());
        }

        System.out.println("-------------------   p = 0.3   -------------------");
        for(int i=0; i<10; i++){
            System.out.println("p = 0 q = 0." + i + " --> " + new Moyenne(100, 0.3, (float)i/10, true).getAverage());
        }

        System.out.println("-------------------   p = 0.4   -------------------");
        for(int i=0; i<10; i++){
            System.out.println("p = 0 q = 0." + i + " --> " + new Moyenne(100, 0.4, (float)i/10, true).getAverage());
        }

        System.out.println("-------------------   p = 0.5   -------------------");
        for(int i=0; i<10; i++){
            System.out.println("p = 0 q = 0." + i + " --> " + new Moyenne(100, 0.5, (float)i/10, true).getAverage());
        }

        System.out.println("-------------------   p = 0.6   -------------------");
        for(int i=0; i<10; i++){
            System.out.println("p = 0 q = 0." + i + " --> " + new Moyenne(100, 0.6, (float)i/10, true).getAverage());
        }

        System.out.println("-------------------   p = 0.7   -------------------");
        for(int i=0; i<10; i++){
            System.out.println("p = 0 q = 0." + i + " --> " + new Moyenne(100, 0.7, (float)i/10, true).getAverage());
        }

        System.out.println("-------------------   p = 0.8   -------------------");
        for(int i=0; i<10; i++){
            System.out.println("p = 0 q = 0." + i + " --> " + new Moyenne(100, 0.8, (float)i/10, true).getAverage());
        }

        System.out.println("-------------------   p = 0.9   -------------------");
        for(int i=0; i<10; i++){
            System.out.println("p = 0 q = 0." + i + " --> " + new Moyenne(100, 0.9, (float)i/10, true).getAverage());
        }

        System.out.println("-------------------   p = 1   -------------------");
        for(int i=0; i<10; i++){
            System.out.println("p = 0 q = 0." + i + " --> " + new Moyenne(100, 1, (float)i/10, true).getAverage());
        }

    }
}
