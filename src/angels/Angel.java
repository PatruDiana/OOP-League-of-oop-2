package angels;

import java.util.List;

public abstract  class Angel implements VisitAngel {
    protected int coodx;
    protected int coordy;
    protected List<magician.Observer> observer = new java.util.ArrayList<>();

    public Angel(final int coodx, final int coordy) {
        this.coodx = coodx;
        this.coordy = coordy;
    }

    /**
     * @return the coordinate of the row in which it is at current round.
     */
    public int getCoodx() {
        return coodx;
    }

    /**
     * @return the coordinate of the column in which it is at current round.
     */
    public int getCoordy() {
        return coordy;
    }

    public abstract String getName();

    /**
     * add one observer at the list with observers.
     * @param oneobserver - one of the observers.
     */
    public void addObservers(final magician.Observer oneobserver) {
        this.observer.add(oneobserver);
    }

    /**
     * @return the String for output file with the appropiate message when an angel appear on map.
     */
    public String appear() {
        String appear = observer.get(0).update();
        return appear;
    }
    public abstract String actionangel(heroes.Hero hero);
}
