package magician;

public class AppearAngel extends magician.Observer {
    /**
     * @return the String for output file with the appropiate message when an angel
     * appears on the map.
     */
    public String update() {
        return "Angel " + angel.getName() + " was spawned at "
                + angel.getCoodx() + " " + angel.getCoordy();
    }

    /**
     * @param angel- add the angel as observable.
     */
    public void addangel(final angels.Angel angel) {
        this.angel = angel;
        this.angel.addObservers(this);
    }

    /**
     * @param hero - add the hero as observable.
     */
    public void addhero(final heroes.Hero hero) {

    }
}
