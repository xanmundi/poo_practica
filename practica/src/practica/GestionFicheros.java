package practica;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class GestionFicheroa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GestionFicheros
{
    // instance variables - replace the example below with your own
    public static final String FICHERO_PERSONAS = "persona.txt";
    private int x;
    private ArrayList<Persona> p;

    /**
     * Constructor for objects of class GestionFicheroa
     */
    public GestionFicheros()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void escribeFichero(ArrayList<Persona> r) throws IOException
    {
        
        OutputStream os = null;
        try
            {
                os = new FileOutputStream(FICHERO_PERSONAS);
                ObjectOutputStream oos = new ObjectOutputStream(os);
                for (Persona per : r)
                {
                    oos.writeObject(per);
                }
                oos.flush();
            }           
        finally
            {
                if (os != null) 
                {
                   os.close();
                }
            } 
    }
    
    public ArrayList<Persona> leerFichero()
    {
        ArrayList<Persona> p=new ArrayList<Persona>();
        try
        {
            // Se crea un ObjectInputStream
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(FICHERO_PERSONAS));
            
            // Se lee el primer objeto
            Persona aux=(Persona) ois.readObject();
            //System.out.println(aux.getClass());
            p.add(aux);
            // Mientras haya objetos
            
            while (aux!=null)
            {
                if (aux instanceof Persona)
                    //System.out.println(aux);
                    //System.out.println(aux.getClass());
                aux =(Persona) ois.readObject();
                p.add(aux);
                
            }
            ois.close();
 
        }
        catch (EOFException e1)
        {
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
        return (p);
    }
    
     public ArrayList<Persona> leerClientes()
    {
        ArrayList<Persona> p=new ArrayList<Persona>();
        try
        {
            // Se crea un ObjectInputStream
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(FICHERO_PERSONAS));
            
            // Se lee el primer objeto
            Persona aux=(Clientes) ois.readObject();
            //System.out.println(aux.geftClass());
            p.add(aux);
            // Mientras haya objetos
            
            while (aux!=null)
            {
                if (aux instanceof Clientes)
                    //System.out.println(aux);
                    //System.out.println(aux.getClass());
                aux =(Clientes) ois.readObject();
                p.add(aux);
                

            }
            ois.close();
 
        }
        catch (EOFException e1)
        {
            System.out.println ("Fin de fichero");
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
        return (p);
    }
    
    public List<Persona> readFichero()
    {
        ArrayList<Persona> p=new ArrayList<Persona>();
        try
        {
            // Se crea un ObjectInputStream
        ObjectInputStream ois = new ObjectInputStream(
        new FileInputStream(FICHERO_PERSONAS));
        Object obj=null;
        while((obj=ois.readObject())!=null)
        {
            if(obj instanceof Persona)
            {
                Persona pers =(Persona) obj;
                p.add(pers);
                System.out.println(pers.getNombre());
                System.out.println(p.getClass());
                
            }
                    for (Persona pe: p)
            {
                //System.out.println(pe);
                pe.print();
            }
        
        }
             ois.close();
        }
        catch (EOFException e1)
        {
            System.out.println ("Fin de fichero");
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }      
       
            
            
        return p;
    }
    
    
    
    
    // LEE FICHERO NFORMA INGLES
    public ArrayList<Persona> leeFichero() throws IOException, ClassNotFoundException
    {
        int contador=0;
        ArrayList<Persona> p=new ArrayList<Persona>();
        InputStream is = null;
        try
            {
                is= new FileInputStream(FICHERO_PERSONAS);
                ObjectInputStream ois = new ObjectInputStream(is);
                Object per=(Persona) ois.readObject();
                while (true)
                {
                    try
                    {
                        Persona pers=(Persona) ois.readObject();
                        System.out.println(pers);p.add(pers);
                        //System.out.println(p.get(0));
                        System.out.println("Contador: "+contador);
                          
                    
                    }
                    catch (EOFException ex)
                    {
                        break;
                                                
                    }
                }
                                    for (Persona pe: p)
            {
                //System.out.println(pe);
                pe.print();
            }

            ois.close();
            } finally {
                if (is != null) {
                                            System.out.println("Contador: "+contador);
                    is.close();
                    
                }
            }
        //System.out.println(p.get);    
    return p;
  }
                
<<<<<<< HEAD
}
=======
}
>>>>>>> refs/remotes/gitub/master
