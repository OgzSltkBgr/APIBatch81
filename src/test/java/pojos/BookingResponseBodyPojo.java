package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingResponseBodyPojo {
    private Integer bookingid;
    private BookingPojo booking;

    public BookingResponseBodyPojo(Integer bookingid, BookingPojo bookingPojo) {
        this.bookingid = bookingid;
        this.booking = bookingPojo;
    }

    public BookingResponseBodyPojo() {
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "BookingResponseBodyPojo{" +
                "bookingid=" + bookingid +
                ", bookingPojo=" + booking +
                '}';
    }
}
