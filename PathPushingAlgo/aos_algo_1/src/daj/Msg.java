package daj;

//----------------------------------------------------------------------------
//
//a message class
//
//----------------------------------------------------------------------------
class Msg extends Message
{
int val;
String m;
public Msg(String ip)
{
 m = ip;
}
public int value()
{
 return val;
}
public String getText()
{
 return  m;
}
}

