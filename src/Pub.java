
public class Pub {

    public static void main(String[] args) {
        System.out.println(computeCost(ONE_BEER, true, 2));
    }

    public static final String ONE_BEER = "hansa";
    public static final String ONE_CIDER = "grans";
    public static final String A_PROPER_CIDER = "strongbow";
    public static final String GT = "gt";
    public static final String BACARDI_SPECIAL = "bacardi_special";

    public static double computeCost(String drink, boolean student, double amount) {

        if (amount > 2 && (drink.equals(GT) || drink.equals(BACARDI_SPECIAL))) {
            throw new RuntimeException("Too many drinks, max 2.");
        }
        double price;
        switch (drink) {
            case ONE_BEER:
                price = 74;
                break;
            case ONE_CIDER:
                price = 103;
                break;
            case A_PROPER_CIDER:
                price = 110;
                break;
            case GT:
                //  price = ingredient6() + ingredient5() + ingredient4();
                price = priceOfGT();
                break;
            case BACARDI_SPECIAL:
                //  price = ingredient6() / 2 + ingredient1() + ingredient2() + ingredient3();
                price = priceOfBacardiSpecial();
                break;
            default:
                throw new RuntimeException("No such drink exists");
        }
        if (student && (drink.equals(ONE_CIDER) || drink.equals(ONE_BEER) || drink.equals(A_PROPER_CIDER))) {
            price = price - price / 10;
        }
        return price * amount;
    }

    private static double priceOfGT() {
        double oneUnitOfGreenStuff = 10;
        double oneUnitOfTonicWater = 20;
        double oneUnitOfGin = 85;
        return oneUnitOfGin + oneUnitOfTonicWater + oneUnitOfGreenStuff;
    }

    private static double priceOfBacardiSpecial() {
        double oneUnitOfRum = 65;
        double oneUnitOFGrenadine = 10;
        double oneUnitOfLimeJuice = 10;
        double oneUnitOfGin = 85;
        return oneUnitOfGin / 2 + oneUnitOfRum + oneUnitOFGrenadine + oneUnitOfLimeJuice;
    }
}

/*  one unit of rum
   private static int ingredient1() {
   return 65;
   }
    one unit of grenadine
    private static int ingredient2() {
       return 10;
    }
    one unit of lime juice
    private static int ingredient3() {
        return 10;
    }
    one unit of green stuff
    private static int ingredient4() {
        return 10;
    }
    one unit of tonic water
    private static int ingredient5() {
        return 20;
   }
   one unit of gin
   private static int ingredient6() {
        return 85;
    } */

