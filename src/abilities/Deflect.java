package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Deflect extends Abilities implements Visitor {
    private float DeflectRogue = 1.2f;
    private float DeflectKnight = 1.4f;
    private float DeflectPyromancer = 1.3f;
    Deflect() {
      damageprocent = Constants.PERCENT_DEFLECT;
    }

    /**
     * update the base damage of Deflect ability as the hero's level increases.
     */
    public void setDamage() {
        System.out.println("Intra aici ? " + damageprocent);
        if (damageprocent < Constants.MAXIM_PERCENT_DEFLECT - 0.1f) {
            damageprocent += Constants.EXTRA_PERCENT_DEFLECT;
        }
        System.out.println("Noul damage procent: " + damageprocent);
    }

    /**
     * set the damage received by the Wizard for Deflect ability.
     * @param damagereceived - damage received by the Wizard.
     */
    public void setDamagereceived(final int damagereceived) {
        damage = damagereceived;
    }

    @Override
    public void setCoefOffensive(float coef) {
        if (DeflectRogue != 1 ) {
            DeflectRogue += coef;
        }
        if (DeflectKnight != 1 ) {
            DeflectKnight += coef;
        }
        if (DeflectPyromancer != 1) {
            DeflectPyromancer += coef;
        }

    }

    @Override
    public void setCoefDefensive(float coef) {

        if (DeflectRogue != 1 ) {
            DeflectRogue -= coef;

        }
        if (DeflectKnight != 1 ) {
            DeflectKnight -= coef;

        }
        if (DeflectPyromancer != 1) {
            DeflectPyromancer -= coef;
        }
    }

    /**
     * applying the Deflect ability to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        float dmgpercent = damageprocent;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.DESERT_TYPE) {
            landBonus += Constants.DESERT_BONUS;
        }
        dmgpercent = dmgpercent * landBonus;
        // applying the race modifier
        float damagelandrace = dmgpercent * DeflectPyromancer;
        System.out.println("DeflectPyromancer: " + DeflectPyromancer);
        float dmg = damagelandrace * damage;
        int result = Math.round(dmg);
        System.out.println("Deflect :"  + result);
        // decrease of the final damage from the opponent's hp
        p.setHpCurrent(result);
    }

    /**
     * applying the Deflect ability to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        float dmgpercent = damageprocent;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.DESERT_TYPE) {
            landBonus += Constants.DESERT_BONUS;
        }
        dmgpercent = dmgpercent * landBonus;
        // applying the race modifier
        float damagelandrace = dmgpercent * DeflectKnight;
        float dmg = damagelandrace * damage;
        int result = Math.round(dmg);
        System.out.println("Deflect :"  + result);
        // decrease of the final damage from the opponent's hp
        k.setHpCurrent(result);
    }

    /**
     * applying the Deflect ability to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        float dmgpercent = damageprocent;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.DESERT_TYPE) {
            landBonus += Constants.DESERT_BONUS;
        }
        System.out.println("dmgpercent: " + dmgpercent);
        dmgpercent = dmgpercent * landBonus;
        System.out.println("dmgpercent: " + dmgpercent);
        System.out.println("LandBonus: " + landBonus);
        // applying the race modifier
        float damagelandrace = dmgpercent * DeflectRogue;
        System.out.println("Deflect Rogue: " + DeflectRogue);
        float dmg =  damagelandrace * damage;
        System.out.println("Damage primit " + damage);
        int result = Math.round(dmg);
        System.out.println("Deflect :"  + result);
        // decrease of the final damage from the opponent's hp
        r.setHpCurrent(result);
    }

    /**
     * The Deflect ability has no effect on a Wizard hero.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {}
}
