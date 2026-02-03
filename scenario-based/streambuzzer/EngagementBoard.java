package StreamBuzz;

import java.util.*;

public class EngagementBoard {
	List<CreatorStats> records = new ArrayList<>();

    public void registerCreator(CreatorStats record) {
        records.add(record);
        System.out.println("Creator registered successfully");
    }

    Map<String, Integer> getTopPostCounts(double likeThreshold) {

        Map<String, Integer> result = new HashMap<>();

        for (CreatorStats c : records) {
            int count = 0;
            for (double like : c.weeklyLikes) {
                if (like >= likeThreshold) {
                    count++;
                }
            }
            if (count > 0) {
                result.put(c.creatorName, count);
            }
        }
        return result;
    }

    double calculateOverallAverageLikes() {
        double total = 0;
        int count = 0;

        for (CreatorStats c : records) {
            for (double like : c.weeklyLikes) {
                total += like;
                count++;
            }
        }
        return count == 0 ? 0 : total / count;
    }
}