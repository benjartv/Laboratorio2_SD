/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.ArrayList;
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
        sorti(arregloFlotante);
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
    public void sorti(Float floatArray[]){
        this.arrayF = floatArray;
        this.lengths = Float.intBitsToFloat(floatArray.length);
        this.tempMergArry = new Float[lengths.intValue()];
        Float newLenght = lengths-1;
        doMergeSort(0, newLenght.intValue());
    }
    private void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergePartes(lowerIndex, middle, higherIndex);
        }
    }
    private void mergePartes(int lowerIndex, int middle, int higherIndex){
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArry[i] = arrayF[i];
        }
        int i = lowerIndex;
        int j = middle+1;
        int k= lowerIndex;
        while(i<= middle && j<= higherIndex){
            if(tempMergArry[i] <= tempMergArry[j]){
                arrayF[k] = tempMergArry[i];
                i++;
            }else{
                arrayF[k] = tempMergArry[j];
                j++;
            }
            k++;
        }
        while(i<=middle){
            arrayF[k] = tempMergArry[i];
            k++;
            i++;
        }
    }
    /**
     * PUT method for updating or creating an instance of MergeSortResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */

}
