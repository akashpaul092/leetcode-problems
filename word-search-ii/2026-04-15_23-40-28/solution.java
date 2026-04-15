class Tries{
    Tries[] childrens = new Tries[26];
    String word = null;
}
class Solution {
    public static Tries buildTries(String[] words){
        Tries t = new Tries();
        for(String word: words){
            Tries dummy = t;
            for(int i=0; i< word.length(); i++){
                char ch = word.charAt(i);
                int index = ch - 'a';
                if(dummy.childrens[index] == null) dummy.childrens[index] = new Tries();
                dummy = dummy.childrens[index];
            }
            dummy.word = word;
        }
        return t;
    }

    public static void dfs(int row, int col, char[][] board, Tries t, List<String> res){
        if(board[row][col] == '#' || t == null) return;
        char ch = board[row][col];
        
        t = t.childrens[ch - 'a'];
        if (t == null) return;
        if(t.word != null){
            res.add(t.word);
            t.word = null;
        }
        board[row][col] = '#';
        int[][] dis = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] i: dis){
            int dr = row + i[0];
            int dc = col + i[1];
            if(dr>=0 && dr<board.length && dc>=0 && dc<board[0].length) dfs(dr, dc, board, t, res);
        }
        board[row][col] = ch;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Tries t = buildTries(words);
        List<String> res = new ArrayList<String>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                dfs(i, j, board, t, res);
            }
        }
        return res;
    }
}