package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Fireblast extends Abilities implements Visitor {
    private float fireblastRogue;
    private float fireblastKnight;
    private float fireblastPyromancer;
    private float fireblastWizard;
    public Fireblast() {
        damage = Constants.DAMAGE_FIREBLAST;
        fireblastRogue = Constants.ROGUE_MODIFICATOR_F;
        fireblastKnight = Constants.KNIGHT_MODIFICATOR_F;
        fireblastPyromancer = Constants.PYROMANCER_MODIFICATOR_F;
        fireblastWizard = Constants.WIZARD_MODIFICATOR_F;
    }

    /**
     * set the race modifiers if the player chooses the offensive strategy.
     * @param percent - a percentage that will increase race coefficients.
     */
    public void setCoefOffensive(final float percent) {
        // the race modifiers change if initially they are different from 1
        if (fireblastKnight != 1) {
            fireblastKnight += percent;
        }
        if (fireblastPyromancer != 1) {
            fireblastPyromancer += percent;
        }
        if (fireblastRogue != 1) {
            fireblastRogue += percent;
        }
        if (fireblastWizard != 1) {
            fireblastWizard += percent;
        }
    }

    /**
     *  set the race modifiers if the player chooses the defensive strategy.
     * @param percent - a percentage that will reduce race coefficients.
     */
    public void setCoefDefensive(final float percent) {
        // the race modifiers change if initially they are different from 1
        if (fireblastKnight != 1) {
            fireblastKnight -= percent;
        }
        if (fireblastPyromancer != 1) {
            fireblastPyromancer -= percent;
        }
        if (fireblastRogue != 1) {
            fireblastRogue -= percent;
        }
        if (fireblastWizard != 1) {
            fireblastWizard -= percent;
        }
    }

    /**
     * update the base damage of Fireblast ability as the hero's level increases.
     */
    public void setDamage() {
        damage += Constants.EXTRA_DAMAGE_FIREBLAST;
    }

    /**
     * applying the Fireblast ability to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(p.getRow(), p.getCol())
                == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        int damagewithland = Math.round(dmg);
        // applying the race modifier
        float damagelandrace = fireblastPyromancer * damagewithland;
        int result = Math.round(damagelandrace);
        // decrease of the final damage from the opponent's hp
        p.setHpCurrent(result);
    }

    /**
     * applying the Fireblast ability to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(k.getRow(), k.getCol())
                == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        int damagewithland = Math.round(dmg);
        // applying the race modifier
        float damagelandrace = fireblastKnight * damagewithland;
        int result = Math.round(damagelandrace);
        // decrease of the final damage from the opponent's hp
        k.setHpCurrent(result);
    }

    /**
     * applying the Fireblast ability to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(r.getRow(), r.getCol())
                == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        int damagewithland = Math.round(dmg);
        // applying the race modifier
        float damagelandrace = fireblastRogue * damagewithland;
        int result = Math.round(damagelandrace);
        // decrease of the final damage from the opponent's hp
        r.setHpCurrent(result);
    }

    /**
     * applying the Fireblast ability to the Wizard hero type.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(w.getRow(), w.getCol())
                == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        int damagewithland = Math.round(dmg);
        // setting the damage received without the race modifier for the wizard hero
        w.setDamageRec(damagewithland);
        // applying the race modifier
        float damagelandrace = fireblastWizard * damagewithland;
        int result = Math.round(damagelandrace);
        // decrease of the final damage from the opponent's hp
        w.setHpCurrent(result);
    }
}
