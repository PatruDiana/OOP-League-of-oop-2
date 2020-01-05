package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Slam extends Abilities implements Visitor {
    private float slamRogue;
    private float slamKnight;
    private float slamPyromancer;
    private float slamWizard;
    public Slam() {
        damage = Constants.DAMAGE_SLAM;
        nrRoundsOvertime = Constants.NR_ROUNDS_OVERTIME_S;
        slamRogue = Constants.ROGUE_MODIFICATOR_S;
        slamKnight = Constants.KNIGHT_MODIFICATOR_S;
        slamPyromancer = Constants.PYROMANCER_MODIFICATOR_S;
        slamWizard = Constants.WIZARD_MODIFICATOR_S;
    }

    /**
     * update the base damage of Slam ability as the hero's level increases.
     */
    public void setDamage() {
        damage += Constants.EXTRA_DAMAGE_SLAM;
    }

    /**
     * set the race modifiers if the player chooses the offensive strategy.
     * @param percent - a percentage that will increase race coefficients.
     */
    public void setCoefOffensive(final float percent) {
        // the race modifiers change if initially they are different from 1
        if (slamKnight != 1) {
            slamKnight += percent;
        }
        if (slamPyromancer != 1) {
            slamPyromancer += percent;
        }
        if (slamRogue != 1) {
            slamRogue += percent;
        }
        if (slamWizard != 1) {
            slamWizard += percent;
        }
    }

    /**
     * set the race modifiers if the player chooses the defensive strategy.
     * @param percent - a percentage that will reduce race coefficients.
     */
    public void setCoefDefensive(final float percent) {
        // the race modifiers change if initially they are different from 1
        if (slamKnight != 1) {
            slamKnight -= percent;
        }
        if (slamPyromancer != 1) {
            slamPyromancer -= percent;
        }
        if (slamRogue != 1) {
            slamRogue -= percent;
        }
        if (slamWizard != 1) {
            slamWizard -= percent;
        }
    }

    /**
     * applying the Slam ability to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.LAND_TYPE) {
            landBonus += Constants.LAND_BONUS;
        }
        dmg = dmg * landBonus;
        int damageland = Math.round(dmg);
        // applying the race modifier
        float damagelandrace = damageland * slamPyromancer;
        int result = Math.round(damagelandrace);
        // decrease of the final damage from the opponent's hp
        p.setHpCurrent(result);
        // set the damage overtime
        p.setDamageOvertime(0, nrRoundsOvertime, true);
    }

    /**
     * applying the Slam ability to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.LAND_TYPE) {
            landBonus += Constants.LAND_BONUS;
        }
        dmg = dmg * landBonus;
        int damageland = Math.round(dmg);
        // applying the race modifier
        float damagelandrace  = slamKnight * damageland;
        int result = Math.round(damagelandrace);
        // decrease of the final damage from the opponent's hp
        k.setHpCurrent(result);
        // set the damage overtime
        k.setDamageOvertime(0, nrRoundsOvertime, true);

    }

    /**
     * applying the Slam ability to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.LAND_TYPE) {
            landBonus += Constants.LAND_BONUS;
        }
        dmg = dmg * landBonus;
        int damageland = Math.round(dmg);
        // applying the race modifier
        float damagelandrace = slamRogue * damageland;
        int result = Math.round(damagelandrace);
        // decrease of the final damage from the opponent's hp
        r.setHpCurrent(result);
        // set the damage overtime
        r.setDamageOvertime(0, nrRoundsOvertime, true);

    }

    /**
     *  applying the Slam ability to the Wizard hero type.
     *  @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.LAND_TYPE) {
            landBonus += Constants.LAND_BONUS;
        }
        dmg = dmg * landBonus;
        int damageland = Math.round(dmg);
        // setting the damage received without the race modifier for the wizard hero
        w.setDamageRec(damageland);
        // applying the race modifier
        float damagelandrace = slamWizard * damageland;
        int result = Math.round(damagelandrace);
        // decrease of the final damage from the opponent's hp
        w.setHpCurrent(result);
        // set the damage overtime
        w.setDamageOvertime(0, nrRoundsOvertime, true);
    }
}
