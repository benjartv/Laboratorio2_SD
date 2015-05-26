<%@ WebService Language="C#" Class="OrdenarC" %>

using System;
using System.Web.Services;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Script.Serialization;
//using System.Web.Script.Services.ScriptHandlerFactory, System.Web.Extensions, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35"

    [WebService]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]

public class OrdenarC : System.Web.Services.WebService {

/// ref http://www.softwareandfinance.com/CSharp/QuickSort_Iterative.html
/// ref http://www.softwareandfinance.com/CSharp/Bubble_Sort.html
/// ref http://www.c-sharpcorner.com/Blogs/14068/merge-sorting-algorithm-in-C-Sharp.aspx

		static public int Partition(float [] numbers, int left, int right)
        {
            float pivot = numbers[left];
              while (true)
              {
                while (numbers[left] < pivot)
                    left++;
 
                while (numbers[right] > pivot)
                    right--;
 
                if (left < right)
                    {
                    float temp = numbers[right];
                    numbers[right] = numbers[left];
                    numbers[left] = temp;
                    }
                    else
                    {
                          return right;
                    }
              }
        }
        struct QuickPosInfo
        {
            public int left;
            public int right;
        };
        static public void QuickSort(float [] numbers, int left, int right)
        {
           
            if(left >= right)
                return; // Invalid index range
 
            List<QuickPosInfo> list = new List<QuickPosInfo>();
 
            QuickPosInfo info;
            info.left = left;
            info.right = right;
            list.Insert(list.Count, info);
 
            while(true)
            {
                if(list.Count == 0)
                    break;
 
                left = list[0].left;
                right = list[0].right;
                list.RemoveAt(0);
 
                int pivot = Partition(numbers, left, right);   
               
                if(pivot > 1)
                {
                    info.left = left;
                    info.right = pivot - 1;
                    list.Insert(list.Count, info);
                }
 
                if(pivot + 1 < right)
                {
                    info.left = pivot + 1;
                    info.right = right;
                    list.Insert(list.Count, info);
                }
            }
        }

        static public void MainMerge(float[] numbers, int left, int mid, int right)
        {
            float[] temp = new float[25];
            int i, eol, num, pos;
 
            eol = (mid - 1);
            pos = left;
            num = (right - left + 1);
 
            while ((left <= eol) && (mid <= right))
            {
                if (numbers[left] <= numbers[mid])
                    temp[pos++] = numbers[left++];
                else
                    temp[pos++] = numbers[mid++];
            }
 
            while (left <= eol)
                temp[pos++] = numbers[left++];
 
            while (mid <= right)
                temp[pos++] = numbers[mid++];
 
            for (i = 0; i < num; i++)
            {
                numbers[right] = temp[right];
                right--;
            }
        }
 
        static public void SortMerge(float[] numbers, int left, int right)
        {
            int mid;
 
            if (right > left)
            {
                mid = (right + left) / 2;
                SortMerge(numbers, left, mid);
                SortMerge(numbers, (mid + 1), right);
 
                MainMerge(numbers, left, (mid + 1), right);
            }
        }

       [WebMethod]
        public string bubble(string numeros)
        {
        	string [] num = numeros.Split(';');
            float[] num2 = new float[num.Length];

            int i = 0;
            foreach (var n in num)
            {
                num2[i] = float.Parse(n.Replace('.',','));
                i++;
            }
            float temp = 0;
        	for (int write = 0; write < num2.Length; write++) {
				for (int sort = 0; sort < num2.Length - 1; sort++) {
			        if (num2[sort] > num2[sort + 1]) {
			            temp = num2[sort + 1];
			            num2[sort + 1] = num2[sort];
			            num2[sort] = temp;
			        }
				}
			}
			string a = String.Empty;
            foreach (var n in num2)
            {
                a = a + n.ToString().Replace(',', '.') + ";";
            }
            return a;
        }

        [WebMethod]
        public string quick(string numeros)
        {
        	string [] num = numeros.Split(';');
            float[] num2 = new float[num.Length];

            int i = 0;
            foreach (var n in num)
            {
                num2[i] = float.Parse(n.Replace('.',','));
                i++;
            }
            QuickSort(num2, 0, num2.Length - 1);
            string a = String.Empty;
            foreach (var n in num2)
            {
                a = a + n.ToString().Replace(',', '.') + ";";
            }
            return a;
        }

        [WebMethod]
        public string merge(string numeros)
        {
        	string [] num = numeros.Split(';');
            float[] num2 = new float[num.Length];

            int i = 0;
            foreach (var n in num)
            {
                num2[i] = float.Parse(n.Replace('.',','));
                i++;
            }
            SortMerge(num2, 0, num2.Length - 1);
            string a = String.Empty;
            foreach (var n in num2)
            {
                a = a + n.ToString().Replace(',', '.') + ";";
            }
            return a;
        }
       
}