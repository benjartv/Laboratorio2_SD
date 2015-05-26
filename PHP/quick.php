<?php
if($_SERVER['REQUEST_METHOD'] == "POST"){

	$entrada = explode(";",$_POST["numeros"]);
	// fuente: http://pageconfig.com/post/implementing-quicksort-in-php
	function quicksort( $array ) {
	    if( count( $array ) < 2 ) {
	        return $array;
	    }
	    $left = $right = array( );
	    reset( $array );
	    $pivot_key  = key( $array );
	    $pivot  = array_shift( $array );
	    foreach( $array as $k => $v ) {
	        if( $v < $pivot )
	            $left[$k] = $v;
	        else
	            $right[$k] = $v;
	    }
	    return array_merge(quicksort($left), array($pivot_key => $pivot), quicksort($right));
	}

	$resp = quicksort($entrada);
	echo json_encode($resp);
}
?>