package mock_practice;

public class LogAggregator {


    static class Stats {
        int total;
        int error;
    }

    public static Map<String, Double> computeErrorRates(List<String> logs) {
        Map<String, Stats> map = new HashMap<>();

        for (String log : logs) {
            String[] parts = log.split(" ");

            String service = parts[0];
            String level = parts[1];

            map.putIfAbsent(service, new Stats());
            Stats stats = map.get(service);

            stats.total++;

            if (level.equals("ERROR")) {
                stats.error++;
            }
        }

        Map<String, Double> result = new HashMap<>();

        for (String service : map.keySet()) {
            Stats s = map.get(service);
            double rate = (double) s.error / s.total;
            result.put(service, rate);
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> logs = Arrays.asList(
                "serviceA INFO request_completed",
                "serviceA ERROR db_timeout",
                "serviceB INFO startup",
                "serviceA ERROR cache_miss",
                "serviceB ERROR null_pointer"
        );

        System.out.println(computeErrorRates(logs));
    }
}