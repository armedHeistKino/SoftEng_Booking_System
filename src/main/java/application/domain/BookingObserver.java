/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package application.domain ;


import org.springframework.stereotype.Component;

@Component
public interface BookingObserver
{
  public void update() ;

  public boolean message(String s, boolean confirm) ;
}
