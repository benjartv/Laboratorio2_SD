from django.shortcuts import render
from django.views.decorators.csrf import csrf_exempt
from django.http import HttpResponse
import json

@csrf_exempt
def quick(request):
	if request.method == 'POST':
		data = request.POST["str"]
	else:
		data = '1.3;3.3;5.7;9.5;0.4;0.9;4.5;1.1'
	data = data.split(";")
	for i in range(len(data)):
		data[i] = float(data[i])
	quickSort(data)
	return HttpResponse(json.dumps(data), content_type="application/json")


@csrf_exempt
def merge(request):
	if request.method == 'POST':
		data = request.POST["str"]
	else:
		data = '1.3;3.3;5.7;9.5;0.4;0.9;4.5;1.1'
	data = data.split(";")
	for i in range(len(data)):
		data[i] = float(data[i])
	mergeSort(data)
	return HttpResponse(json.dumps(data), content_type="application/json")

@csrf_exempt
def bubble(request):
	if request.method == 'POST':
		data = request.POST["str"]
	else:
		data = '1.3;3.3;5.7;9.5;0.4;0.9;4.5;1.1'
	data = data.split(";")
	for i in range(len(data)):
		data[i] = float(data[i])
	bubbleSort(data)
	return HttpResponse(json.dumps(data), content_type="application/json")


#ref: http://interactivepython.org/runestone/static/pythonds/SortSearch/TheBubbleSort.html
def bubbleSort(alist):
    for passnum in range(len(alist)-1,0,-1):
        for i in range(passnum):
            if alist[i]>alist[i+1]:
                temp = alist[i]
                alist[i] = alist[i+1]
                alist[i+1] = temp



#ref: http://interactivepython.org/courselib/static/pythonds/SortSearch/TheQuickSort.html
def quickSort(alist):
   quickSortHelper(alist,0,len(alist)-1)

def quickSortHelper(alist,first,last):
   if first<last:

       splitpoint = partition(alist,first,last)

       quickSortHelper(alist,first,splitpoint-1)
       quickSortHelper(alist,splitpoint+1,last)


def partition(alist,first,last):
   pivotvalue = alist[first]

   leftmark = first+1
   rightmark = last

   done = False
   while not done:

       while leftmark <= rightmark and \
               alist[leftmark] <= pivotvalue:
           leftmark = leftmark + 1

       while alist[rightmark] >= pivotvalue and \
               rightmark >= leftmark:
           rightmark = rightmark -1

       if rightmark < leftmark:
           done = True
       else:
           temp = alist[leftmark]
           alist[leftmark] = alist[rightmark]
           alist[rightmark] = temp

   temp = alist[first]
   alist[first] = alist[rightmark]
   alist[rightmark] = temp


   return rightmark



#ref: http://interactivepython.org/courselib/static/pythonds/SortSearch/TheMergeSort.html
def mergeSort(alist):
    if len(alist)>1:
        mid = len(alist)//2
        lefthalf = alist[:mid]
        righthalf = alist[mid:]

        mergeSort(lefthalf)
        mergeSort(righthalf)

        i=0
        j=0
        k=0
        while i<len(lefthalf) and j<len(righthalf):
            if lefthalf[i]<righthalf[j]:
                alist[k]=lefthalf[i]
                i=i+1
            else:
                alist[k]=righthalf[j]
                j=j+1
            k=k+1

        while i<len(lefthalf):
            alist[k]=lefthalf[i]
            i=i+1
            k=k+1

        while j<len(righthalf):
            alist[k]=righthalf[j]
            j=j+1
            k=k+1






