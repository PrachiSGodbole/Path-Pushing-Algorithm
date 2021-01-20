package daj;

//----------------------------------------------------------------------------
//
//a program class
//
//----------------------------------------------------------------------------
class Prog extends Program
{
private int number;
public int index;
public Message msg;
public boolean sent;
public char name;
public char prev;
public char nxt;
public static boolean flag = true;
public static boolean flag0 = true;
public static boolean flags[] = {true, true, true};
public static int count =0;

// --------------------------------------------------------------------------
// called for	initialization of program
// --------------------------------------------------------------------------
public Prog(int i,char a,char b,char c)
{ 
 number = i;	//node number
 msg = null;	//message
 sent = false;
 name = a;		//name of node
 prev = b;		//name of node waiting for resources from current node
 nxt = c;		//name of node from which the current node is requesting resources
 flag = true;
 flag0 = true;
 flags[0] =true ;
 flags[1] =true ;
 flags[2] =true ;
} 

// --------------------------------------------------------------------------
// called for execution of program
// --------------------------------------------------------------------------
public void main()
{ 
	GlobalAssertion assertion = new NumberOfMessages();
	
	// program will run till deadlock is detected
	while(flag) {
		
		test(assertion); // test for number of messages
		
		if (number == 0)
		   {
			if(flag0) {
				String m = prev == 'x' ? "ex"+name+nxt : prev + name+"ex";
				out(0).send(new Msg(m));	//message sent to next site
				flag0 = false;
			}
			index = in().select();
			msg = in(index).receive();	//message received
			// the message from first site reaches it again ie the global WFG is complete
			if(msg != null && msg.getText().startsWith("ex"+name+nxt)) {
				flag = false;	
				//break;
			}
			sent = true;
			out(0).send(new Msg("exAB"));
			if(!flag) break;
		   }
		if(number%2 == 1) {
			index = in().select();
			 msg = in(index).receive();		//message received
			 if(msg != null ) {
			 out(0).send(new Msg(msg.getText()+"ex"));	//appended message sent to next site
			 sent = true;
			 }
		}
		if (number%2 == 0 & number !=0)
		 {
			if(flags[count]) {
				String m = prev == 'x' ? "ex"+name+nxt : prev + name+"ex";
				out(0).send(new Msg(m));
				flags[count] = false;
				count = count<3? count++: count;
			}else {
				index = in().select();
				 msg = in(index).receive();		//message received
				 if(msg != null ) {
				 out(0).send(new Msg(msg.getText().substring(0, msg.getText().length() - 2)+name+nxt)); //appended message sent to next site
				 sent = true;
				 }
			}
			 sent = true;
		 }
	}
}

// --------------------------------------------------------------------------
// called for	display of program state
// --------------------------------------------------------------------------
public String getText()
{
 String msgString;
 if (msg == null)
   msgString = "(null)";
 else
   msgString = msg.getText();
 return 
   "sent: " + String.valueOf(sent) +
   "\nmsg: " + msgString;
}
}