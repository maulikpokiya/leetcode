public class FindMedianSortedArrays {

    private double calculateMedian(int[] resultArray) {

        int len = resultArray.length;
        double median = 0d;

        if(len>0) {
            if(len % 2 == 0) { // when there are even no. of elements in array
                median = resultArray[len/2] + resultArray[(len/2)-1];
                median /= 2;
            } else { // when odd no. of elements
                median = resultArray[len/2];
            }
        }

        return median;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int i=0, j=0, k=0;

        int l1 = nums1!=null ? nums1.length : 0;
        int l2 = nums2!=null ? nums2.length : 0;

        int[] resultArray = new int[l1+l2];

        // Merge both arrays first
        
            if(l1 == 0 || l2 == 0) {
                resultArray = l1==0 ? nums2 : nums1; //Assuming nums2 is not null.
            } else {
                while(i<nums1.length || j<nums2.length) {

                    if(i != nums1.length && j != nums2.length) {
                        if(nums1[i] < nums2[j]) {
                            resultArray[k++] = nums1[i++];
                        } else {
                            resultArray[k++] = nums2[j++];
                        }
                        continue;
                    } else if(i == nums1.length) {
                        resultArray[k++] = nums2[j++];
                    } else if(j == nums2.length) {
                        resultArray[k++] = nums1[i++];
                    }
                }
            }

        // Calclate median and return
        return calculateMedian(resultArray);
    }
}