package angels;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class GoodBoy extends Angel implements VisitAngel {
    public GoodBoy(final int coodx, final int coordy) {
        super(coodx, coordy);
    }

    /**
     * applying the GoodBoy angel to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        for (int i = 0; i < p.getAbilities().size(); i++) {
            p.getAbilities().get(i).setCoefOffensive(Constants.PYROMANCER_GOODBOY_OFF);
        }
        p.setHpCurrentStrategy(Math.min(p.getHpCurrent() + Constants.PYROMANCER_GOODBOY_HP,
                p.getHpMax()));
    }

    /**
     * applying the GoodBoy angel to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        for (int i = 0; i < k.getAbilities().size(); i++) {
            k.getAbilities().get(i).setCoefOffensive(Constants.KNIGHT_GOODBOY_OFF);
        }
        k.setHpCurrentStrategy(Math.min(k.getHpCurrent() + Constants.KNIGHT_GOODBOY_HP,
                k.getHpMax()));
    }

    /**
     * applying the GoodBoy angel to the Rogue hero type.
     * @param r- a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        for (int i = 0; i < r.getAbilities().size(); i++) {
            r.getAbilities().get(i).setCoefOffensive(Constants.ROGUE_GOODBOY_OFF);
        }
        r.setHpCurrentStrategy(Math.min(r.getHpCurrent() + Constants.ROGUE_GOODBOY_HP,
                r.getHpMax()));
    }

    /**
     * applying the GoodBoy angel to the Wizard hero type.
     * @param w- a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        for (int i = 0; i < w.getAbilities().size(); i++) {
            w.getAbilities().get(i).setCoefOffensive(Constants.WIZARD_GOODBOY_OFF);
        }
        w.setHpCurrentStrategy(Math.min(w.getHpCurrent() + Constants.WIZARD_GOODBOY_HP,
                w.getHpMax()));
    }

    /**
     * @return the name of the angel.
     */
    public String getName() {
        return "GoodBoy";
    }

    /**
     *@param hero - the current hero the angel helps.
     * @return the String for output file with the appropiate message when an angel helps a hero.
     */
    public String actionangel(final heroes.Hero hero) {
        return getName() + " helped " + hero.getName() + " " + hero.getIndex();
    }
}
