package practica;


/**
 * Write a description of class Clientes here.
<<<<<<< HEAD
 * 
=======
 * vbvb
>>>>>>> refs/remotes/gitub/master
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clientes extends Persona
{
    // instance variables - replace the example below with your own
    private String formaPago;

    /**
     * Constructor for objects of class Clientes
     */
    public Clientes(String dni, String nome, String mail, String formaP)
    {
        // initialise instance variables
        super(dni, nome, mail);
        formaPago = formaP;
    }
    
    /** Imprime detalle */
    public void print()
    {
        super.print();
        System.out.println("    " + formaPago);
    }
    
    
}