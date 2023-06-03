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


public class Customer
{
  private String name ;
  private String phoneNumber ;
  public Customer(String n, String p)
  {
    name = n ;
    phoneNumber = p ;
  }
  public String getName()
  {
    return name ;
  }
  public String getPhoneNumber()
  {
    return phoneNumber ;
  }
}
