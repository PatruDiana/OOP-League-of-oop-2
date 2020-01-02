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
        p.setHpCurrentStrategy(p.getHpCurrent() + 80);
    }

    @Override
    public void visit(Knight k) {
        k.setHpCurrentStrategy(k.getHpCurrent() + 100);
    }

    @Override
    public void visit(Rogue r) {
        r.setHpCurrentStrategy(r.getHpCurrent() + 90);
    }

    @Override
    public void visit(Wizard w) {
        w.setHpCurrentStrategy(w.getHpCurrent() + 120);
    }

    @Override
    public String toString() {
        return "LifeGiver: " + coodx + ", " + coordy;
    }
    public String getName() {
        return "LifeGiver";
    }
}
