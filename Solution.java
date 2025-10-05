class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        rec(n, ans, new StringBuilder(), 0,0);
        return ans;
    }
    public void rec(int n, List<String> ans, StringBuilder currAns, int countOpenParenthesis, int countClosedParenthesis) {
         if(currAns.length()> 2*n) {
            return;
        }

        if(currAns.length() == 2*n) {
            ans.add(currAns.toString());
            return;
        }
        //choice 1 use open
        if(countOpenParenthesis<n) {
            currAns.append('(');
            rec(n, ans, currAns, countOpenParenthesis+1, countClosedParenthesis);
            currAns.deleteCharAt(currAns.length() - 1);
        }

        //choice 2 use closed
        if(countClosedParenthesis< countOpenParenthesis && countClosedParenthesis<n) {
            currAns.append(')');
            rec(n, ans, currAns, countOpenParenthesis, countClosedParenthesis+1);
            currAns.deleteCharAt(currAns.length() - 1);
        }
    }
}
