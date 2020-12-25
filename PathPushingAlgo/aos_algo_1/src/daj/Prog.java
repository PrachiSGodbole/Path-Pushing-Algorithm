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

// --------------------------------------------------------------------------
// called for	initialization of program
// --------------------------------------------------------------------------
public Prog(int i,char a)
{ 
 number = i;	
 msg = null;
 sent = false;
 name =a;
} 

// --------------------------------------------------------------------------
// called for	 execution of program
// --------------------------------------------------------------------------
public void main()
{ 
 if (number == 0)
   {
	out(0).send(new Msg("exAB"));
	sent = true;
   }
 if (number == 1)
 {
	 out(1).send(new Msg("exAB"));
	 sent = true;
 }
 GlobalAssertion assertion = new NumberOfMessages();
 for (int i = 0; i < 5; i++)
   {
	//test(assertion);
	index = in().select();
	msg = in(index).receive();
	out(index).send(msg);
	msg = null;
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
