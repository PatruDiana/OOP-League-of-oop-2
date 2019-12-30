package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Fireblast extends Abilities implements Visitor {
    private float FireblastRogue = 0.8f;
    private float FireblastKnight = 1.2f;
    private float FireblastPyromancer = 0.9f;
    private float FireblastWizard = 1.05f;

    @Override
    public void setCoefOffensive(float coef) {
        FireblastKnight += coef;
        FireblastPyromancer +=coef;
        FireblastRogue += coef;
        FireblastWizard +=coef;
    }

    @Override
    public void setCoefDefensive(float coef) {
        FireblastKnight -= coef;
        FireblastPyromancer -=coef;
        FireblastRogue -= coef;
        FireblastWizard -=coef;
    }

    Fireblast() {
        damage = Constants.DAMAGE_FIREBLAST;
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
        if (map.Mapworld.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        int damagewithland = Math.round(dmg);
        // applying the race modifier
        float damagelandrace = FireblastPyromancer * damagewithland;
        int result = Math.round(damagelandrace);
        System.out.println("Fireblast:"  + result);
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
        if (map.Mapworld.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        int damagewithland = Math.round(dmg);
        // applying the race modifier
        float damagelandrace = FireblastKnight * damagewithland;
        int result = Math.round(damagelandrace);
        System.out.println("Fireblast:"  + result);
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
        if (map.Mapworld.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        int damagewithland = Math.round(dmg);
        // applying the race modifier
        float damagelandrace = FireblastRogue * damagewithland;
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
        if (map.Mapworld.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        int damagewithland = Math.round(dmg);
        // setting the damage received without the race modifier for the wizard hero
        w.setDamageRec(damagewithland);
        // applying the race modifier
        float damagelandrace = FireblastWizard * damagewithland;
        int result = Math.round(damagelandrace);
        // decrease of the final damage from the opponent's hp
        w.setHpCurrent(result);
    }
}
