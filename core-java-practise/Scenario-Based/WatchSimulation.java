class WatchSimulation {
    public static void main(String[] args) {

        for (int h = 0; h < 24; h++) {
            for (int m = 0; m < 60; m++) {

                if (h == 13 && m == 0) {
                    System.out.println("Power cut");
                    break;
                }

                if (m < 10)
                    System.out.println(h + ":0" + m);
                else
                    System.out.println(h + ":" + m);
            }

            if (h == 13)
                break;
        }
    }
}
