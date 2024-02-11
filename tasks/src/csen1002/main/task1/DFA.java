package csen1002.main.task1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

/**
 * Write your info here
 * 
 * @name mahmoud khalid zakria
 * @id 43-15405
 * @labNumber 10
 */

public class DFA {
	
	 String[] states ;
	 String[] acceptStates ;
	 
	public DFA(String description) {
		// TODO Write Your Code Here
		 String[] descriptionSplit = description.split("#");
		 String[] states = descriptionSplit[0].split(";");
		 String[] acceptStates = descriptionSplit[1].split(",");
		 this.states = states;
		 this.acceptStates = acceptStates;
		
	}

	/**
	 * Returns true if the string is accepted by the DFA and false otherwise.
	 * 
	 * @param input is the string to check by the DFA.
	 * @return if the string is accepted or not.
	 */
	public boolean run(String input) {
		// TODO Write Your Code Here
		String state = "0";
		String[] inputPath = input.split("");
		//System.out.println(input);
		for (int i = 0 ; i < inputPath.length ; i++ )
		{
			//System.out.println("input "+inputPath[i]+" state "+ state+" ");
			for (int j = 0 ; j < states.length ; j++ )
			{
				String[] checkState = states[j].split(",");
			//	System.out.println("Input String "+input+" CurrentInput "+inputPath[i]+" My Current STate "+state + " My check state "+checkState[0]);
				if (state.equals(checkState[0]))
				{
					System.out.print(checkState[0]+",");
					System.out.print(checkState[1]+",");
					System.out.print(checkState[2]+",");
					
					
					if((inputPath[i]).equals("0"))
					{
						System.out.println(" going to " + checkState[1] );
						state = checkState[1];
						break;
					}
					else
					{
						System.out.println(" going to " + checkState[2] );
						state = checkState[2];
						break;
						
					}
					
				}
			}
		}
		for (int i = 0 ; i < acceptStates.length ; i++ )
		{
			if (state.equals(acceptStates[i]))
			{
				System.out.println("true");
				return true;
			}
		}
		System.out.println("false");
		return false;
		}
	
public static void main (String[] args)
{
	DFA dfa1 = new DFA("0,0,1;1,2,1;2,0,3;3,3,3#1,3");
	dfa1.run("01010100");
}
}