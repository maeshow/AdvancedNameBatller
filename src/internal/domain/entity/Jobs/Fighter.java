package internal.domain.entity.Jobs;

import internal.domain.entity.Player;
import internal.domain.vo.JobType;

public class Fighter extends Player {
    public Fighter(String name) {
        super(name);
        initStaus(JobType.FIGHTER);
        canUseMagic = false;
    }
}
