package magician;

public class ActionAngel extends magician.Observer {
    /**
     * @return the String for output file with the appropiate message when an angel
     * helps/hit a hero.
     */
    public String update() {
        return angel.actionangel(this.hero);
    }

    /**
     * @param angel - add the angel as observable.
     */
    public void addangel(final angels.Angel angel) {
        this.angel = angel;
        this.angel.addObservers(this);
    }

    /**
     * @param hero - add the hero as observable.
     */
    public void addhero(final heroes.Hero hero) { }
}
