/**
* @author jiangzm
* @version 创建时间：2017年8月25日 上午10:53:57
* 类说明
* You are given an n x n 2D matrix representing an image.
* Rotate the image by 90 degrees (clockwise).
* Note:
* You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
* 
* Given input matrix = 
* [
*  [1,2,3],
*  [4,5,6],
*  [7,8,9]
* ],
* rotate the input matrix in-place such that it becomes:
* [
*  [7,4,1],
*  [8,5,2],
*  [9,6,3]
* ]
*/
public class RotateImage {
	public void rotate(int[][] matrix) {
		int xlength = matrix.length;
		int ylength = matrix[0].length;
		
		int[][] image = new int[ylength][xlength];
        for (int x = 0; x < xlength; x ++) {
			for (int y = 0; y < ylength; y ++) {
				//System.out.println((y) + "," + (length - x - 1) + ":" +matrix[x][y]);
				image[y][ylength - x - 1] = matrix[x][y];
				
			}

		}
        for (int i = 0; i < ylength; i++) {
			for (int j = 0; j < xlength; j++) {
				matrix[i][j] = image[i][j];
			}
		}
    }
	
	public static void main(String[] args) {
		int[][] matrix = new int[10000][10000];
		int data = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = data;
				data ++;
			}
		}
		long start = System.currentTimeMillis();
		new RotateImage().rotate(matrix);
		System.out.println(System.currentTimeMillis() - start);
	}
}
