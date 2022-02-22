package internal.presentation;

import java.util.Scanner;

import internal.domain.vo.JobType;

public class PlayerInput {
    private static final Scanner STDIN = new Scanner(System.in);

    private static final int START_JOB_INPUT = 1;

    public String getPlayerName() {
        Messages.showWithoutNewLine(Messages.WAITING_INPUT_NAME);
        String input = STDIN.next();
        Messages.showNewLine();
        return input;
    }

    public JobType getJobType() {
        Messages.showWithNewLine(Messages.WAITING_INPUT_JOB);
        for (JobType job : JobType.values()) {
            Messages.showFormattedMessage(Messages.SELECT_JOB, job.ordinal() + 1, job.name());
        }
        String input = STDIN.next();
        Messages.showNewLine();
        return getCorrectInputJob(input);
    }

    private JobType getCorrectInputJob(String input) {
        JobType jobs[] = JobType.values();
        int inputNumber = START_JOB_INPUT;

        try {
            inputNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Messages.showWithNewLine(Messages.INPUT_WARN);
            Messages.showNewLine();
            return getJobType();
        }

        if (START_JOB_INPUT <= inputNumber && inputNumber <= jobs.length) {
            return jobs[inputNumber - 1];
        }
        Messages.showWithNewLine(Messages.INPUT_WARN);
        return getJobType();
    }
}
