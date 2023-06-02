/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package application.domain ;

public interface BookingObserver
{
  public void update() ;

  public boolean message(String s, boolean confirm) ;
}
