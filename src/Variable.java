public class Variable extends Node 
{
    private int index;
    public Variable(int i) 
    {
        index = i;
    }
    public double eval(double[] values) 
    {
        return values[index];
    }

    @Override
    public String toString() 
    {
        return "X" + index;
    }
}
