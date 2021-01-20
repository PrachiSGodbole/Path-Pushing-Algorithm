package daj;

//----------------------------------------------------------------------------
//
//global assertion stating that two messages are floating around
//
//----------------------------------------------------------------------------
class NumberOfMessages extends GlobalAssertion
{
int count;

public String getText()
{
 return "invalid count of messages: " + 
   String.valueOf(count);
}

//public boolean assert(Program prog[])
//{
// if (!((Prog)prog[0]).sent) return true;
// count = 0;
// for (int j = 0; j < prog.length; j++)
//   {
//	Prog program = (Prog)prog[j];
//	count += getMessages(program.out(0)).length;
//	count += getMessages(program.out(1)).length;
//	if (program.msg != null) count++;
//   }
// return count == 2;
//}
@Override
public boolean test(Program[] prog) {
	// TODO Auto-generated method stub
	 if (!((Prog)prog[0]).sent) return true;
	 count = 0;
	 for (int j = 0; j < prog.length; j++)
	   {
		Prog program = (Prog)prog[j];
		count += getMessages(program.out(0)).length;
		count += getMessages(program.out(1)).length;
		if (program.msg != null) count++;
	   }
	 return count == 2;
}
}
