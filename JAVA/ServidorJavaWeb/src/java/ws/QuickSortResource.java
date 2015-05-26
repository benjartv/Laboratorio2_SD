/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

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
@Path("quick")
public class QuickSortResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of QuickSortResource
     */
    public QuickSortResource() {
    }

    /**
     * Retrieves representation of an instance of ws.QuickSortResource
     * @return an instance of java.lang.String
     */
   
    @POST
    @Produces("application/json")
    public String postJson(String entrada) {
        String[] arreglo = entrada.replace("entrada=", "").replace("%3B", ";").split(";");
        Float[] arregloFlotante = new Float[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            arregloFlotante[i] = Float.parseFloat(arreglo[i]);
            
            
        }
        quickSort(arregloFlotante,0,arregloFlotante.length-1);
        String resp = "";
        for (int i = 0; i < arregloFlotante.length; i++) {
            resp = resp + arregloFlotante[i].toString()+";";
        }
        return resp;
    }
    /*
    Algoritmo obtenido desde:
        http://www.programcreek.com/2012/11/quicksort-array-in-java/
    */
    public static void quickSort(Float[] arr, int low, int high) {
 
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		//pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle].intValue();
 
		//make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i].intValue();
				arr[i] = arr[j];
				arr[j] = Float.intBitsToFloat(temp);
				i++;
				j--;
			}
		}
 
		//recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}
}
