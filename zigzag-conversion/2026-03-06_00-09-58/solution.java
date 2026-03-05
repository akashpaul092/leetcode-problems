class Solution {
    public String convert(String s, int numRows) {
        StringBuffer arr[] =new StringBuffer[numRows];
        for(int i=0;i<numRows;i++){
            arr[i]=new StringBuffer();
        }
        int l=s.length();
        int k=0;
        while(k<l){
            for(int c=0;c<numRows && k<l;c++){
                arr[c].append(s.charAt(k));
                k++;
            }
            for(int c=numRows-2;c>0 && k<l;c--){
                arr[c].append(s.charAt(k));
                k++;
            }
        }
        StringBuffer ans=new StringBuffer();
        for(StringBuffer a : arr){
            ans.append(a);
        }
        return ans.toString();
    }
}