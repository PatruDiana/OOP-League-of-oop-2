package magician;

public class DieHerobyHero extends magician.Observer {
    /**
     * @return the String for output file with the appropiate message when a hero dies
     * by another hero.
     */
    public String update() {
        return "Player " + this.hero.getName() + " " + this.hero.getIndex() +  " was killed by ";

    }

    /**
     * @param angel- add the angel as observable.
     */
    public void addangel(final angels.Angel angel) {
    }

    /**
     * @param hero - add the hero as observable.
     */
    public void addhero(final heroes.Hero hero) {
        this.hero = hero;
        this.hero.addObservers(this);
    }
}
