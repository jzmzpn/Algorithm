
public class LongestSubString {
	public int lengthOfLongestSubstring(String s) {
		StringBuffer sb = new StringBuffer();
		String data = "";
		for (int i = 0; i < s.length(); i++) {
			String str = s.charAt(i) + "";
			
			int indexOf = sb.lastIndexOf(str);
			sb.append(str);
			if(indexOf != -1) {
				int length = sb.length() - 1;
				if(data.length() <= length) {
					data = sb.substring(0, length);
				}
				String substring = sb.substring(indexOf + 1);
				sb.setLength(0);
				sb.append(substring);
				//sb = new StringBuffer(sb.substring(indexOf + 1));
			}
			
		}
		if(sb.length() > data.length()) data = sb.toString();
        return data.length();
    }
	
	public int lengthOfLongestSubstring1(String s) {
		StringBuffer sb = new StringBuffer();
		int longestLength = 0;
		for (int i = 0; i < s.length(); i++) {
			String str = s.charAt(i) + "";
			
			int indexOf = sb.lastIndexOf(str);
			sb.append(str);
			if(indexOf != -1) {
				int length = sb.length() - 1;
				if(longestLength <= length) {
					//data = sb.substring(0, length);
					longestLength = length;
				}
				String substring = sb.substring(indexOf + 1);
				sb.setLength(0);
				sb.append(substring);
				//sb = new StringBuffer(sb.substring(indexOf + 1));
			}
			
		}
		int length = sb.length();
		return length > longestLength ? length : longestLength;
        //return data.length();
    }
	
	public static void main(String[] args) {
		//new LongestSubString().lengthOfLongestSubstring("aaaa");
		String s = "aaabdadfeeee";
		System.out.println(new LongestSubString().lengthOfLongestSubstring1("uiggtyqjt"));
	}
}
