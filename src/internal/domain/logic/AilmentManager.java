package internal.domain.logic;

import java.util.List;
import java.util.Random;

import internal.domain.implement.IPlayer;
import internal.domain.vo.AilmentType;
import internal.presentation.Messages;

public class AilmentManager {
    private static final Random RANDOM = new Random();

    private static final int BOUND = 100;
    private static final int POISON_DAMAGE = 20;
    private static final int START_PRISE_PROBABILITY_RANGE = 0;
    private static final int END_PRISE_PROBABILITY_RANGE = 20;

    public void poison(List<IPlayer> players) {
        for (IPlayer player : players) {
            if (player.getAilment().equals(AilmentType.POISON)) {
                player.removeHitPoint(POISON_DAMAGE);
                Messages.showFormattedMessage(Messages.POISON, player.getName(), POISON_DAMAGE);
            }
        }
    }

    public boolean isParalysis(IPlayer player) {
        if (player.getAilment().equals(AilmentType.PARISE)) {
            int random = RANDOM.nextInt(BOUND);
            if (START_PRISE_PROBABILITY_RANGE < random && random < END_PRISE_PROBABILITY_RANGE) {
                Messages.showFormattedMessage(Messages.PARISE, player.getName());
                return true;
            }
        }
        return false;
    }
}
