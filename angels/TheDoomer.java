package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class TheDoomer extends Angel implements VisitAngel {
    public TheDoomer(final int coodx, final int coordy) {
        super(coodx, coordy);
    }

    /**
     * applying the TheDoomer angel to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        p.setDeath();
    }

    /**
     * applying the TheDoomer angel to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        k.setDeath();
    }

    /**
     * applying the TheDoomer angel to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        r.setDeath();
    }

    /**
     * applying the TheDoomer angel to the Wizard hero type.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        w.setDeath();
    }

    /**
     * @return the name of the angel.
     */
    public String getName() {
        return "TheDoomer";
    }

    /**
     *  @param hero - the current hero the angel hits.
     *  @return the String for output file with the appropiate message when an angel hits a hero.
     */
    public String actionangel(final heroes.Hero hero) {
        return getName() + " hit " + hero.getName() + " " + hero.getIndex();
    }
}
