package magician;

public class AliveByAngel extends magician.Observer {
    /**
     * @return the String for output file with the appropiate message when a hero
     * is alive by an angel.
     */
    public String update() {
        return "Player " + this.hero.getName() + " "
                + this.hero.getIndex() + " was brought to life by an angel";
    }

    /**
     * @param angel - add the angel as observable.
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
