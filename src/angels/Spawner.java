package angels;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Spawner extends Angel implements VisitAngel {
    public Spawner(final int coodx, final int coordy) {
        super(coodx, coordy);
    }

    /**
     * applying the Spawner angel to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        p.setAlive();
        p.setHpCurrentStrategy(Constants.PYROMANCER_SPAWNER_HP);
    }

    /**
     * applying the Spawner angel to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        k.setAlive();
        k.setHpCurrentStrategy(Constants.KNIGHT_SPAWNER_HP);
    }

    /**
     * applying the Spawner angel to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        r.setAlive();
        r.setHpCurrentStrategy(Constants.ROGUE_SPAWNER_HP);
    }

    /**
     * applying the Spawner angel to the Wizard hero type.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        w.setAlive();
        w.setHpCurrentStrategy(Constants.WIZARD_SPAWNER_HP);
    }

    /**
     * @return the name of the angel.
     */
    public String getName() {
        return "Spawner";
    }

    /**
     *  @param hero - the current hero the angel helps.
     *  @return the String for output file with the appropiate message when an angel helps a hero.
     */
    public String actionangel(final heroes.Hero hero) {
        return getName() + " helped " + hero.getName() + " " +  hero.getIndex();
    }
}
