package angels;

import java.util.List;

public abstract  class Angel implements VisitAngel{
    protected int coodx;
    protected int coordy;
    protected List<magician.Observer> observer = new java.util.ArrayList<>();

    public Angel(int coodx, int coordy) {
        this.coodx = coodx;
        this.coordy = coordy;
    }

    public int getCoodx() {
        return coodx;
    }
    public int getCoordy() {
        return coordy;
    }
    public abstract String getName();
    public void addObservers(magician.Observer observer) {
        this.observer.add(observer);
    }
    public String appear() {
        String appear = observer.get(0).update();
        return appear;
    }
    public abstract String actionangel(heroes.Hero hero);
}
