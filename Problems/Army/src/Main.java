import javax.print.Doc;

class Army {

    public static void createArmy() {
        Unit unit0 = new Unit("r");
        Unit unit1 = new Unit("r");
        Unit unit2 = new Unit("r");
        Unit unit3 = new Unit("r");
        Unit unit4 = new Unit("r");

        Knight knight0 = new Knight("rakesh");
        Knight knight1 = new Knight("rakesh");
        Knight knight2 = new Knight("rakesh");

        General general = new General("rakesh");

        Doctor doctor = new Doctor("rakesh");


    }


    // Don't change the code below
    static class Unit {
        static String nameUnit;
        static int countUnit;

        public Unit(String name) {
            countUnit++;
            nameUnit = name;

        }
    }

    static class Knight {
        static String nameKnight;
        static int countKnight;

        public Knight(String name) {
            countKnight++;
            nameKnight = name;

        }
    }

    static class General {
        static String nameGeneral;
        static int countGeneral;

        public General(String name) {
            countGeneral++;
            nameGeneral = name;

        }
    }

    static class Doctor {
        static String nameDoctor;
        static int countDoctor;

        public Doctor(String name) {
            countDoctor++;
            nameDoctor = name;

        }
    }

    public static void main(String[] args) {
        createArmy();
        System.out.println(Unit.countUnit);
        System.out.println(Knight.countKnight);
        System.out.println(General.countGeneral);
        System.out.println(Doctor.countDoctor);
    }

}