class Solution {
    public void setZeroes(int[][] matrix) { 

        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < matrix[0].length; j ++){
                if(matrix[i][j] == 0){
                    // do something
                    // infect 
                    
                    for(int x = 0; x < matrix.length; x ++){
                        if(matrix[x][j] == 0) continue;
                        matrix[x][j] = Integer.MIN_VALUE;
                    }
                    for(int x = 0; x < matrix[0].length; x ++){
                        if(matrix[i][x] == 0) continue;
                        matrix[i][x] = Integer.MIN_VALUE;
                    }
                }
            }
        }

        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < matrix[0].length; j ++){
                if(matrix[i][j] == Integer.MIN_VALUE){
                    // do something
                    // infect 
                    matrix[i][j] = 0;
                }
            }
        }

    }
    
}
