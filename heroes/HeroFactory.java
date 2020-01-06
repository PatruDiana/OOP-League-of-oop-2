package heroes;

public final class HeroFactory {
    private HeroFactory() {
        //for checkstyle
    }
    public static Hero getHero(final String type, final int row, final int col, final int index) {
        // check the hero type to create them with the initial position
        if ("P".equalsIgnoreCase(type)) {
            return new Pyromancer(row, col, index);
        } else if ("K".equalsIgnoreCase(type)) {
            return new Knight(row, col, index);
        } else if ("W".equalsIgnoreCase(type)) {
            return new Wizard(row, col, index);
        } else {
            return new Rogue(row, col, index);
        }
    }
}
