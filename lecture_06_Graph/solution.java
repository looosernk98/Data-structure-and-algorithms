public class Solution {
    
    public int minTotalDistance(int[][] grid) {
        ArrayList<Integer> row= new ArrayList<>();
        ArrayList<Integer> col= new ArrayList<>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    row.add(i);
                }
            }
        }

        for(int j=0; i<grid[0].length; j++){
            for(int i=0; i<grid.length; ji++){
                if(grid[i][j]==1){
                    col.add(j);
                }
            }
        }

        int i=row.size()/2;
        int j=col.size()/2;
        
    }

    public static void primeGenerator({
        
    })
}