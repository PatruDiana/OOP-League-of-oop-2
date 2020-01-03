package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Backstab extends Abilities implements Visitor {
    private int nrRounds;
    private float woodsModificator;
    private float BackstabRogue = 1.2f;
    private float BackstabKnight = 0.9f;
    private float BackstabPyromancer = 1.25f;
    private float BackstabWizard = 1.25f;
    Backstab() {
        damage = Constants.DAMAGE_BACKSTAB;
        nrRounds = 0;
        woodsModificator = 1;
    }

    /**
     * update the base damage of Backstab ability as the hero's level increases.
     */
    public void setDamage() {
        damage += Constants.EXTRA_DAMAGE_BACKSTAB;
    }

    @Override
    public void setCoefOffensive(float coef) {
       if (BackstabKnight != 1) {
           BackstabKnight += coef;
       }
       if (BackstabPyromancer != 1) {
           BackstabPyromancer += coef;
       }
       if (BackstabRogue != 1) {
           BackstabRogue += coef;
       }
       if (BackstabWizard != 1) {
           BackstabWizard += coef;
       }

    }

    @Override
    public void setCoefDefensive(float coef) {
        if (BackstabKnight != 1) {
            BackstabKnight -= coef;
        }
        if (BackstabPyromancer != 1) {
            BackstabPyromancer -= coef;
        }
        if (BackstabRogue != 1) {
            BackstabRogue -= coef;
        }
        if (BackstabWizard != 1) {
            BackstabWizard -= coef;
        }
    }

    /**
     * applying the Backstab ability to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        float woods = woodsModificator;
        float dmg = damage;
        float landBonus = landModificator;
        // the possibility of a critical hit
        if ((nrRounds % Constants.NR_ROUNDS_BACKSTAB) == 0) {
            if (map.Mapworld.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.WOODS_TYPE) {
                woods += Constants.HIT_WOODS;
            }
        }
        nrRounds++;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.WOODS_TYPE) {
            landBonus += Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        int damageland = Math.round(dmg);
        // applying the race modifier
        float damagelandrace = damageland * BackstabPyromancer;
        int dmglandrace = Math.round(damagelandrace);
        float damagerace = woods * dmglandrace;
        int result = Math.round(damagerace);
        System.out.println("Backstab: " + result);
        // decrease of the final damage from the opponent's hp
        p.setHpCurrent(result);
    }

    /**
     * applying the Backstab ability to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        float woods = woodsModificator;
        float dmg = damage;
        float landBonus = landModificator;
        // the possibility of a critical hit
        if ((nrRounds % Constants.NR_ROUNDS_BACKSTAB) == 0) {
            if (map.Mapworld.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.WOODS_TYPE) {
                woods += Constants.HIT_WOODS;
            }
        }
        nrRounds++;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.WOODS_TYPE) {
            landBonus += Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        int damageland = Math.round(dmg);
        // applying the race modifier
        float damagelandrace = damageland * BackstabKnight;
        int dmglandrace = Math.round(damagelandrace);
        float damagerace = woods * dmglandrace;
        int result = Math.round(damagerace);
        System.out.println("Backstab: " + result);
        // decrease of the final damage from the opponent's hp
        k.setHpCurrent(result);

    }

    /**
     * applying the Backstab ability to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        float woods = woodsModificator;
        float dmg = damage;
        float landBonus = landModificator;
        // the possibility of a critical hit
        if ((nrRounds % Constants.NR_ROUNDS_BACKSTAB) == 0) {
            if (map.Mapworld.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.WOODS_TYPE) {
                woods += Constants.HIT_WOODS;
            }
        }
        nrRounds++;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.WOODS_TYPE) {
            landBonus += Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        int damageland = Math.round(dmg);
        // applying the race modifier
        float damagelandrace = damageland * BackstabRogue;
        int dmglandrace = Math.round(damagelandrace);
        float damagerace = woods * dmglandrace;
        int result = Math.round(damagerace);
        System.out.println("Backstab: " + result);
        // decrease of the final damage from the opponent's hp
        r.setHpCurrent(result);

    }

    /**
     * applying the Backstab ability to the Wizard hero type.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        float woods = woodsModificator;
        float dmg = damage;
        float landBonus = landModificator;
        // the possibility of a critical hit
        if ((nrRounds % Constants.NR_ROUNDS_BACKSTAB) == 0) {
            if (map.Mapworld.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.WOODS_TYPE) {
                woods += Constants.HIT_WOODS;
            }
        }
        nrRounds++;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.WOODS_TYPE) {
            landBonus += Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        int damageland = Math.round(dmg);
        float damagewood = woods * damageland;
        int dmgwood = Math.round(damagewood);
        // setting the damage received without the race modifier for the wizard hero
        w.setDamageRec(dmgwood);
        // applying the race modifier
        float damagelandrace = dmgwood * BackstabWizard;
        int result = Math.round(damagelandrace);
        System.out.println("Backstab: " + result);
        // decrease of the final damage from the opponent's hp
        w.setHpCurrent(result);

    }
}
