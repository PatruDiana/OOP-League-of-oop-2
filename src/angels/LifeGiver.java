package angels;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class LifeGiver extends Angel implements VisitAngel {
    public LifeGiver(final int coodx, final int coordy) {
        super(coodx, coordy);
    }

    /**
     * applying the LiveGiver angel to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        p.setHpCurrentStrategy(Math.min(p.getHpCurrent() + Constants.PYROMANCER_LIFEGIVER_HP,
                p.getHpMax()));
    }

    /**
     * applying the LiveGiver angel to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        k.setHpCurrentStrategy(Math.min(k.getHpCurrent() + Constants.KNIGHT_LIVERGIVER_HP,
                k.getHpMax()));
    }

    /**
     * applying the LiveGiver angel to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        r.setHpCurrentStrategy(Math.min(r.getHpCurrent() + Constants.ROGUE_LIVERGIVER_HP,
                r.getHpMax()));
    }

    /**
     * applying the LiveGiver angel to the Wizard hero type.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        w.setHpCurrentStrategy(Math.min(w.getHpCurrent() + Constants.WIZARD_LIVERGIVER_HP,
                w.getHpMax()));
    }

    /**
     *
     * @return the name of the angel.
     */
    public String getName() {
        return "LifeGiver";
    }

    /**
     * @param hero - the current hero the angel helps.
     * @return the String for output file with the appropiate message when an angel helps a hero.
     */
    public String actionangel(final heroes.Hero hero) {
        return getName() + " helped " + hero.getName() + " " +  hero.getIndex();
    }
}
