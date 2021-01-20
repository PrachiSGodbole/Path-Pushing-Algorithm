package daj;

//----------------------------------------------------------------------------
//
//a program class
//
//----------------------------------------------------------------------------
class Prog2 extends Program
{
private int number;
public int index;
public Message msg;
public boolean sent;
public char name;
public static boolean flag = true;
public static boolean flag0 = true;
public static boolean flag1 = true;
public static boolean flag2 = true;
public static boolean flag3 = true;

// --------------------------------------------------------------------------
// called for	initialization of program
// --------------------------------------------------------------------------
public Prog2(int i,char a)
{ 
 number = i;	
 msg = null;
 sent = false;
 name = a;
 flag = true;
 flag0 = true;
 flag1 = true;
 flag2 = true;
 flag3 = true;
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
				out(0).send(new Msg("exAB"));	//message sent to next site
				flag0 = false;
			}
			index = in().select();
			msg = in(index).receive();	//message received
			// the message from first site reaches it again ie the global WFG is complete
			if(msg != null && msg.getText().startsWith("exAB")) {
				flag = false;	
			}
			sent = true;
			out(0).send(new Msg("exAB"));
		   }
		if(number == 1) {
			index = in().select();
			 msg = in(index).receive();		//message received
			 if(msg != null ) {
			 out(0).send(new Msg(msg.getText()+"ex"));	//appended message sent to next site
			 sent = true;
			 }
		}
		if (number == 2)
		 {
			if(flag1) {
				out(0).send(new Msg("exCD"));
				flag1 = false;
			}else {
				index = in().select();
				 msg = in(index).receive();		//message received
				 if(msg != null ) {
					 // the message from first site reaches it again ie the global WFG is complete
					 if(msg != null && msg.getText().startsWith("exCD")) {
							flag = false;	
						}
				 out(0).send(new Msg(msg.getText().substring(0, msg.getText().length() - 2)+"CD")); //appended message sent to next site
				 sent = true;
				 }
			}
			 sent = true;
		 }
		if (number == 3)
		 {
			index = in().select();
			 msg = in(index).receive();		//message received
			 if(msg != null ) {
			 out(0).send(new Msg(msg.getText()+"ex"));	//appended message sent to next site
			 sent = true;
			 }
		 }
		if (number == 4)
		 {
			if(flag2) {
				out(0).send(new Msg("exEF"));
				flag2 = false;
			}else {
				index = in().select();
				 msg = in(index).receive();		//message received
				 if(msg != null ) {
				 out(0).send(new Msg(msg.getText().substring(0, msg.getText().length() - 2)+"EF")); //appended message sent to next site
				 sent = true;
				 }
			}
			 sent = true;
		 }
		if (number == 5)
		 {
			index = in().select();
			 msg = in(index).receive();		//message received
			 if(msg != null ) {
			 out(0).send(new Msg(msg.getText()+"ex"));	//appended message sent to next site
			 sent = true;
			 }
		 }
		if (number == 6)
		 {
			if(flag3) {
				out(0).send(new Msg("exGH"));
				flag3 = false;
			}else {
				index = in().select();
				 msg = in(index).receive();		//message received
				 if(msg != null ) {
				 out(0).send(new Msg(msg.getText().substring(0, msg.getText().length() - 2)+"GH")); //appended message sent to next site
				 sent = true;
				 }
			}
			 sent = true;
		 }
		if (number == 7)
		 {
			index = in().select();
			 msg = in(index).receive();		//message received
			 if(msg != null ) {
			 out(0).send(new Msg(msg.getText()+"ex"));	//appended message sent to next site
			 sent = true;
			 }
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