package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class LifeGiver extends Angel implements VisitAngel {
    public LifeGiver(int coodx, int coordy) {
        super(coodx, coordy);
    }

    @Override
    public void visit(Pyromancer p) {
        p.setHpCurrentStrategy(Math.min(p.getHpCurrent() + 80, p.getHpMax()));
    }

    @Override
    public void visit(Knight k) {
        k.setHpCurrentStrategy(Math.min(k.getHpCurrent() + 100, k.getHpMax()));
    }

    @Override
    public void visit(Rogue r) {
        r.setHpCurrentStrategy(Math.min(r.getHpCurrent() + 90, r.getHpMax()));
    }

    @Override
    public void visit(Wizard w) {
        w.setHpCurrentStrategy(Math.min(w.getHpCurrent() + 120, w.getHpMax()));
    }

    public String getName() {
        return "LifeGiver";
    }

    @Override
    public String actionangel(heroes.Hero hero) {
        return getName()+ " helped " + hero.getName() + " "+  hero.getIndex();
    }
}
