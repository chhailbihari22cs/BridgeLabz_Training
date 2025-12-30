class MovieTicket {
    private String movieName, seat;
    private boolean booked = false;

    void book(String movie, String seat) {
        if (!booked) {
            this.movieName = movie;
            this.seat = seat;
            booked = true;
            System.out.println("Ticket booked for movie: " + movie);
            System.out.println("Seat Number: " + seat);
            System.out.println("Price: $120.0");
        } else {
            System.out.println("House full!!! sorry..... Ticket already booked");
        }
    }

    public static void main(String[] args) {
        MovieTicket t = new MovieTicket();
        t.book("Dragon", "A10");
        t.book("Dragon", "A11");
    }
}
