import java.util.concurrent.atomic.AtomicBoolean;


public class Node
{
	public static final int K = 4;
	public static final int NUM_OF_KEYS_IN_A_NODE= K-1;
	public static final int NUM_OF_CHILDREN_FOR_A_NODE= K;
	long keys[];
	Node[] childrenArray;
	AtomicBoolean isLocked;
	boolean isMarked;

	public Node()
	{
	}
	
	public Node(long[] keys, String nodeType)
	{
		this.keys = new long[NUM_OF_KEYS_IN_A_NODE];
		for(int i=0;i<NUM_OF_KEYS_IN_A_NODE;i++)
		{
			this.keys[i] = keys[i];
		}
		if(nodeType.equalsIgnoreCase("internalNode"))
		{
			this.isLocked = new AtomicBoolean(false);
			this.isMarked = false;
			childrenArray = new Node[NUM_OF_CHILDREN_FOR_A_NODE];
			for(int i=0;i<NUM_OF_CHILDREN_FOR_A_NODE;i++)
			{
				childrenArray[i] = new SpecialNode();
			}
		}
	}
}
