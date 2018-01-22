import java.util.Stack;
//import javax.xml.soap.Node;


public class Homework1 {
	public static Stack<String> stack1 = new Stack<String>() ;
	public static Node ABNode ;
	public static String InputM ;
	public static Character InputN ;

	public static void main(String[] args) {
		// Begin of arguments input sample
		//InputN = InputM.toString() ;
		//InputM="251-*32*+";
		InputM = "55+" ;
		for ( int i = 0 ; i < InputM.length() ; i++ ) {
			stack1.push(InputM.substring(i,i+1)) ;
		}
		ABNode = new Node(stack1.pop());
		Infix(ABNode);
		Inorder(ABNode);
		System.out.print("=" + Calculate(ABNode));
//		if (args.length > 0) {
//			String input = args[0];
//			if (input.equalsIgnoreCase("251-*32*+")) {
//				System.out.println("(2*(5-1))+(3*2)=14");
//			}
//		}
		// End of arguments input sample

		// TODO: Implement your project here


	}
	public static void Infix ( Node ANode){
		if ( ANode.F.equalsIgnoreCase("+") || ANode.F .equalsIgnoreCase("-") || ANode.F.equalsIgnoreCase("*") || ANode.F.equalsIgnoreCase("/")){
			ANode.Right = new Node(stack1.pop());
			Infix(ANode.Right);
			ANode.Left = new Node(stack1.pop());
			Infix(ANode.Left);
		}
	}

	public static void Inorder (Node BNode){
	     //if (( BNode.Left.toString().equalsIgnoreCase("+") || BNode.Left.toString().equalsIgnoreCase("-") || BNode.Left.toString().equalsIgnoreCase("*") || BNode.Left.toString().equalsIgnoreCase("/")) && (BNode.Right.toString().equalsIgnoreCase("+") || BNode.Right.toString().equalsIgnoreCase("-") || BNode.Right.toString().equalsIgnoreCase("*") || BNode.Right.toString().equalsIgnoreCase("/"))) {
            if ( BNode.F.toString().equalsIgnoreCase("+") || BNode.F.toString().equalsIgnoreCase("-") || BNode.F.toString().equalsIgnoreCase("*") || BNode.F.toString().equalsIgnoreCase("/")){

            if( BNode!=ABNode )System.out.print("(");
	        Inorder(BNode.Left);
                System.out.print(BNode.F);
	        Inorder(BNode.Right);
                if( BNode!=ABNode )System.out.print(")");
        }
        else
            {
                System.out.print(BNode.F);
            }
    }

	public static int Calculate ( Node CNode){
		int sum = 0 ;
		/*if (( CNode.F.equalsIgnoreCase("+") || CNode.F.equalsIgnoreCase("-") || CNode.F == "*" || CNode.F == "/" ) && ( CNode.F == "+" || CNode.F == "-" || CNode.F == "*" || CNode.F == "/" )){

               sum =      Calculate(CNode.Left) + Calculate(CNode.Right);
               return sum;
		}else{

		    sum = Integer.parseInt(CNode.F.toString());
		    return sum;

        }*/

		char [] x = CNode.F.toCharArray();

		if(x[0] == '+'){

		    return Calculate(CNode.Left) + Calculate(CNode.Right);
        }else if(x[0] == '-'){

            return Calculate(CNode.Left) - Calculate(CNode.Right);
        }else if(x[0] == '*'){
            return Calculate(CNode.Left) * Calculate(CNode.Right);

        }else if(x[0] == '/'){
            return Calculate(CNode.Left) / Calculate(CNode.Right);

        }else return Integer.parseInt(String.valueOf(x[0]));
	}
}
