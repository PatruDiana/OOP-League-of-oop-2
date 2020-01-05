package magician;

public class LevelUpIntermediarHero extends magician.Observer {
    /**
     * @return the String for output file with the appropiate message when a hero levels up.
     */
    public String update() {
        return this.hero.getName() +  " " + this.hero.getIndex() + " reached level";
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
