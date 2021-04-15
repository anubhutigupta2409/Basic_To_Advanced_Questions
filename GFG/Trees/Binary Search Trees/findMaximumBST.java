class findMaximumBST
{
    Node max(Node node)
    {
        if(node==null || node.right==null)
            return node;
            
        return min(node.right);
    }
    int maxValue(Node node)
    {
        return min(node).data;
    }
}