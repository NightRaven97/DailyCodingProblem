package handson;


// Class to represent the nodes of syntax tree 

class nod
{   	
	nod left;
	nod right;
	int data;
	nod(char value)
	{
        left = null;
        data = value;
        right = null;
	}
}
public class EvaluationTree_day50
{
	

// This function receives a node of the syntax tree 
// and recursively evaluate it 
static nod root;
public static int evaluateExpressionTree(nod root)
{

    // empty tree 
    if (root == null) 
        return 0;
  
    //leaf node 
    if( (root.left == null) && (root.right == null) )
    {
    	int val=Character.getNumericValue(root.data);
    	return val;
    }
  
    //evaluate left tree 
    int left_sum = evaluateExpressionTree(root.left) ;
  
    // evaluate right tree 
    int right_sum = evaluateExpressionTree(root.right) ;
  
    // check which operation to apply 
    if (root.data == '+') 
        return left_sum + right_sum ;
      
    else if( root.data == '-') 
        return left_sum - right_sum ;
      
    else if (root.data == '*') 
        return left_sum * right_sum ;
      
    else 
        return (left_sum / right_sum );
}

// Driver function to test above problem 
public static void main(String arg[])
{

    //EvalTree e=new EvalTree();  
    // creating a sample tree 
    root = new nod('+');
    root.left =new nod('*') ;
    root.left.left =new nod('5') ;
    root.left.right =new nod('4'); 
    root.right = new nod('-') ;
    root.right.left =new nod('2') ;
    root.right.right =new nod('1'); 
    System.out.println( evaluateExpressionTree(root)); 
    
   /* root = None
  
    #creating a sample tree 
    root = node('+') 
    root.left = node('*') 
    root.left.left = node('5') 
    root.left.right = node('4') 
    root.right = node('-') 
    root.right.left = node('100') 
    root.right.right = node('/') 
    root.right.right.left = node('20') 
    root.right.right.right = node('2') 
    print evaluateExpressionTree(root) 
  */
}
}
