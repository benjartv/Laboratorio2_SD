/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.ArrayList;
import java.util.Arrays;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author roberto
 */
@Path("bubble")
public class BubbleSortResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BubbleSortResource
     */
    public BubbleSortResource() {
    }

    /**
     * Retrieves representation of an instance of ws.BubbleSortResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    @POST
    @Produces("application/json")
    public String postJson(String entrada) {
        String[] arreglo = entrada.replace("entrada=", "").replace("%3B", ";").split(";");
        Float[] arregloFlotante = new Float[arreglo.length];
        //ArrayList<Float> arrayFlotante = new ArrayList<Float>();
        for (int i = 0; i < arreglo.length; i++) {
            arregloFlotante[i] = Float.parseFloat(arreglo[i]);
            //arrayFlotante.add(Float.parseFloat(arreglo[i]));
            
        }
        BubbleSort(arregloFlotante);
        String resp = "";
        for (int i = 0; i < arregloFlotante.length; i++) {
            resp = resp + arregloFlotante[i].toString()+";";
        }
        return resp;
    }
    /*
    Algoritmo BubbleSort obtenido desde:
        http://mathbits.com/MathBits/Java/arrays/Bubble.htm
    */
    public static void BubbleSort( Float [ ] num )
    {
         int j;
         boolean flag = true;   // set flag to true to begin first pass
         Float temp;   //holding variable

         while ( flag )
         {
                flag= false;    //set flag to false awaiting a possible swap
                for( j=0;  j < num.length -1;  j++ )
                {
                       if ( num[ j ] > num[j+1] )   // change to > for ascending sort
                       {
                               temp = num[ j ];                //swap elements
                               num[ j ] = num[ j+1 ];
                               num[ j+1 ] = temp;
                              flag = true;              //shows a swap occurred 
                      }
                }
          }
    } 


    
}
