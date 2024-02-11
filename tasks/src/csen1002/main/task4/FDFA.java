package csen1002.main.task4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;


/**
 * Write your info here
 * 
 * @name mahmoud khalid zakria
 * @id 43-15405
 * @labNumber 10
 */
public class FDFA {
	/**
	 * FDFA constructor
	 * 
	 * @param description is the string describing a FDFA
	 */
	 String[] states ;
	 String[] acceptStates ;
	 
	public FDFA(String description) {
		// TODO Write Your Code Here
		 String[] descriptionSplit = description.split("#");
		 String[] states = descriptionSplit[0].split(";");
		 String[] acceptStates = descriptionSplit[1].split(",");
		 this.states = states;
		 this.acceptStates = acceptStates;
	}

	/**
	 * Returns a string of actions.
	 * 
	 * @param input is the string to simulate by the FDFA.
	 * @return string of actions.
	 */
	public String run(String input) {
		// TODO Write Your Code Here
		ArrayList<String> stack = new ArrayList<String>();
		String output = ""; 
		int left = input.length();
		String temp ="";
		String state = "0";
		String[] inputPath = input.split("");
		//System.out.println(input);
		while(input.length()!=0)
		{
			
		state = "0";
		stack = new ArrayList<String>();
		left = input.length();
		inputPath = input.split("");
		for (int i = 0 ; i < inputPath.length ; i++ )
		{
			
			//System.out.println("input "+inputPath[i]+" state "+ state+" ");
			for (int j = 0 ; j < states.length ; j++ )
			{
				String[] checkState = states[j].split(",");
			//	System.out.println("Input String "+input+" CurrentInput "+inputPath[i]+" My Current STate "+state + " My check state "+checkState[0]);
				if (state.equals(checkState[0]))
				{
								
					
					
					if((inputPath[i]).equals("0"))
					{
						state = checkState[1];
						break;
					}
					else
					{
				
						state = checkState[2];
						break;
						
					}
					
				}
			}
			stack.add(state);
		}
		boolean found = false ;
		for(int y = stack.size()-1 ; y>=0 && !found ; y--)
		{

			boolean added = false ;
			for (int i = 0 ; i < acceptStates.length  && !added ; i++ )
			{
				if ((stack.get(y)).equals(acceptStates[i]))
				{
					found = true ;
					output += input.substring(0, left);
					temp = input.substring(left, input.length());
					output += ",";
					
					for (int j = 0 ; j < states.length && !added ; j++ )
					{
						String[] checkState = states[j].split(",");
						if (checkState[0].equals(stack.get(y))&& !added)
						{
							added = true;
							output +=checkState[3];
							System.out.println(checkState[3]);
							break;
						}
					}
					output += ";";
					input = temp ;
					left = temp.length();
					System.out.println("input: "+input);
					y=-1;
				
				}
				
			}
			left -- ;
		}
		if(found == false)
		{
			
			output+= input ;
			output += ",";
			input = "";
			boolean added = false ;
			for (int i = 0 ; i < acceptStates.length && !added   ; i++ )
			{
				
					for (int j = 0 ; j < states.length && !added  ; j++ )
					{
						String[] checkState = states[j].split(",");
						if (checkState[0].equals(stack.get(stack.size()-1))&& !added)
						{
							added = true;
							output +=checkState[3];
							break;
						}
					}
					
			
				
				
			}
			output += ";";
		//	System.out.println(output);
		}
		left = temp.length();

		}
		System.out.println(output);
		return output;
		
		
	}
	public static void main (String[] args)
	{
		FDFA fdfa2 = new FDFA("0,0,1,N;1,2,1,A;2,3,0,B;3,3,0,O#1,2");
		fdfa2.run("011000");
	//	"0110,B;00,N;"
	}
}
