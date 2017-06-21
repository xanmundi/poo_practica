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
import java.util.*;
import javax.swing.DefaultListModel;

public class ListadoPersonas
{
    // instance variables - replace the example below with your own
    private static ArrayList<Persona> p;
    private static GestionFicheros gf;
    
    /**
     * Constructor for objects of class Array
     */
    public ListadoPersonas()
    {
        // initialise instance variables
        p=new ArrayList<Persona>();
        gf = new GestionFicheros();
    }
    
    public void imprime()
    {
         printArray();
    }
    

    public void llenaArray()
    {
        p.add(new Persona("78793119H", "Juan","juan@juan.com"));
        p.add(new Persona("78793118Y", "Andres","andres@juan.com"));
        p.add(new Persona("76870729Z", "Maribel","maribel@juan.com"));
        //p.add(new Clientes("Cliente", "Maribel","maribel@juan.com","Contado"));
        
                try 
        {
            gf.escribeFichero(p);
        }
        catch (IOException e) 
        {
        // Do something here
    }
    
    }
    
    public void printArray()
    {
        ArrayList<Persona> p= gf.leerFichero();
        for (Persona pe: p)
            {
                //System.out.println(pe);
                pe.print();
            }
    }
    
    public DefaultListModel getModelo()
    {
        ArrayList<Persona> p= gf.leerFichero();
        DefaultListModel modelo= new DefaultListModel();
        for (Persona pe: p)
            {
                modelo.addElement(pe.getNIF()+" - "+pe.getNombre());
            }
            return modelo;
    }
    
    public void borraRegistro(int r)
    {
       ArrayList<Persona> p= gf.leerFichero();
        p.remove(r);

        try 
        {   
            gf.escribeFichero(p);
        }
        catch (IOException e) 
        {
        // Do something here
    }
    
    }  
    
    public void leeClientes()
    {        try 
        {
            //p=null;
            ArrayList<Persona> c= gf.leerClientes();

            
                   for (Persona pe: c)
            {
                //System.out.println(pe);
                pe.print();
            }// put your code here
            
        }
        finally
        {
        // Do something here
    }
        
    }
}