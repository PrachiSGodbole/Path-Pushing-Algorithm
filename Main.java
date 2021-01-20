package daj;

//----------------------------------------------------------------------------
//
//the application itself
//
//----------------------------------------------------------------------------
public class Main extends Application
{
// --------------------------------------------------------------------------
// main function of application
// --------------------------------------------------------------------------
public static void main(String[] args)
{
 new Main().run();
}

// --------------------------------------------------------------------------
// constructor for application
// --------------------------------------------------------------------------
public Main()
{
 super("Path Pushing Algorithm", 400, 300);
}

// --------------------------------------------------------------------------
// construction of network
// --------------------------------------------------------------------------
public void construct()
{
	
// --------------------------------------------------------------------------
// construction of nodes
// --------------------------------------------------------------------------
// Node node0_0 = node(new Prog2(0,'A'), "A", 100, 100);
// Node node0_1 = node(new Prog2(1,'B'), "B", 150, 100);
// 
// Node node1_0 = node(new Prog2(2,'C'), "C", 300, 100);
// Node node1_1 = node(new Prog2(3,'D'), "D", 350, 100);
// 
// Node node2_0 = node(new Prog2(4,'E'), "E", 350, 200);
// Node node2_1 = node(new Prog2(5,'F'), "F", 300, 200);
// 
// Node node3_0 = node(new Prog2(6,'G'), "G", 150, 200);
// Node node3_1 = node(new Prog2(7,'H'), "H", 100, 200);
	
	Node node0_0 = node(new Prog(0,'A', 'x', 'B'), "A", 100, 100);
	Node node0_1 = node(new Prog(1,'B', 'A', 'x'), "B", 150, 100);

	Node node1_0 = node(new Prog(2,'C', 'x', 'D'), "C", 300, 100);
	Node node1_1 = node(new Prog(3,'D', 'C', 'x'), "D", 350, 100);

	Node node2_0 = node(new Prog(4,'E', 'x', 'F'), "E", 350, 200);
	Node node2_1 = node(new Prog(5,'F', 'E', 'x'), "F", 300, 200);

	Node node3_0 = node(new Prog(6,'G', 'x', 'H'), "G", 150, 200);
	Node node3_1 = node(new Prog(7,'H', 'G', 'x'), "H", 100, 200);
 
//--------------------------------------------------------------------------
//construction of communication links
//--------------------------------------------------------------------------
 link(node0_0, node0_1);
 link(node0_1, node1_0);
 link(node1_0, node1_1);
 link(node1_1, node2_0);
 link(node2_0, node2_1);
 link(node2_1, node3_0);
 link(node3_0, node3_1);
 //link(node3_1, node1_0);
 link(node3_1, node0_0);

}

// --------------------------------------------------------------------------
// informative message
// --------------------------------------------------------------------------
public String getText()
{
 return "Path Pushing Algo:\n \n" +
   "detecting deadlock in distributed system\n" +
   "by using local WFG.";
}

@Override
public void resetStatistics() {
	// TODO Auto-generated method stub
	
}
}

