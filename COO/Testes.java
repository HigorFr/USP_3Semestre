public class Testes {




    static class Pai {
        void fala() {
            System.out.println("Sou o pai");
        }
    }

    static class Filho extends Pai {
        @Override
        void fala() {
            System.out.println("Sou o filho");
        }
        void fala2() {
            System.out.println("Sou o filho2");
        }
    }


    public static void main(String[] args) {
        Filho f = new Filho();

        Pai p = (Pai) f; 

        p.fala(); 
        p.fala2();
    }
    






}

