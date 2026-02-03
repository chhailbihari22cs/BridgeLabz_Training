package StreamBuzz;

public class CreatorStats {
	String creatorName;
    double[] weeklyLikes = new double[4];

    public CreatorStats(String creatorName, double[] weeklyLikes) {
        this.creatorName = creatorName;
        this.weeklyLikes = weeklyLikes;
    }

    double calculateAverageLikes() {
        double sum = 0;
        for (double like : weeklyLikes) {
            sum += like;
        }
        return sum / 4;
    }
}
