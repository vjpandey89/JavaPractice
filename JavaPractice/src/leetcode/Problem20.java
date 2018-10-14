package leetcode;

import java.util.Stack;

public class Problem20 {
	public static void main(String[] args) {
		String str="{}[]()";
		
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
			if(ch=='{')
				stack.push('}');
			else if (ch=='(')
				stack.push(')');
			else if(ch=='[')
				stack.push(']');
			else if(stack.isEmpty()||stack.pop()!=ch)
				System.out.println("false");
		}
		System.out.println(stack.isEmpty());
		
		
	}

}
