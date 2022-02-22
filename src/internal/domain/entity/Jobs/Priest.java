package internal.domain.entity.Jobs;

import internal.domain.entity.Player;
import internal.domain.entity.Magics.Heal;
import internal.domain.entity.Magics.Parise;
import internal.domain.entity.Magics.Poison;
import internal.domain.vo.JobType;

public class Priest extends Player {
    public Priest(String name) {
        super(name);
        initStaus(JobType.PRIEST);
        canUseMagic = true;
        magics.add(new Heal());
        magics.add(new Parise());
        magics.add(new Poison());
    }
}
