
/**
 * Code Template Authors: Dr. Stephen Roehrig
 *                        and David G. Cooper
 * Submission by:
 * Date:
 * Purpose: Test the Plus Binop
 */
public class TestAlgebra 
{
    public static void main(String[] args) 
    {
        Node node1;
        Node node2;
        Node node3;
        Node node4;

        Node operationLeft;
        Node operationRight;
        Node operationMain;

        double[] set1 = {1.0,2.0,3.0};
        double[] set2 = {4.0,5.0,6.0};

        for(int i = 1 ; i <= 4 ; i++)
        {
            TestAlgebra TA = new TestAlgebra();
        
            node1 = TA.generateTerminals();
            node2 = TA.generateTerminals();
            
            node3 = TA.generateTerminals();
            node4 = TA.generateTerminals();
    
            operationLeft = TA.randOperator(node1, node2);
            operationRight = TA.randOperator(node3, node4);
            operationMain = TA.randOperator(operationLeft, operationRight);
            
            System.out.printf("When {X0,X1,X2} =  {1,2,3} :\n" + operationMain + " = %.2f\n", operationMain.eval(set1));
            System.out.printf("When {X0,X1,X2} =  {4,5,6} :\n" + operationMain + " = %.2f\n", operationMain.eval(set2));
        }
    }

    public Const randConstant()
    {
        int randomValue = (int) (Math.random() * (20 - 1) + 1);
        return new Const(randomValue);
    }
    public Binop randOperator(Node l , Node r)
    {
        int randomValue = (int) (int) (Math.random() * (4 - 1) + 1);;
        switch(randomValue)
        {
            case 1 : return new Plus(l,r);
            case 2 : return new Minus(l,r);
            case 3 : return new Divide(l,r);
            case 4 : return new Mult(l,r);
            default : return null;
        }
    }
    public char flipCoin()
    {
        int randomValue = (int) ( Math.random() * 2 + 1);
        switch(randomValue)
        {
            case 1 : return 'h';
            case 2 : return 't';
            default : return '!';
        }
    }
    public Node generateTerminals()
    {
        Node node;

        if(flipCoin() == 'h')
        {
            node = randConstant();
        }
        else
        {
            node = new Variable((int) (Math.random() * 2 + 0));
        }

        return node;
    }
}
