import java.util.Arrays;

public class Marathon {
    private static final int MINUTE = 60;
    private static final int HOUR = 60 * 60;

    private static int timeToSec(int[] time) {
        return time[0] * HOUR + time[1] * MINUTE + time[2];
    }

    private static int[] secToTime(int seconds) {
        return new int[]{
                seconds / HOUR,
                seconds % HOUR / MINUTE,
                (seconds % HOUR) % MINUTE
        };
    }

    private static String timeToString(int[] time) {
        return String.format("%02d:%02d:%02d", time[0], time[1], time[2]);
    }

    public static int[] avgTime(double distance, int time) {
        return secToTime((int) Math.round(time / distance));
    }

    public static double avgSpeed(double distance, int time) {
        return (distance / time) * HOUR;
    }

    public static Runner getTheFastestRunner(Runner[] marathon) {
        Runner theFastestRunner = marathon[0];
        for (Runner r: marathon) {
            if (r.getFinishTime() < theFastestRunner.getFinishTime()) theFastestRunner = r;
        }
        return theFastestRunner;
    }

    public static int upToRunners(Runner[] marathon, int[] startTime) {
        int upToCounter = 0;
        int[] checkingTime = new int[]{2, 7, 0};
        for (Runner runner : marathon) {
            if (runner.timeDifference(timeToSec(startTime)) < timeToSec(checkingTime)) upToCounter++;
            else break;
        }
        return upToCounter;
    }

    public static void main(String[] args) {
        final int[] startTime = new int[]{9, 15, 0}; // mass start time - 09:15:00
        final double distance = 42.195; // distance length in kilometers

        Runner[] marathon = new Runner[]{
                new Runner(1, timeToSec(new int[]{11, 16, 39})),
                new Runner(2, timeToSec(new int[]{11, 21, 48})),
                new Runner(4, timeToSec(new int[]{11, 21, 23})),
                new Runner(12, timeToSec(new int[]{11, 23, 46})),
                new Runner(13, timeToSec(new int[]{11, 23, 16}))
        };

        // finding the fastest runner
        System.out.println("theFastestRunner je " + getTheFastestRunner(marathon).getNumber());

        // finding three fastest runners by sorting
        Arrays.sort(marathon);
        System.out.printf(
                "Nejrychlejší bězci byli %d, %d, %d\n",
                marathon[0].getNumber(),
                marathon[1].getNumber(),
                marathon[2].getNumber()
        );

        // finding how many runners is up to specified time
        System.out.printf("%d běžci běželi pod 2:07\n", upToRunners(marathon, startTime));

        // finding how much time lost the last runner from the first
        System.out.printf(
                "Poslední bězec měl ztrátu na prvního %s\n",
                timeToString(secToTime(marathon[marathon.length - 1].timeDifference(marathon[0].getFinishTime())))
        );

        // finding the fastest runner's average time on 1km
        System.out.printf(
                "Průměrný čas nejrychlejšího bězce na 1 km byl %s\n",
                timeToString(avgTime(distance, marathon[0].timeDifference(timeToSec(startTime))))
        );

        // finding the fastest runner's average speed
        System.out.printf(
                "Průměrná rychlost nejrychlejšího bězce byla %.2f km/h\n",
                avgSpeed(distance, marathon[0].timeDifference(timeToSec(startTime)))
        );
    }
}
