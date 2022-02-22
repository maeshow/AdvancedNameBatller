package internal.presentation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import internal.domain.entity.Jobs.Assassin;
import internal.domain.entity.Jobs.Fighter;
import internal.domain.entity.Jobs.Priest;
import internal.domain.entity.Jobs.Wizard;
import internal.domain.implement.IPlayer;
import internal.domain.logic.AilmentManager;
import internal.domain.vo.JobType;

public class NameBatller {
    private static final int PLAYER_NUMBER = 2;

    private final List<IPlayer> players;
    private final PlayerInput playerInput;
    private final AilmentManager ailmentManager;

    public NameBatller() {
        this.players = new ArrayList<>();
        this.playerInput = new PlayerInput();
        this.ailmentManager = new AilmentManager();
    }

    public void onGame() {
        registerPlayers();
        startTurn();
    }

    private void registerPlayers() {
        for (int i = 0; i < PLAYER_NUMBER; i++) {
            Messages.showFormattedMessage(Messages.GENERATE_PLAYER, i + 1);
            IPlayer player = generatePlayer();
            if (player == null) {
                Messages.showWithNewLine(Messages.GENERATE_PLAYER_ERROR);
            }
            players.add(player);
        }
    }

    private void startTurn() {
        for (IPlayer player : players) {
            player.showStatus();
        }
        Messages.showNewLine();
        Messages.showWithNewLine(Messages.BATTLE_START);
        Messages.showNewLine();
        players.sort(Comparator.comparing(IPlayer::getAgility).reversed());
        IPlayer attacker = null;
        IPlayer defender = null;
        while (!isEndGame()) {
            for (int i = 0; i < PLAYER_NUMBER; i++) {
                attacker = players.get(i);
                defender = getDefender(i);
                if (ailmentManager.isParalysis(attacker)) {
                    continue;
                }
                attacker.attack(defender);
                if (!defender.isLive()) {
                    break;
                }
            }
            if (defender.isLive()) {
                ailmentManager.poison(players);
                showTurnEndMessages(attacker, defender);
                continue;
            }
            showOutOfPowerMessage(attacker, defender);
        }
    }

    private IPlayer generatePlayer() {
        String name = playerInput.getPlayerName();
        JobType job = playerInput.getJobType();

        switch (job) {
            case FIGHTER:
                return new Fighter(name);
            case WIZARD:
                return new Wizard(name);
            case PRIEST:
                return new Priest(name);
            case ASSASSIN:
                return new Assassin(name);
            default:
                return null;
        }
    }

    private boolean isEndGame() {
        boolean result = false;
        for (IPlayer player : players) {
            result = result || !player.isLive();
        }
        return result;
    }

    private IPlayer getDefender(int i) {
        if (i == PLAYER_NUMBER - 1) {
            return players.get(0);
        }
        return players.get(i + 1);
    }

    private void showOutOfPowerMessage(IPlayer attacker, IPlayer defender) {
        Messages.showFormattedMessage(Messages.OUT_OF_POWER, defender.getName());
        Messages.showFormattedMessage(Messages.WIN, attacker.getName());
    }

    private void showTurnEndMessages(IPlayer attacker, IPlayer defender) {
        Messages.showNewLine();
        Messages.showWithNewLine(Messages.TURN_END);
        for (IPlayer player : players) {
            Messages.showFormattedMessage(
                    Messages.PLAYER_INFO,
                    player.getName(),
                    player.getHitPoint(),
                    player.getMagicPoint(),
                    player.getAilment().name());
        }
        Messages.showWithNewLine(Messages.LINE);
        Messages.showNewLine();
    }
}
