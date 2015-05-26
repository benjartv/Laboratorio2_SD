/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 * ref: http://www.it.uc3m.es/tsps/lab/8/skel/MergeSort.java
 * @author roberto
 */


@Path("merge")
public class MergeSortResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MergeSortResource
     */
    public MergeSortResource() {
    }

    /**
     * Retrieves representation of an instance of ws.MergeSortResource
     * @return an instance of java.lang.String
     */
private Float[] arrayF;
private Float[] tempMergArry;
private Float lengths;    
@POST
    @Produces("application/json")
    public String postJson(String entrada) {
        String[] arreglo = entrada.replace("entrada=", "").replace("%3B", ";").split(";");
        Float[] arregloFlotante = new Float[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            arregloFlotante[i] = Float.parseFloat(arreglo[i]);
        }
        mergeSort(arregloFlotante);
        String resp = "";
        for (int i = 0; i < arregloFlotante.length; i++) {
            resp = resp + arregloFlotante[i].toString()+";";
        }
        return resp;
    }
    /*
    Algoritmo MergeSorte obtenido de:
        http://www.java2novice.com/java-sorting-algorithms/merge-sort/
    */
    public static void mergeSort( Float a[ ]){
        Float tmpArray[] = new Float[ a.length ];

        mergeSort( a, tmpArray, 0, a.length - 1 );
    }
    private static void mergeSort( Float a[ ], Float tmpArray[], int left, int right ){
        if( left < right )
        {
            int center = ( left + right ) / 2;
            mergeSort( a, tmpArray, left, center );
            mergeSort( a, tmpArray, center + 1, right );
            merge( a, tmpArray, left, center + 1, right );
        }
    }

    private static void merge( Float a[ ], Float tmpArray[], int leftPos, int rightPos, int rightEnd){
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // Main loop
        while( leftPos <= leftEnd && rightPos <= rightEnd ){
            if( a[ leftPos ]<( a[ rightPos ] ) ){
                tmpArray[ tmpPos++ ] = a[ leftPos++ ];
            }
            else{
                tmpArray[ tmpPos++ ] = a[ rightPos++ ];
            }
        }
        while( leftPos <= leftEnd ){    // Copy rest of first half
            tmpArray[ tmpPos++ ] = a[ leftPos++ ];
        }
        while( rightPos <= rightEnd ){  // Copy rest of right half
            tmpArray[ tmpPos++ ] = a[ rightPos++ ];
        }
        // Copy TmpArray back
        for( int i = 0; i < numElements; i++, rightEnd-- ){
            a[ rightEnd ] = tmpArray[ rightEnd ];
        }
    }
    /**
     * PUT method for updating or creating an instance of MergeSortResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */

}
