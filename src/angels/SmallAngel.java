package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class SmallAngel extends Angel implements VisitAngel {
    public SmallAngel(int coodx, int coordy) {
        super(coodx, coordy);
    }

    @Override
    public void visit(Pyromancer p) {
        for (int i = 0; i < p.getAbilities().size(); i++) {
            p.getAbilities().get(i).setCoefOffensive(0.15f);
        }
        p.setHpCurrentStrategy(Math.min(p.getHpCurrent() + 15, p.getHpMax()));
    }

    @Override
    public void visit(Knight k) {
        for (int i = 0; i < k.getAbilities().size(); i++) {
            k.getAbilities().get(i).setCoefOffensive(0.1f);
        }
        if (k.getHpCurrent() + 10 <= k.getHpMax()) {
            k.setHpCurrentStrategy(k.getHpCurrent() + 10);
        }
    }

    @Override
    public void visit(Rogue r) {
        for (int i = 0 ; i < r.getAbilities().size(); i++) {
            r.getAbilities().get(i).setCoefOffensive(0.05f);
        }
        r.setHpCurrentStrategy(Math.min(r.getHpCurrent() + 20, r.getHpMax()));
    }

    @Override
    public void visit(Wizard w) {
        for (int i = 0; i < w.getAbilities().size(); i++) {
            w.getAbilities().get(i).setCoefOffensive(0.1f);
        }
        w.setHpCurrentStrategy(Math.min(w.getHpCurrent() + 25, w.getHpMax()));
    }

    public String getName() {
        return "SmallAngel";
    }

    @Override
    public String actionangel(heroes.Hero hero) {
        return getName() + " helped " + hero.getName() + " "+ hero.getIndex() ;
    }
}
