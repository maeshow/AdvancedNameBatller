package internal.domain.entity.Jobs;

import internal.domain.entity.Player;
import internal.domain.entity.Magics.Parise;
import internal.domain.entity.Magics.Poison;
import internal.domain.vo.JobType;

public class Assassin extends Player {
    public Assassin(String name) {
        super(name);
        initStaus(JobType.ASSASSIN);
        canUseMagic = true;
        magics.add(new Parise());
        magics.add(new Poison());
    }

}
