/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package application.domain ;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class Table
{

  private int number ;
  private int places ;

  public Table(int n, int p)
  {

    number = n ;
    places = p ;
  }

  public int getNumber()
  {
    return number ;
  }

  public int getPlaces()
  {
    return places ;
  }
}
