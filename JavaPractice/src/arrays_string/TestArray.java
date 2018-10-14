package arrays_string;

class RotateArray 
{
    /*Function to left rotate arr[] of siz n by d*/
    void leftRotate(int arr[], int d, int n) 
    {
        int i, j, k, temp;
        for (i = 0; i < gcd(d, n); i++) 
        {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) 
            {
                k = j + d;
                if (k >= n) 
                    k = k - n;
                if (k == i) 
                    break;
                arr[j] = arr[k];
                j = k;
                System.out.println();
                printArray(arr, 9);
            }
            arr[j] = temp;
            System.out.println("outerloop");
            printArray(arr, 9);
            
        }
    }

    /*UTILITY FUNCTIONS*/
    
    /* function to print an array */
    void printArray(int arr[], int size) 
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }

    /*Fuction to get gcd of a and b*/
    int gcd(int a, int b) 
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        RotateArray rotate = new RotateArray();
        int arr[] = {1, 2, 3, 4, 5, 6, 7,8,9};
        rotate.leftRotate(arr, 6, 9);
        System.out.println();
        rotate.printArray(arr, 9);
    }
}
