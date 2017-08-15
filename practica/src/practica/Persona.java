package practica;

//import java.util.*;
import java.io.*;
/**
* Write a description of class Personas here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class Persona implements Serializable
{
  private String nif;
  private String nombre;
  private String email;
  
  /**
   * Constructor para objectos de la clase Personas
   * Inicializa los campos de persona.
   * 
   * @param  nif DNI o CIF de la persona
   * @param nombre El nombre de la persona
   * @param email Dirección de correo electrónico
   */
  
  public Persona (String nif, String nombre, String email)
  {
      this.nif=nif;
      this.nombre=nombre;
      this.email=email;      
  }
  
  public Persona(){}
  
<<<<<<< HEAD
  public void setdni(String d)
  {
      nif=d;
  }
  
  public void setNombre(String d)
  {
      nombre=d;
  }
  public void setEmail(String d)
  {
      email=d;
  }
  public String getNIF()
  {
      return nif;
  }

  public String getNombre()
  {
      return nombre;
  }
  
  public String getEmail()
  {
      return email;
  }
      
=======
      public void setdni(String d)
  {
      nif=d;
  }
  
  public String getNombre()
  {
      return nombre;
  }
  
      public String getNIF()
  {
      return nif;
  }
>>>>>>> refs/remotes/gitub/master

  /**
   * Print details of this item to the text terminal.
   */
  public void print()
  {
      System.out.print(nif + " -" + nombre + "-"+email);
      System.out.println("*");
     
  }
  
  
  
  
  
  
}