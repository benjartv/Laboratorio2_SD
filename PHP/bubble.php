<?php
if($_SERVER['REQUEST_METHOD'] == "POST"){

	$entrada = explode(";",$_POST["numeros"]);
	// fuente: http://stackoverflow.com/questions/9001294/bubble-sort-implementation-in-php
	function bubble_sort($arr) {
	    $size = count($arr);
	    for ($i=0; $i<$size; $i++) {
	        for ($j=0; $j<$size-1-$i; $j++) {
	            if ($arr[$j+1] < $arr[$j]) {
	                swap($arr, $j, $j+1);
	            }
	        }
	    }
	    return $arr;
	}
	function swap(&$arr, $a, $b) {
	    $tmp = $arr[$a];
	    $arr[$a] = $arr[$b];
	    $arr[$b] = $tmp;
	}

	$resp = bubble_sort($entrada);
	echo json_encode($resp);
}
?>