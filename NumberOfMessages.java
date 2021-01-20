package daj;

//---------------------------------------------------------------------------------------
//
//global assertion stating that at most one message is in a particular channel at a time
//
//----------------------------------------------------------------------------------------
class NumberOfMessages extends GlobalAssertion
{
int count;

public String getText()
{
 return "invalid count of messages: " + 
   String.valueOf(count);
}


@Override
public boolean test(Program[] prog) {
	// TODO Auto-generated method stub
	 if (null == ((Prog)prog[0]).msg) return true; //initial condition
	 count = 0;
	 
	Prog program = (Prog)prog[0];
	count += getMessages(program.out(0)).length; //counts number of messages in a channel
		
	   
	 return count == 1 || count == 0;  //returns false if more than one message is in a channel
}
}
