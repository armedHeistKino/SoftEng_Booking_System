/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package application.persistency ;

import application.domain.* ;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



class PersistentReservation
  extends Reservation implements PersistentBooking
{
  private int oid ;

  public PersistentReservation(int id, int c, java.sql.Date d, java.sql.Time t,
			       Table tab, Customer cust, java.sql.Time arr)
  {
    super(c, d, t, tab, cust, arr) ;
    oid = id ;
  }

  /* public because getId defined in an interface and hence public */

  public int getId() {
    return oid ;
  }
}
