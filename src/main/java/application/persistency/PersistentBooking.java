/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package application.persistency ;

import application.domain.* ;
import org.springframework.stereotype.Component;


@Component
interface PersistentBooking extends Booking
{
  int getId() ;
}
