package magician;

import angels.Angel;
import heroes.Hero;

public abstract class Observer {
    protected Angel angel;
    protected Hero hero;
    public abstract String update();
    public abstract void addangel(Angel oneangel);
    public abstract void addhero(Hero onehero);
}
