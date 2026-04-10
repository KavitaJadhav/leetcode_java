//| Approach    | Time             |
//| ----------- | ---------------- |
//| Sorting     | O(n log n)       |
//| Heap        | O(n log k)       |
//| QuickSelect | **O(n) average** |

//Why QuickSelect is used in Interviews:
//It solves problems like:
//    K closest points to origin
//    Kth largest element
//    Top K frequent elements
//    Median of unsorted array
//    And it is faster than patterns.heap O(n log k) for large inputs.

package patterns.heap;

class KClosestPointToOriginQuickSelect {
    class Point {
        int distanceSquare;
        int[] axis;

        public Point(int distanceSquare, int[] axis) {
            this.distanceSquare = distanceSquare;
            this.axis = axis;
        }

        public int[] getAxis() {
            return this.axis;
        }
    }

    public int pivot(Point[] points, int startIndex, int endIndex, int k) {
        int pivotIndex = endIndex;

        for (int index = startIndex; index < pivotIndex; index++) {
            if (points[index].distanceSquare > points[pivotIndex].distanceSquare) {
                while (points[index].distanceSquare > points[pivotIndex].distanceSquare) {
                    Point temp = points[index];
                    points[index] = points[pivotIndex - 1];
                    points[pivotIndex - 1] = points[pivotIndex];
                    points[pivotIndex] = temp;
                    pivotIndex--;
                }
            }
        }

        if (pivotIndex == k) return pivotIndex;

        if (pivotIndex < k) return pivot(points, pivotIndex + 1, endIndex, k);
        else return pivot(points, startIndex, pivotIndex - 1, k);
    }

    public int[][] kClosest(int[][] points, int k) {
        if (points.length == k) return points;

        Point[] distance = new Point[points.length];
        int[][] result = new int[k][2];

        for (int index = 0; index < points.length; index++) {
            int[] point = points[index];
            int distanceSquare = (point[0] * point[0]) + (point[1] * point[1]);
            distance[index] = new Point(distanceSquare, point);
        }


        int pivotIndex = pivot(distance, 0, points.length - 1, k);
        for (int index = 0; index < k; index++) {
            result[index] = distance[index].getAxis();
        }
        return result;
    }
}