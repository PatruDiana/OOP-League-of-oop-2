package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Drain extends Abilities implements Visitor {
    private float DrainRogue = 0.8f;
    private float DrainKnight = 1.2f;
    private float DrainPyromancer = 0.9f;
    private float DrainWizard = 1.05f;
    public Drain() {
        damageprocent = Constants.PERCENT_DRAIN;
    }

    /**
     * update the base damage of Drain ability as the hero's level increases.
     */
    public void setDamage() {
        damageprocent += Constants.EXTRA_PERCENT_DRAIN;
    }

    @Override
    public void setCoefOffensive(float coef) {
        if (DrainRogue != 1) {
            DrainRogue += coef;
        }
        if (DrainKnight != 1) {
            DrainKnight += coef;
        }
        if (DrainPyromancer != 1) {
            DrainPyromancer += coef;
        }
        if (DrainWizard != 1) {
            DrainWizard += coef;
        }
    }

    @Override
    public void setCoefDefensive(float coef) {
        if (DrainRogue != 1) {
            DrainRogue -= coef;
        }
        if (DrainKnight != 1) {
            DrainKnight -= coef;
        }
        if (DrainPyromancer != 1) {
            DrainPyromancer -= coef;
        }
        if (DrainWizard != 1) {
            DrainWizard -= coef;
        }
    }

    /**
     * applying the Drain ability to the Pyromancer hero type.
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
        float damagelandrace = dmgpercent * DrainPyromancer;
        float dmg = damagelandrace * Math.min(Constants.HP_MIN_DRAIN * p.getHpMax(), p.getHpCurrent());
        int result = Math.round(dmg);
        System.out.println("Drain :"  + result);
        // decrease of the final damage from the opponent's hp
        p.setHpCurrent(result);
    }

    /**
     * applying the Drain ability to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        float dmgpercent = damageprocent;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.DESERT_TYPE) {
            landBonus += Constants.DESERT_BONUS;
        };
        dmgpercent = dmgpercent * landBonus;
        // applying the race modifier
        float damagelandrace = dmgpercent * DrainKnight;
        float dmg = damagelandrace* Math.min(Constants.HP_MIN_DRAIN * k.getHpMax(), k.getHpCurrent());
        int result = Math.round(dmg);
        System.out.println("Drain :"  + result);
        // decrease of the final damage from the opponent's hp
        k.setHpCurrent(result);
    }

    /**
     * applying the Drain ability to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        float dmgpercent = damageprocent;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.DESERT_TYPE) {
            landBonus += Constants.DESERT_BONUS;
        }
        dmgpercent = dmgpercent * landBonus;
        // applying the race modifier
        float damagelandrace = dmgpercent * DrainRogue;
        float dmg = damagelandrace * Math.min(Constants.HP_MIN_DRAIN * r.getHpMax(), r.getHpCurrent());
        int result = Math.round(dmg);
        System.out.println("Drain :"  + result);
        // decrease of the final damage from the opponent's hp
        r.setHpCurrent(result);
    }

    /**
     * applying the Drain ability to the Wizard hero type.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        float dmgpercent = damageprocent;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.DESERT_TYPE) {
            landBonus += Constants.DESERT_BONUS;
        }
        dmgpercent = dmgpercent * landBonus;
        float dmg = dmgpercent* Math.min(Constants.HP_MIN_DRAIN * w.getHpMax(), w.getHpCurrent());
        int dmgland = Math.round(dmg);
        // setting the damage received without the race modifier for the wizard hero
        w.setDamageRec(dmgland);
        // applying the race modifier
        float damagelandrace = DrainWizard * dmgpercent;
        dmg = damagelandrace * Math.min(Constants.HP_MIN_DRAIN * w.getHpMax(), w.getHpCurrent());
        int result = Math.round(dmg);
        System.out.println("Drain :"  + result);
        // decrease of the final damage from the opponent's hp
        w.setHpCurrent(result);
    }
}
